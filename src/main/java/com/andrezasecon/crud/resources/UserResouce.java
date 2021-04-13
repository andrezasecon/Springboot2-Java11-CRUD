package com.andrezasecon.crud.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrezasecon.crud.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResouce {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		
		User u = new User (1L, "Andreza", "andreza@gmail.com", "119992041418", "123456");
		return ResponseEntity.ok().body(u);
		
	}

}
