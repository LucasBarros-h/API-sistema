package com.coffee.API_sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.API_sistema.dto.OrderDto;
import com.coffee.API_sistema.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> registerOrder(@Valid @RequestBody OrderDto orderDto) {
        OrderDto registeredOrder = orderService.registerOrder(orderDto);

        return new ResponseEntity<>(registeredOrder, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") Long orderId) {
        OrderDto orderDto = orderService.getOrderById(orderId);

        return ResponseEntity.ok(orderDto);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        
        return ResponseEntity.ok(orders);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderDto> switchOrder(@PathVariable("id") Long orderId) {
        OrderDto orderDto = orderService.switchStatus(orderId);

        return ResponseEntity.ok(orderDto);
    }

}
