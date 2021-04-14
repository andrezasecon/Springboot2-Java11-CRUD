package com.andrezasecon.crud.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrezasecon.crud.entities.User;
import com.andrezasecon.crud.services.UserService;

// A camada Resource é responsável por controlar os dados requisitados pelo front ou aplicação
// ela chama a camada de serviço que implementa as regras de negócio
// ela é nossa Rest Controller

@RestController
@RequestMapping(value = "/users") // path da requisição http
public class UserResouce {
	
	// Injeção de dependencia para a camada de Serviço (Instância da classe) usando a notation @Autowired
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){	
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}") // path da requisição http
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
