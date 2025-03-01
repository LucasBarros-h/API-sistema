package com.coffee.API_sistema.dto;

import jakarta.validation.constraints.Min;

public class OrderItemDto {

    
    private Long productId;

    @Min(0)
    private int quantity;

    public OrderItemDto() {
        
    }

    public OrderItemDto(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    

}
