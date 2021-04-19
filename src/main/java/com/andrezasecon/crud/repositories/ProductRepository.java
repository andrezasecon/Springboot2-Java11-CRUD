package com.andrezasecon.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrezasecon.crud.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
