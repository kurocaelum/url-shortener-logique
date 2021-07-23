package com.logique.urlshortener.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.logique.urlshortener.model.User;
import com.logique.urlshortener.repository.UserRepository;

@Component
public class DataSeeder implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("user", passwordEncoder.encode("password"));
		userRepository.save(user);
		
		user = new User("victor", passwordEncoder.encode("123456"));
		userRepository.save(user);
	}

}
