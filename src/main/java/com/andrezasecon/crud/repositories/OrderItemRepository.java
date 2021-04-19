package com.andrezasecon.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrezasecon.crud.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
