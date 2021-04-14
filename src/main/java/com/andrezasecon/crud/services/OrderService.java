package com.andrezasecon.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrezasecon.crud.entities.Order;
import com.andrezasecon.crud.repositories.OrderRepository;

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
	
	
}
