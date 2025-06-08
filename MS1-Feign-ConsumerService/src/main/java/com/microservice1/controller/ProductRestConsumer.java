package com.microservice1.controller;

import java.util.List;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice1.model.Product;
 

@FeignClient(name="PRODUCT-SERVICE")
public interface ProductRestConsumer {


    @GetMapping("product/data")
    public String getProductsData();

    @PostMapping("product/add")
        public Product addProduct(@RequestBody Product prod);

     @GetMapping("product/{id}")
        public Product getProduct(@PathVariable int id);

     @GetMapping("product/all")
     public List<Product> getAllProducts();

}