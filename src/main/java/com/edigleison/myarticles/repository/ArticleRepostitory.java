package com.edigleison.myarticles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edigleison.myarticles.entity.Article;
import com.edigleison.myarticles.entity.User;

@Repository
public interface ArticleRepostitory extends JpaRepository<Article, Long>{
	
	List<Article> findByUser(User user);

}
