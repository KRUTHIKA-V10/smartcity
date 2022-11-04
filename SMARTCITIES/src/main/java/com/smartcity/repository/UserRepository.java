package com.smartcity.repository;

import java.util.Optional;
import com.smartcity.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
	//Optional<User> findById(long adminId);
//
 User findByEmail(String email);
	 User findByFirstName(String email);
	Optional<User> findById(Long id);

//   Boolean existsByEmail(String email);
//   Boolean existsByName(String firstName);

}
