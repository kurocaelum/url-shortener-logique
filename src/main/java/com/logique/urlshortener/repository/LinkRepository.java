package com.logique.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logique.urlshortener.model.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {

}
