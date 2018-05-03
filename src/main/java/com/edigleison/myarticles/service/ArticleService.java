package com.edigleison.myarticles.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edigleison.myarticles.entity.Article;
import com.edigleison.myarticles.entity.User;

@Service
public interface ArticleService {
	
	Article findById(Long id);
	List<Article> findAll();
	Article save(Article article);
	void delete(Article article);
	List<Article> findByUser(User user);

}
