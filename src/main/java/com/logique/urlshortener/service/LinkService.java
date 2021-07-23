package com.logique.urlshortener.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logique.urlshortener.model.Link;
import com.logique.urlshortener.model.User;
import com.logique.urlshortener.repository.LinkRepository;

@Service
public class LinkService {

	@Autowired
	private LinkRepository linkRepository;
	
	@Autowired
	private UserService userService;
	
	private String generateShortLink() {
		int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 5;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return ("short.ly/" + generatedString);
	}
	
	public void saveLink(Link link) {
		User user = userService.getCurrentUser();		
		link.setShortUrl(generateShortLink());
		link.setUser(user);
		user.getLinks().add(link);
		
		linkRepository.save(link);
		userService.save(user);
	}
}
