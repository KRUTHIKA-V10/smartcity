package com.smartcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smartcity.model.Admin;
import com.smartcity.service.AdminService;

@RestController
public class AdminController {
	

	
	
	private AdminService adminService;

	@Autowired
	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	@PostMapping("/saveAdmin")
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.saveAdmin(admin), HttpStatus.CREATED);
	}
	@GetMapping("/Admins")
	public List<Admin> getAdmins() {
		return adminService.getAllAdmins();
	}
	
	@GetMapping("/Admins/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("id") Integer AdminId) {
		return new ResponseEntity<Admin>(adminService.getAdminById(AdminId), HttpStatus.OK);	
	}
	
	@PutMapping("/Admins/updateAdmin/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id") Integer id, @RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/Admins/deleteAdmin/{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("id") Integer id) {
		adminService.deleteAdmin(id);
		return new ResponseEntity<String>("Admin deleted successfully", HttpStatus.OK);
	}
	
}
