package com.edigleison.myarticles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edigleison.myarticles.entity.Article;
import com.edigleison.myarticles.entity.User;
import com.edigleison.myarticles.repository.ArticleRepostitory;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleRepostitory articleRepository;

	@Override
	public Article findById(Long id) {
		return articleRepository.findById(id).get();
	}

	@Override
	public List<Article> findAll() {
		return articleRepository.findAll();
	}

	@Override
	public Article save(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public void delete(Article article) {
		articleRepository.delete(article);
	}

	@Override
	public List<Article> findByUser(User user) {
		return articleRepository.findByUser(user);
	}
}
