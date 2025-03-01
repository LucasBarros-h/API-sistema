package com.coffee.API_sistema.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {

    private Long id;

    private String status;

    private LocalDateTime orderDate = LocalDateTime.now();

    private List<OrderItemDto> items;

    public OrderDto() {

    }

    public OrderDto(Long id, String status, LocalDateTime orderDate, List<OrderItemDto> items) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }


    


}
