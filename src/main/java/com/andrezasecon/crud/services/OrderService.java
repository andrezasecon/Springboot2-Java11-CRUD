package com.andrezasecon.crud.services;

import java.util.List;
import java.util.Optional;

import com.andrezasecon.crud.entities.OrderItem;
import com.andrezasecon.crud.entities.User;
import com.andrezasecon.crud.services.exceptions.DatabaseException;
import com.andrezasecon.crud.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.andrezasecon.crud.entities.Order;
import com.andrezasecon.crud.repositories.OrderRepository;

import javax.persistence.EntityNotFoundException;

//na camada Service, implementamos as regras de negócio, esta camada chama a repository que 
//controla o acesso aos dados no banco

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	// Método para buscar todos os pedidos
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	// Método para buscar o pedido pelo ID	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

	// Método que chama a inserção de pedido da classe resource

	public Order insert(Order obj) {
		return repository.save(obj);
	}

	// método que chama a deleção de pedido da classe resource
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
