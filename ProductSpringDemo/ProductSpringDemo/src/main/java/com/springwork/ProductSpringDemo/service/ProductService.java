package com.springwork.ProductSpringDemo.service;

import com.springwork.ProductSpringDemo.model.Product;
import com.springwork.ProductSpringDemo.repository.ProductDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

//    List<Product> productList=new ArrayList<>();
    @Autowired
ProductDB dataBase;


    public List<Product> getAllProducts() {

        return dataBase.findAll();
    }

//
//    public Product getProduct(String name) {
//        for (Product p : productList) {
//            if (p.getName().equals(name)) {
//                return p;
//            }
//        }
//        return null;
//
//    }
}
