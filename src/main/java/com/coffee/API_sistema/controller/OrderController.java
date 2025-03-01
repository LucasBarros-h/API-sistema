package com.coffee.API_sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.API_sistema.dto.OrderDto;
import com.coffee.API_sistema.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> registerOrder(@RequestBody OrderDto orderDto) {
        OrderDto registeredOrder = orderService.registerOrder(orderDto);

        return new ResponseEntity<>(registeredOrder, HttpStatus.CREATED);
    }

}
