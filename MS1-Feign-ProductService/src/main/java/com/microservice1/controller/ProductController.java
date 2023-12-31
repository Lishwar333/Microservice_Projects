package com.microservice1.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice1.model.Product;
import com.microservice1.repository.ProductRepository;


@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    Environment environment;
    @Autowired
    ProductRepository repo;
    @GetMapping("/data")
    public String getProductsData() {

       return "data of PRODUCT-SERVICE, Running on port: "
         +environment.getProperty("local.server.port");
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product prod)
    {
        return repo.addproduct(prod);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id)
    {
        return repo.getProduct(id);
    }
    @GetMapping("/all")
    public List<Product> getAllProducts()
    {
        return repo.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id)
    {
        return repo.deleteProduct(id);

    }

}