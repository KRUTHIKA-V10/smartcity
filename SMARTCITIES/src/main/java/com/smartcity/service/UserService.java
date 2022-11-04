package com.smartcity.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smartcity.dto.UserRegistrationDto;
import com.smartcity.model.User;

public interface UserService extends UserDetailsService {
	
//	User saveUser(User user);
//	List<User> getAllUsers();
//	User getUserById(Integer id);
	User updateUser(String image, Long id);
//	void deleteUser(Integer id);
	
	User save(UserRegistrationDto registrationDto);
	UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
	UserDetails findUserByUsername(String firstName) throws UsernameNotFoundException;
}
