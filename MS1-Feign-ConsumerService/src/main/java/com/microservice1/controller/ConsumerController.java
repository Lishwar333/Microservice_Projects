package com.microservice1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice1.model.Product;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConsumerController {
	
@Autowired
ProductRestConsumer feignClient;

@Value("${product}")
String prod;

@HystrixCommand(fallbackMethod="defaultGreeting")
@GetMapping("/data")
public String getProductInfo() {
   System.out.println(feignClient.getClass().getName());  //prints as a proxy class
   return "Accessing from PRODUCT-SERVICE ==> " +feignClient.getProductsData();
}

 

public String defaultGreeting() {
    return "Hello this is a default greeting Message Fall Back method (Static Data) !!!";

}

@GetMapping("/all")
public List<Product> getProductsInfo() {

    System.out.print(prod);


   return  feignClient.getAllProducts();
}

@GetMapping("/product/{id}")
public Product getProduct(@PathVariable Integer id) {
   return feignClient.getProduct(id); 
   //call another service
} 

//Can add Post requests as well

}