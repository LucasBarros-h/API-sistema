package com.coffee.API_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.API_sistema.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
