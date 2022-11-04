package com.smartcity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartcity.model.Admin;



public interface AdminRepository extends JpaRepository<Admin,Integer> {
	
	Admin findByEmailAndPassword(String email, String password);

	//Optional<Admin> findById(Integer adminid);

}
