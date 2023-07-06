package com.ecom.controller;

import com.ecom.Entity.Product;
import com.ecom.repo.ProductRepository;
import com.ecom.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    Producer producer;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("all")
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @PostMapping("/save")
    public Product createProduct(@RequestBody Product product) {

        return productRepository.save(product);
    }

    @GetMapping("/producerMsg")
    public String getMessageFromClient(@RequestParam("message") String message){
       return producer.sendMessageToTopic(message);
    }

}
