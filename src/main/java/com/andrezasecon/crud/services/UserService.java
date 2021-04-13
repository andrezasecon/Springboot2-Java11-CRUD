package com.andrezasecon.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrezasecon.crud.entities.User;
import com.andrezasecon.crud.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	// Método para buscar todos os usuários
	public List<User> findAll(){
		return repository.findAll();
	}
	
	// Método para buscar o usuário pelo ID	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	
}
