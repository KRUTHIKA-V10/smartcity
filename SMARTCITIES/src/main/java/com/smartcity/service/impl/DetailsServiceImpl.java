package com.smartcity.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.smartcity.exception.ResourceNotFoundException;
import com.smartcity.model.Admin;
import com.smartcity.model.Details;
import com.smartcity.model.User;
import com.smartcity.repository.AdminRepository;
import com.smartcity.repository.DetailRepository;
import com.smartcity.service.AdminService;
import com.smartcity.service.DetailsService;

@Service
public class DetailsServiceImpl implements DetailsService{

	private DetailRepository detailRepo;
	


	public DetailsServiceImpl(DetailRepository detailRepo) {
		super();
		this.detailRepo = detailRepo;
	}
	@Override
	public Details saveDetails(Details details) {
		// TODO Auto-generated method stub
		return detailRepo.save(details);
	}
	public Details get(int id) {
		return detailRepo.findById(id);
	}
	public void delete(int detailsid) {
		detailRepo.deleteById(detailsid);
	}

	@Override
	public List<Details> getAllDetails() {
		// TODO Auto-generated method stub
		return detailRepo.findAll();
	}

	@Override
	public Details getDetailsById(Integer detailsid) {
		// TODO Auto-generated method stub
		return detailRepo.findById(detailsid).orElseThrow(() -> new ResourceNotFoundException("Details","Id",detailsid));
	}

	@Override
	public Details updateDetails(Details details, Integer detailsid) {
		// TODO Auto-generated method stub
		Details existingDetails = detailRepo.findById(detailsid).orElseThrow(() -> new ResourceNotFoundException("Details", "Id", detailsid));
		existingDetails.setCategory(details.getCategory());
		existingDetails.setName(details.getName());
		existingDetails.setCity_name(details.getCity_name());
		existingDetails.setImage(details.getImage());
		detailRepo.save(existingDetails);

		return existingDetails;	}

	@Override
	public void deleteDetails(Integer detailsid) {
		// TODO Auto-generated method stub
		Details existingDetails = detailRepo.findById(detailsid).orElseThrow(() -> new ResourceNotFoundException("admin", "Id", detailsid));
		detailRepo.deleteById((int) detailsid);
		
	}
	
	public List<Details> showAllDetails()
	{
		List<Details> detaillist = new ArrayList<>();
		
		for(Details d:detailRepo.findAll())
		{
			detaillist.add(d);
		}
		
		
		return detaillist;
	}
	
	public List<Details> searchResult(String keyword)
	{
		//List<Details> detaillist = new ArrayList<>();
		
		//detaillist= detailRepo.getDetailsByName(city_name);
		
	
		//System.out.println("details"+detaillist);
		if(keyword != null)
		{
			return detailRepo.search(keyword);
		}
		return detailRepo.findAll();
	}
	@Override
	public List<Details> getByUserId(Long userid) {
		// TODO Auto-generated method stub
		
		return detailRepo.getDetailsByUserId(userid);
	}

}
