package com.smartcity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcity.exception.ResourceNotFoundException;
import com.smartcity.model.Admin;
import com.smartcity.repository.AdminRepository;
import com.smartcity.service.AdminService;

@Service
public class AdminServiceImp implements AdminService{

	private AdminRepository adminRepo;
	
	@Autowired
	public AdminServiceImp(AdminRepository adminRepo) {
		super();
		this.adminRepo = adminRepo;
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepo.save(admin);
	}
	public Admin get(int adminid) {
		return adminRepo.findById(adminid).get();
	}
	public void delete(int adminid) {
		adminRepo.deleteById(adminid);
	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	@Override
	public Admin getAdminById(Integer adminid) {
		// TODO Auto-generated method stub
		return adminRepo.findById(adminid).orElseThrow(() -> new ResourceNotFoundException("Admin","Id",adminid));
	}

	@Override
	public Admin updateAdmin(Admin admin, Integer adminid) {
		// TODO Auto-generated method stub
		Admin existingAdmin = adminRepo.findById(adminid).orElseThrow(() -> new ResourceNotFoundException("Admin", "Id", adminid));
		existingAdmin.setEmail(admin.getEmail());
		existingAdmin.setPassword(admin.getPassword());
		adminRepo.save(existingAdmin);
		return existingAdmin;	}

	@Override
	public void deleteAdmin(Integer adminid) {
		// TODO Auto-generated method stub
		Admin existingAdmin = 	adminRepo.findById(adminid).orElseThrow(() -> new ResourceNotFoundException("admin", "Id", adminid));
		adminRepo.deleteById((int) adminid);
		
	}

}
