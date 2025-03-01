package com.coffee.API_sistema.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.coffee.API_sistema.dto.ProductDto;
import com.coffee.API_sistema.entity.Product;
import com.coffee.API_sistema.exception.ItemNotFoundException;
import com.coffee.API_sistema.mapper.SystemMapper;
import com.coffee.API_sistema.repository.ProductRepository;
import com.coffee.API_sistema.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto registerProduct(ProductDto productDto) {
        
        Product product = SystemMapper.mapToProduct(productDto);
        Product registeredProduct = productRepository.save(product);
        return SystemMapper.mapToProductDto(registeredProduct);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ItemNotFoundException("Item não encontrado pelo id: " + productId));
        
        return SystemMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((product) -> SystemMapper.mapToProductDto(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updatedProduct) {

        Product product = productRepository.findById(productId).orElseThrow(() -> new ItemNotFoundException("Produto não cadastrado pelo ID: " + productId));
        
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setInStock(updatedProduct.getInStock());

        Product updatedProductObject = productRepository.save(product);
       
        return SystemMapper.mapToProductDto(updatedProductObject);
    }

    @Override
    public void deleteProduct(Long productId) {

        @SuppressWarnings("unused")
        Product product = productRepository.findById(productId).orElseThrow(() -> new ItemNotFoundException("Produto não cadastrado pelo ID: " + productId));

        productRepository.deleteById(productId);
        
    }


}
