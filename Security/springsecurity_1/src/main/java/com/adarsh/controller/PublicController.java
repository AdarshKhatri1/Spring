package com.adarsh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

	
	//this should  be access without any username and password
	@GetMapping("/withoutpassword")
	public String Name() {
		return "without password";
	}
	
	// username and password compulsory

	@GetMapping("/withpassword")
	public ResponseEntity<String>Name1() {
		return new ResponseEntity<>("with password",HttpStatus.ACCEPTED);
	}
}
