package com.logique.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logique.urlshortener.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
