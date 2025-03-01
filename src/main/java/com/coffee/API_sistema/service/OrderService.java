package com.coffee.API_sistema.service;

import java.util.List;

import com.coffee.API_sistema.dto.OrderDto;

public interface OrderService {

    OrderDto registerOrder(OrderDto orderDto);

    List<OrderDto> getAllOrders();

    OrderDto getOrderById(OrderDto orderDto);

    OrderDto approvedStatus(OrderDto orderDto);

    OrderDto reprovedStatus(OrderDto orderDto);

}
