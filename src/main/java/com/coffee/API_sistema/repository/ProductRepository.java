package com.coffee.API_sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.API_sistema.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
