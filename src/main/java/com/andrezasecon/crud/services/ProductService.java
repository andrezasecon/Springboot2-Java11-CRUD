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

import com.andrezasecon.crud.entities.Product;
import com.andrezasecon.crud.repositories.ProductRepository;

import javax.persistence.EntityNotFoundException;

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
	// Método que chama a inserção de produto da classe resource

	public Product insert(Product obj) {
		return repository.save(obj);
	}

	// método que chama a deleção de produto da classe resource
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
	public Product update(Long id, Product obj) {
		try {
			Product entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Product entity, Product obj) {
		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());
		entity.setImgUrl(obj.getImgUrl());
		entity.setPrice(obj.getPrice());
	}
	
}
