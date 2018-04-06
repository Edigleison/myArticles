package com.edigleison.myarticles.controller;

import java.util.Calendar;
import java.util.List;

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
@RequestMapping("/api/article")
public class ArticleRestController {

	@Autowired
	private ArticleService postService;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<List<Aticle>> listAllArticles() {

		List<Aticle> list = postService.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aticle> findById(@PathVariable Long id) {

		Aticle post = postService.findById(id);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Aticle> deleteArticle(@PathVariable Long id) {
		Aticle post = postService.findById(id);
		postService.delete(post);
		return new ResponseEntity<Aticle>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(value = "/")
	public ResponseEntity<Aticle> createArticle(@RequestBody Aticle post) {

		User user = userService.findById(post.getUser().getId());
		post.setUser(user);
		post.setPostedOn(Calendar.getInstance());
		post = postService.save(post);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Aticle> udpateArticle(@PathVariable final Long id, @RequestBody final Aticle post) {
		Aticle currentArticle = postService.findById(id);

		currentArticle.setBody(post.getBody());
		currentArticle.setTitle(post.getTitle());
		currentArticle = postService.save(currentArticle);

		return new ResponseEntity<>(currentArticle, HttpStatus.OK);
	}

}
