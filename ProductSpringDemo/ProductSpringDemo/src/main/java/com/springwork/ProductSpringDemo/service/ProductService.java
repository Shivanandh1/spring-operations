package com.springwork.ProductSpringDemo.service;

import com.springwork.ProductSpringDemo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product saveProduct(Product product);
    void deleteproduct(Integer Id);
    Product updateProduct(Product product,Integer id);
}
