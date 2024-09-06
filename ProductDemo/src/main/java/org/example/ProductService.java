package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> productList=new ArrayList<>();
    ProductDB dataBase=new ProductDB();

    public void addProduct(Product product) {
//            productList.add(product);

        dataBase.save(product);


    }

    public List<Product> getAllProducts() {

        return dataBase.getAll();
    }

    public Product getProduct(String name) {
        for (Product p : productList) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;

    }
}
