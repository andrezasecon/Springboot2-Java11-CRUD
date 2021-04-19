package com.andrezasecon.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrezasecon.crud.entities.Product;
import com.andrezasecon.crud.repositories.ProductRepository;

//na camada Service, implementamos as regras de negócio, esta camada chama a repository que 
//controla o acesso aos dados no banco

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	// Método para buscar todos os produtos
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	// Método para buscar o produto pelo ID	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
	
}
