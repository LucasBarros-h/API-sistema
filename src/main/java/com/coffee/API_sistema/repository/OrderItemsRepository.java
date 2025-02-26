package com.coffee.API_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.API_sistema.entity.OrderItem;

public interface OrderItemsRepository extends JpaRepository<OrderItem, Long>{

}
