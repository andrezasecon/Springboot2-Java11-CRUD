package com.andrezasecon.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrezasecon.crud.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
