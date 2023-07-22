package com.microservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
@EnableDiscoveryClient
@SpringBootApplication
public class DemoCloudGatewayApplication {

 

    public static void main(String[] args) {
        SpringApplication.run(DemoCloudGatewayApplication.class, args);
    }
    /*
    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
       return builder.routes()
      .route("service1", r->r.path("//service1/**").uri("http://localhost:8090")) //static routing
     // .route("service1", r->r.path("/service1/**").uri("lb://cloudservice1")) //dynamic routing
      .build();
    }
    */


 

}
