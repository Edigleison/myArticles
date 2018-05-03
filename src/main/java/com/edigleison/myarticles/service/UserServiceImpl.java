package com.edigleison.myarticles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edigleison.myarticles.entity.User;
import com.edigleison.myarticles.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
	
	@Override
	public List<User> findAll() {
		List<User> findAll = userRepository.findAll();
		return findAll;
	}

	@Override
	public User save(User user) {
		user = userRepository.save(user);
		return user;
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}
}
