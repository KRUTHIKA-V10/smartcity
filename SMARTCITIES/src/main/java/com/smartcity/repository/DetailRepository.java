package com.smartcity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.smartcity.model.Details;

public interface DetailRepository extends JpaRepository<Details,Integer> {

	Details findById(int id);
//	List<Details> findByUserId(Long user_id);
//	
	@Query("SELECT s FROM Details s WHERE s.user_id = :user_id")
	  public List<Details> getDetailsByUserId(@Param("user_id") Long user_id);
	
	@Query("SELECT v FROM Details v WHERE CONCAT(v.id, v.category, v.city_name, v.image, v.name) LIKE %?1%")
	public List<Details> search(String keyword);

}
