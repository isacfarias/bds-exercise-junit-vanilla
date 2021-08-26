package com.farias.springtutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farias.springtutorial.service.GreetingService;

@RestController
@RequestMapping("/")
public class GreetingController {
	
	@Autowired
	private GreetingService service;

	
	@GetMapping("/greeting")
	public String greeting() {
		return service.greeting();
	}
}
