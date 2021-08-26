package com.farias.springtutorial.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HttpRequestTest {

	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private String host;
	
	
	@BeforeEach
	void setUp() {
		host = "http://localhost:"+port+"/";
		
	}
	
	@Test
	void greetingShouldReturnDefaultMessage() {
		String result = this.restTemplate.getForObject(host, String.class);
		assertThat(result).contains("Hello, word");
	}
	
}
