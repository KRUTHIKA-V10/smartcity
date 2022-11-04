package com.smartcity.service;

import java.util.List;

import com.smartcity.model.Details;

public interface DetailsService {

	

	Details saveDetails(Details details);
	List<Details> getAllDetails();
	Details getDetailsById(Integer detailsid);
	Details updateDetails(Details details, Integer detailsid);
	void deleteDetails(Integer detailsid);
	List<Details>showAllDetails();
	List<Details> searchResult(String keyword);
    List<Details> getByUserId(Long userid);


}
