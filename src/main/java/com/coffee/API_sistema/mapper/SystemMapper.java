package com.coffee.API_sistema.mapper;

import java.util.stream.Collectors;

import com.coffee.API_sistema.dto.OrderDto;
import com.coffee.API_sistema.dto.OrderItemDto;
import com.coffee.API_sistema.dto.ProductDto;
import com.coffee.API_sistema.entity.Order;
import com.coffee.API_sistema.entity.OrderItem;
import com.coffee.API_sistema.entity.Product;

public class SystemMapper {

    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getInStock()
        );
    }

    public static Product mapToProduct(ProductDto productDto){
        return new Product(
            productDto.getId(),
            productDto.getName(),
            productDto.getDescription(),
            productDto.getPrice(),
            productDto.getInStock()
        );
    }

    public static OrderDto mapToOrderDto(Order order) {
        return new OrderDto(
            order.getId(),
            order.getStatus(),
            order.getOrderDate(),
            order.getItems().stream().map(i -> SystemMapper.mapToOrderItemDto(i)).collect(Collectors.toList())
        );
    }

    public static Order mapToOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setStatus(orderDto.getStatus());
        order.setOrderDate(orderDto.getOrderDate());

        return order;
    }

    public static OrderItemDto mapToOrderItemDto(OrderItem item) {
        OrderItemDto itemDto = new OrderItemDto();
        itemDto.setProductId(item.getProduct().getId());
        itemDto.setQuantity(item.getQuantity());

        return itemDto;
    }

    public static OrderItem mapToOrderItem(OrderItemDto itemDto, Product product) {
        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setId(itemDto.getProductId());

        return item;
    }

}
