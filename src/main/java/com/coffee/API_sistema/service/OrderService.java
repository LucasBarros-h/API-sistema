package com.coffee.API_sistema.service;

import java.util.List;

import com.coffee.API_sistema.dto.OrderDto;

public interface OrderService {

    OrderDto registerOrder(OrderDto orderDto);

    List<OrderDto> getAllOrders();

    OrderDto getOrderById(Long orderId);

    OrderDto switchStatus(Long orderId);

}
