package com.andrezasecon.crud.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrezasecon.crud.entities.Product;
import com.andrezasecon.crud.services.ProductService;

// A camada Resource é responsável por controlar os dados requisitados pelo front ou aplicação
// ela chama a camada de serviço que implementa as regras de negócio
// ela é nossa Rest Controller

@RestController
@RequestMapping(value = "/products") // path da requisição http
public class ProductResouce {
	
	// Injeção de dependencia para a camada de Serviço (Instância da classe) usando a notation @Autowired
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){	
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}") // path da requisição http
	public ResponseEntity<Product> findById(@PathVariable Long id){
		
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
