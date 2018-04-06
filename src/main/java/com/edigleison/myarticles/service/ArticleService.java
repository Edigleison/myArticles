package com.edigleison.myarticles.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edigleison.myarticles.entity.Aticle;
import com.edigleison.myarticles.entity.User;

@Service
public interface ArticleService {
	
	Aticle findById(Long id);
	List<Aticle> findAll();
	Aticle save(Aticle article);
	void delete(Aticle article);
	List<Aticle> findByUser(User user);

}
