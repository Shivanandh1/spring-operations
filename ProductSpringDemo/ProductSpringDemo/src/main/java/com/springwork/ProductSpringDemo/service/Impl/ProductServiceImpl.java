package com.springwork.ProductSpringDemo.service.Impl;

import com.springwork.ProductSpringDemo.model.Product;
import com.springwork.ProductSpringDemo.repository.ProductDB;
import com.springwork.ProductSpringDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDB dataBase;

    @Override
    public List<Product> getAllProducts() {

        return dataBase.findAll();
    }
    @Override
    public Product saveProduct(Product product){

        return dataBase.save(product);
    }

    @Override
    public void deleteproduct(Integer Id) {

        dataBase.deleteById(Id);
    }

    @Override
    public Product updateProduct(Product product, Integer id) {
        Product productdb=dataBase.findById(id).get();

        if(product.getName()!=null){
            productdb.setName(product.getName());
        }
        if(product.getPlace()!=null){
            productdb.setPlace(product.getPlace());
        }
        if(product.getType()!=null){
            productdb.setType(product.getType());
        }

            productdb.setWarranty(product.getWarranty());

        return dataBase.save(productdb);
    }

}
