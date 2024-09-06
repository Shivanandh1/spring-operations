package com.springdatabase.springwork.service;

import com.springdatabase.springwork.model.Product;
import com.springdatabase.springwork.repository.ProductDB;
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
