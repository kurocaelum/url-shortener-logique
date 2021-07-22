package com.logique.urlshortener.service;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.logique.urlshortener.model.User;
import com.logique.urlshortener.repository.UserRepository;

@Transactional
@Service
public class AuthProviderService implements UserDetailsService {

	private UserRepository userRepository;
	
	public AuthProviderService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			User user = userRepository.findByUsername(username);
			if(user == null) {
				return null;
			}
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found!");
		}
	}

}
