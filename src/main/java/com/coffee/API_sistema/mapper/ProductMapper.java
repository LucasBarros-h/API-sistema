package com.coffee.API_sistema.mapper;

import com.coffee.API_sistema.dto.ProductDto;
import com.coffee.API_sistema.entity.Product;

public class ProductMapper {

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

}
