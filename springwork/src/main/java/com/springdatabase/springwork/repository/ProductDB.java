package com.springdatabase.springwork.repository;

import com.springdatabase.springwork.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductDB extends JpaRepository<Product,Integer> {


}
