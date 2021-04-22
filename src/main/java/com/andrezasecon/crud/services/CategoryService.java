package com.andrezasecon.crud.services;

import java.util.List;
import java.util.Optional;

import com.andrezasecon.crud.entities.User;
import com.andrezasecon.crud.services.exceptions.DatabaseException;
import com.andrezasecon.crud.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.andrezasecon.crud.entities.Category;
import com.andrezasecon.crud.repositories.CategoryRepository;

//na camada Service, implementamos as regras de negócio, esta camada chama a repository que 
//controla o acesso aos dados no banco

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	// Método para buscar todas as categorias
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	// Método para buscar categoria pelo ID	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

	public Category insert(Category obj) {

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
	
	
}
