package com.smartcity.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smartcity.dto.UserRegistrationDto;
import com.smartcity.model.Details;
import com.smartcity.model.User;
import com.smartcity.repository.UserRepository;
import com.smartcity.service.DetailsService;
import com.smartcity.service.UserService;
import com.smartcity.service.impl.UserServiceImpl;

@Controller
public class UserRegistrationController {
	private UserService userService;
	private UserRepository userRepository;
   private DetailsService detailsService;
	
private UserServiceImpl userServiceImpl;
	

	public UserRegistrationController(UserService userService,DetailsService detailService,UserServiceImpl userServiceImpl) {
		super();
		this.userService = userService;
       this.detailsService=detailService;
       this.userServiceImpl=userServiceImpl;
	}

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	@GetMapping("/registration")
	public String showRegistrationForm() {
		return "register";
	}

	@PostMapping("/registration")
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {

		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
	/*
	 * @GetMapping("/") public String login() {
	 * 
	 * return "welcomepage"; }
	 */

	@GetMapping("/login")
	public String login() {
		//model.addAttribute("user",usRegistrationDto);

		return "login";
	}
	@GetMapping("/logout")
	public String logout() {

		return "login";
	}

//	@GetMapping("/")
//	public String home() {
//		return "home";
//	}

	@PostMapping("/registersubmit")
	public String registersubmit(UserRegistrationDto user) {
		userService.save(user);

		return "login";
	}

	@RequestMapping(value = "/loginsubmit", method = RequestMethod.POST)
	public ModelAndView verify( @RequestParam("email") String email, @RequestParam("password") String password,ModelAndView model) {
	
		//public String verify(@Valid @ModelAttribute("user") UserRegistrationDto usRegistrationDto, @RequestParam("email") String email, @RequestParam("password") String password,ModelAndView model,BindingResult bindingResult) {

		System.out.println("Form data :" + email + password);
//		 if(bindingResult.hasErrors()) {
//			model.setViewName("login");
//			return model;
//		}
		
		/*
		 * if(bindingResult.hasErrors()) { return "login"; } else { return "dashboard";
		 * }
		 */
		UserDetails user = userService.loadUserByUsername(email);
	//	UserDetails	res=userService.findUserByUsername(email);
		//res.getUsername();
		
         //  User obj= new User();
   //  System.out.println("Hi...."+userServiceImpl.username);  
		
		if (user != null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			System.out.println("hello");

			if (encoder.matches(password, user.getPassword())) {
				System.out.println("hiiiiiiiiiiii");
				List<Details> listEmp = detailsService.showAllDetails();
				System.out.println("list emp"+listEmp+user.getUsername());
				model.addObject("username",userServiceImpl.username);
				model.addObject("results", listEmp);
				model.addObject("image",userServiceImpl.image);

				model.setViewName("dashboard");
				return model;
			}
		}
		
		
		return model;

	}

	
	
	@GetMapping("/profilepage")
	public ModelAndView showProfile(HttpServletRequest request,ModelAndView model) {
		
		model.addObject("username",userServiceImpl.username);
		System.out.println("user.."+userServiceImpl.uid);
		
		List<Details> listEmp = detailsService.getByUserId(userServiceImpl.uid);
		
		model.addObject("results", listEmp);
        
		model.addObject("image",userServiceImpl.image);

		System.out.println("hdhxjsbk"+listEmp);
		model.setViewName("profile");
		return model;
	}
	

@PostMapping("/updateDetails")
public ModelAndView updateDetails(@RequestParam("image") String image,ModelAndView model) {
	model.addObject("username",userServiceImpl.username);
	System.out.println("user.."+userServiceImpl.uid);
	
	List<Details> listEmp = detailsService.getByUserId(userServiceImpl.uid);
	
	model.addObject("results", listEmp);
    
	model.addObject("image",userServiceImpl.image);

	System.out.println("hdhxjsbk"+listEmp);
	System.out.println("hello");
	Long id=userServiceImpl.uid;
	model.addObject( "profileimage",userService.updateUser(image, id));
	model.addObject("image",image);
	model.setViewName("profile");
	return model;
}


	
	@GetMapping("/dashboard")
	public String showDashboard() {
		return "dashboard";
	}
}