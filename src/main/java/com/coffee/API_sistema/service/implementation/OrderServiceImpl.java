package com.coffee.API_sistema.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.API_sistema.dto.OrderDto;
import com.coffee.API_sistema.dto.OrderItemDto;
import com.coffee.API_sistema.entity.Order;
import com.coffee.API_sistema.entity.OrderItem;
import com.coffee.API_sistema.entity.Product;
import com.coffee.API_sistema.exception.ItemNotFoundException;
import com.coffee.API_sistema.exception.OrderNotFoundException;
import com.coffee.API_sistema.exception.OutOfStockException;
import com.coffee.API_sistema.mapper.SystemMapper;
import com.coffee.API_sistema.repository.OrderRepository;
import com.coffee.API_sistema.repository.ProductRepository;
import com.coffee.API_sistema.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDto registerOrder(OrderDto orderDto) {
        Order order = SystemMapper.mapToOrder(orderDto);
        
        for(OrderItemDto itemDto : orderDto.getItems()) {
            Product product = productRepository.findById(itemDto.getProductId()).orElseThrow(() -> new ItemNotFoundException("Produto não encontrado pelo ID: " + itemDto.getProductId()));
            if(product.getInStock() < itemDto.getQuantity()) {
                throw new OutOfStockException("Estoque insuficiente para o produto: " + product.getName());
            }

            product.setInStock(product.getInStock() - itemDto.getQuantity());
            productRepository.save(product);

            OrderItem items = new OrderItem();
            items.setProduct(product);
            items.setQuantity(itemDto.getQuantity());
            items.setOrder(order);
            
            order.getItems().add(items);

        }
        
        orderRepository.save(order);
        
        return SystemMapper.mapToOrderDto(order);

    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream().map((i) -> SystemMapper.mapToOrderDto(i)).collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(OrderDto orderDto) {
        Order order = orderRepository.findById(orderDto.getId()).orElseThrow(() -> new OrderNotFoundException("Pedido não encontrado por esse ID: " + orderDto.getId()));

        return SystemMapper.mapToOrderDto(order);
    }

    @Override
    public OrderDto approvedStatus(OrderDto orderDto) {
        Order order = orderRepository.findById(orderDto.getId()).orElseThrow(() -> new OrderNotFoundException("Pedido não encontrador por esse ID: " + orderDto.getId()));
        order.setStatus("APROVADO");

        return SystemMapper.mapToOrderDto(order);
    }

    @Override
    public OrderDto reprovedStatus(OrderDto orderDto) {
        Order order = orderRepository.findById(orderDto.getId()).orElseThrow(() -> new OrderNotFoundException("Pedido não encontrado por esse ID: " + orderDto.getId()));
        order.setStatus("REPROVADO");

        return SystemMapper.mapToOrderDto(order);
    }

}
