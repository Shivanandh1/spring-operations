package com.springwork.ProductSpringDemo.repository;

import com.springwork.ProductSpringDemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductDB extends JpaRepository<Product,Integer> {


}
