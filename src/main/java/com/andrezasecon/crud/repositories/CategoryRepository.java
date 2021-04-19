package com.andrezasecon.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrezasecon.crud.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
