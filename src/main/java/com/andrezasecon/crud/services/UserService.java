package com.andrezasecon.crud.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.andrezasecon.crud.entities.User;
import com.andrezasecon.crud.repositories.UserRepository;
import com.andrezasecon.crud.services.exceptions.DatabaseException;
import com.andrezasecon.crud.services.exceptions.ResourceNotFoundException;

//na camada Service, implementamos as regras de negócio, esta camada chama a repository que 
//controla o acesso aos dados no banco

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	// Método que chama a inserção de usuário da classe resource
	
	public User insert(User obj) {
		return repository.save(obj);		
	}
	
	// método que chama a deleção de usuário da classe resource
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	// metodo para atualizar o usuário por id
	public User update(Long id, User obj) {
		try {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());		
	}
}























