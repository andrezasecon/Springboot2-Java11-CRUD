package com.andrezasecon.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrezasecon.crud.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
