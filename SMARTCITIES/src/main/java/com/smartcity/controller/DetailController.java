package com.smartcity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smartcity.model.Admin;
import com.smartcity.model.Details;
import com.smartcity.model.User;
import com.smartcity.service.AdminService;
import com.smartcity.service.DetailsService;
import com.smartcity.service.UserService;
import com.smartcity.service.impl.UserServiceImpl;

@RestController
public class DetailController {
	

	
	
//	private DetailsService detailService;
	private DetailsService detailsService;
	private UserServiceImpl userServiceImpl;
	private UserService userService;

	
	public DetailController(DetailsService detailService,UserServiceImpl userServiceImpl ,UserService userService) {
		super();
		this.detailsService = detailService;
		this.userServiceImpl=userServiceImpl;
		this.userService=userService;
	}

	

	
	@PostMapping("/saveDetails")
	public ResponseEntity<Details> saveDetail(@RequestBody Details details) {
		return new ResponseEntity<Details>(detailsService.saveDetails(details), HttpStatus.CREATED);
	}
	@GetMapping("/Details")
	public List<Details> getDetails() {
		
		return detailsService.getAllDetails();
	}
	
	@GetMapping("/Details/{id}")
	public ResponseEntity<Details> getDetailsById(@PathVariable("id") Integer detailid) {
		return new ResponseEntity<Details>(detailsService.getDetailsById(detailid), HttpStatus.OK);	
	}
	
	@PutMapping("/Details/updateDetails/{id}")
	public ResponseEntity<Details> updateDetails(@PathVariable("id") Integer id, @RequestBody Details details) {
		return new ResponseEntity<Details>(detailsService.updateDetails(details, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/Details/deleteDetails/{id}")
	public ResponseEntity<String> deleteDetails(@PathVariable("id") Integer id) {
		detailsService.deleteDetails(id);
		return new ResponseEntity<String>("details deleted successfully", HttpStatus.OK);
	}
	
//	@GetMapping
//	public List<Details> list(@RequestParam int size, @RequestParam int page, @RequestParam String search, Model model){     
//	    Page<Details> pageableArticales = DetailRepository.findAll(searchDetailSpecification(search), PageRequest.of(page, limit);
//	    return pageableArticales.getContent();
//	}
	
	
	/*
	 * @GetMapping("/homepage") public String homePage(Model model ) {
	 * 
	 * List<Details> listEmp = detailService.showAllDetails();
	 * model.addAttribute("listEmp", listEmp); return "home"; }
	 */
	
	@GetMapping("/homepage")
	public ModelAndView homePage(HttpServletRequest request,ModelAndView model )
	{

		List<Details> listEmp = detailsService.showAllDetails();
		model.addObject("results", listEmp);
		model.setViewName("dashboard");
		return model;
	}
	
	

	

	
	@GetMapping("/search")
	public ModelAndView search(HttpServletRequest request,ModelAndView model,@Param("keyword") String keyword)
	{
		List<Details> listStd = detailsService.searchResult(keyword);
		model.addObject("results", listStd);
		model.addObject("keyword",keyword);
		model.setViewName("dashboard");
		System.out.println(listStd);
		return model;
	}
	
	/*
	 * @PostMapping("/saveDetail") public ModelAndView saveDetail(Details
	 * details,ModelAndView model) { detailService.saveDetails(details);
	 * List<Details> detailList = detailService.getAllDetails();
	 * //m.addAttribute("detailsList", detailList); model.addObject("detailsList",
	 * detailList); model.setViewName("dashboard"); return model; }
	 */

@GetMapping("/addPost")
	public ModelAndView newPostPage(ModelAndView model, HttpSession session) {
		Details detail = new Details();
		model.addObject(detail);
		model.setViewName("new_post");
		session.setAttribute("msg", "Data Added Successfully...");
		return model;
	}
@PostMapping("/saveDetail")
public String saveStudent(Details details,Model m) {
	System.out.println("uuuuu"+userServiceImpl.uid);
  //  Details d=new Details();
    details.setUser_id(userServiceImpl.uid);
	detailsService.saveDetails(details);
	List<Details> detailsList = detailsService.getAllDetails();
	m.addAttribute("detailsList", detailsList);
	return "success";
}

@GetMapping("/delteByid/{id}")
public String deleteById(@PathVariable("id") Integer id,Model model) {

	detailsService.deleteDetails(id);

	return "success";
}

@GetMapping("/bookcab")
public ModelAndView bookcab(ModelAndView model)
{
	model.setViewName("bookcab");
	
	return model;
}
}
