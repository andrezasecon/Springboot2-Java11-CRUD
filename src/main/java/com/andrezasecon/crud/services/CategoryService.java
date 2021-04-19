package com.andrezasecon.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
}
