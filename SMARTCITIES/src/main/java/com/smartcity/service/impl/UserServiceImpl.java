package com.smartcity.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartcity.dto.UserRegistrationDto;
import com.smartcity.exception.ResourceNotFoundException;
import com.smartcity.model.Role;
import com.smartcity.model.User;
import com.smartcity.repository.UserRepository;
import com.smartcity.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	public String username;
	public Long uid;
	public String image;
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), 
	    registrationDto.getLastName(), registrationDto.getEmail(),
		passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}

	@Override
	public User updateUser(String image, Long id) {
		// TODO Auto-generated method stub
		//System.out.println("image :"+user.getImage());
		User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
		//existingUser.setEmail(user.getEmail());
		existingUser.setImage(image);
		userRepository.save(existingUser);
		return existingUser;	
		}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(email);
		 username=user.getFirstName();
		 uid=user.getId();
		 image=user.getImage();
		 System.out.println("uid"+uid);

		if(user == null ) {
			return null;
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}

	@Override
	public UserDetails findUserByUsername(String email)  {
		// TODO Auto-generated method stub
		User user = userRepository.findByFirstName(email);
		//System.out.println("service :"+user.getFirstName());

		if(user == null ) {
			return null;
		}
		return new org.springframework.security.core.userdetails.User(user.getFirstName(), user.getEmail(), mapRolesToAuthorities(user.getRoles()));		
	}


}