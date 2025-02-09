package com.coffee.API_sistema.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.API_sistema.dto.ProductDto;
import com.coffee.API_sistema.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Adicionar produtos RESTAPI
    @PostMapping
    public ResponseEntity<ProductDto> registerProduct(@RequestBody ProductDto productDto) {
        ProductDto registeredProduct = productService.registerProduct(productDto);
        return new ResponseEntity<>(registeredProduct, HttpStatus.CREATED);
    }

    //Buscar produto por Id RESTAPI
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {
        ProductDto productDto = productService.getProductById(productId);

        return ResponseEntity.ok(productDto);
    }

    //Buscar lista de todos os produtos cadastrados RESTAPI
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();

        return ResponseEntity.ok(products);

    }

    //Atualizar cadastro de produto por Id RESTAPI
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto updatedProduct) {
        ProductDto productDto = productService.updateProduct(id, updatedProduct);

        return ResponseEntity.ok(productDto);
    }

    //Deletar produto cadastrado atraves do ID RESTAPI
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Produto deletado com sucesso.");
    }

}
