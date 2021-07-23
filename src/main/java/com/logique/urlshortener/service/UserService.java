package com.logique.urlshortener.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.logique.urlshortener.model.User;
import com.logique.urlshortener.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
        return userRepository.findAll();
    }
	
	public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public User getCurrentUser() {
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername(); //get logged in username
		return userRepository.findByUsername(username);
	}
	
}
