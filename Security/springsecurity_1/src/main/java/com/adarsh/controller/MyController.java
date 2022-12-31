package com.adarsh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/masai")
public class MyController {

	@GetMapping("/home")
	public ResponseEntity<String> home(){
		return new ResponseEntity<String>("welcom...Home",HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/user/home")
	public ResponseEntity<String> userhome(){
		return new ResponseEntity<String>("welcome user...Home",HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/user/dashboard")
	public ResponseEntity<String> userdashord(){
		return new ResponseEntity<String>("welcome user...dashboard",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/admin/home")
	public ResponseEntity<String> adminhome(){
		return new ResponseEntity<String>("welcome admin...Home",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/admin/dashboard")
	public ResponseEntity<String> admindashord(){
		return new ResponseEntity<String>("welcome admin...dashboard",HttpStatus.ACCEPTED);
	}
}
