package com.logique.urlshortener.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.logique.urlshortener.model.Link;
import com.logique.urlshortener.service.LinkService;

@Controller
public class LinkController {

	@Autowired
	private LinkService linkService;
	
	@RequestMapping(value = "/send-link")
	public String sendLink(Model model) {
		model.addAttribute("link", new Link());
		return "send-link";
	}
	
	@PostMapping("/shorten")
	public String shortenLink(@Valid Link link, BindingResult result) {
		if(result.hasErrors()) {
			return "/send-link";
		}
		linkService.saveLink(link);
		return "redirect:/dashboard";
	}
	
}
