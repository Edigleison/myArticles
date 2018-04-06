package com.edigleison.myarticles.service;

import java.util.List;

import com.edigleison.myarticles.entity.User;

public interface UserService {

	User findById(Long id);
	List<User> findAll();
	User save(User user);
	void delete(User user);

	
}
