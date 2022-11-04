package com.smartcity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "details", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Details {

	

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	private String category;
	private String name;
	private String city_name;
	private String image;
	private Long user_id;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long uid) {
		this.user_id = uid;
	}
	@Override
	public String toString() {
		return "Details [id=" + id + ", category=" + category + ", name=" + name + ", city_name=" + city_name
				+ ", image=" + image + ", user_id=" + user_id + "]";
	}

	
	
}
