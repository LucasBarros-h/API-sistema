package com.coffee.API_sistema.service;

import java.util.List;

import com.coffee.API_sistema.dto.ProductDto;

public interface ProductService {

    ProductDto registerProduct(ProductDto productDto);

    ProductDto getProductById(Long productId);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(Long productId, ProductDto updatedProduct);

    void deleteProduct(Long productId);

}
