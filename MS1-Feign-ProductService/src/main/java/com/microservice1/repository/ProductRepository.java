package com.microservice1.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.microservice1.model.Product;


@Repository
public class ProductRepository {
HashMap<Integer, Product> products=new HashMap();
//int productid=1;
public Product addproduct(Product prod)
{
    //int id=productid++;
    //prod.setId(id);
    products.put(prod.getId(), prod);
    return prod;
} 

public Product getProduct(int id)
{
    return products.get(id);
}

public String deleteProduct(int id)
{

    if(products.remove(id)==null)
        return "Product id "+id+ "Does Not Exists";

    else
        return "Product id "+id+ "is deleted";
}

public List<Product> getAllProducts()
{
    return new ArrayList<Product>(products.values());
}

 

}
