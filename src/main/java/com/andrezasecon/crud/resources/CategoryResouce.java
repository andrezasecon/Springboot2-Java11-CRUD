package com.andrezasecon.crud.resources;

import java.net.URI;
import java.util.List;

import com.andrezasecon.crud.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.andrezasecon.crud.entities.Category;
import com.andrezasecon.crud.services.CategoryService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// A camada Resource é responsável por controlar os dados requisitados pelo front ou aplicação
// ela chama a camada de serviço que implementa as regras de negócio
// ela é nossa Rest Controller

@RestController
@RequestMapping(value = "/categories") // path da requisição http
public class CategoryResouce {
	
	// Injeção de dependencia para a camada de Serviço (Instância da classe) usando a notation @Autowired
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){	
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") // path da requisição http
	public ResponseEntity<Category> findById(@PathVariable Long id){
		
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	//Inserção de categoria e criação da URL de resposta com 201
	@PostMapping
	public ResponseEntity<Category> insert(@RequestBody Category obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	//Deleção de usuário resposta 204
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	//Atualização de categoria resposta 200
	@PutMapping(value = "/{id}")
	public ResponseEntity<Category> update (@PathVariable Long id, @RequestBody Category obj ){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
