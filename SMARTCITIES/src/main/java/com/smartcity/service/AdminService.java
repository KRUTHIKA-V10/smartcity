package com.smartcity.service;

import java.util.List;

import com.smartcity.model.Admin;

public interface AdminService {
	
	Admin saveAdmin(Admin admin);
	List<Admin> getAllAdmins();
	Admin getAdminById(Integer adminid);
	Admin updateAdmin(Admin admin, Integer adminid);
	void deleteAdmin(Integer adminid);

}
