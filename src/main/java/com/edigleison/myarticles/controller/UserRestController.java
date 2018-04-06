package com.edigleison.myarticles.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edigleison.myarticles.entity.Aticle;
import com.edigleison.myarticles.entity.User;
import com.edigleison.myarticles.service.ArticleService;
import com.edigleison.myarticles.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private ArticleService postService;
	
	@GetMapping("/")
	public List<User> listAll(){
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = userService.findById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		user = userService.save(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable final Long id){
		User user = userService.findById(id);
		userService.delete(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable final Long id, @Valid @RequestBody final User user){
		User currentUser = userService.findById(id);
		currentUser.setName(user.getName());
		currentUser.setEmail(user.getEmail());
		
		currentUser = userService.save(currentUser);
		return new ResponseEntity<>(currentUser, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Aticle>> listAllPosts(@PathVariable Long id){
		User user = userService.findById(id);
		List<Aticle> posts = postService.findByUser(user);
		
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
}
