package com.edigleison.myarticles.controller;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

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

import com.edigleison.myarticles.entity.Article;
import com.edigleison.myarticles.entity.User;
import com.edigleison.myarticles.service.ArticleService;
import com.edigleison.myarticles.service.UserService;

@RestController
@RequestMapping("/api/article")
public class ArticleRestController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private UserService userService;
	
	@PostConstruct
	private void postConstruct() {
		Article article = new Article();
		article.setTitle("First article");
		article.setBody("This is the first article");
		
		articleService.save(article);
	}

	@GetMapping("/")
	public ResponseEntity<List<Article>> listAllArticles() {

		List<Article> list = articleService.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Article> findById(@PathVariable Long id) {

		Article post = articleService.findById(id);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Article> deleteArticle(@PathVariable Long id) {
		Article post = articleService.findById(id);
		articleService.delete(post);
		return new ResponseEntity<Article>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(value = "/")
	public ResponseEntity<Article> createArticle(@RequestBody Article post) {

//		User user = userService.findById(post.getUser().getId());
//		post.setUser(user);
		post.setPublishedOn(Calendar.getInstance());
		post = articleService.save(post);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Article> udpateArticle(@PathVariable final Long id, @RequestBody final Article post) {
		Article currentArticle = articleService.findById(id);

		currentArticle.setBody(post.getBody());
		currentArticle.setTitle(post.getTitle());
		currentArticle = articleService.save(currentArticle);

		return new ResponseEntity<>(currentArticle, HttpStatus.OK);
	}

}
