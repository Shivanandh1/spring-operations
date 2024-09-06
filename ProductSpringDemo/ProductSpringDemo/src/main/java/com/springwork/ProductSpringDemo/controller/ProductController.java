package com.springwork.ProductSpringDemo.controller;

import com.springwork.ProductSpringDemo.model.Product;
import com.springwork.ProductSpringDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
   ProductService productService;
    @GetMapping("/getall")
    List<Product> getAllProducts(){
         return productService.getAllProducts();

    }
}
