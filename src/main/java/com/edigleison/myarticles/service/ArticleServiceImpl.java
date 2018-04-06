package com.edigleison.myarticles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edigleison.myarticles.entity.Aticle;
import com.edigleison.myarticles.entity.User;
import com.edigleison.myarticles.repository.ArticleRepostitory;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleRepostitory articleRepository;

	@Override
	public Aticle findById(Long id) {
		return articleRepository.findById(id).get();
	}

	@Override
	public List<Aticle> findAll() {
		return articleRepository.findAll();
	}

	@Override
	public Aticle save(Aticle article) {
		return articleRepository.save(article);
	}

	@Override
	public void delete(Aticle article) {
		articleRepository.delete(article);
	}

	@Override
	public List<Aticle> findByUser(User user) {
		return articleRepository.findByUser(user);
	}
}
