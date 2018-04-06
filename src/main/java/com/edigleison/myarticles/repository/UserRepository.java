package com.edigleison.myarticles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edigleison.myarticles.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
