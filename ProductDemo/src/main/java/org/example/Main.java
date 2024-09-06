package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String name1="asus book";
//        String name2="laptop";
//        String place1="bed room";
//        int warranty=2024;

//        Product p=new Product();
//        System.out.println(p);

        ProductService productService=new ProductService();

     //   Product product=new Product("asus book","laptop","bed room",2022);

            productService.addProduct(new Product("asus book","laptop","bed room",2022));
        productService.addProduct(new Product("acer book","laptop","hall",2024));
        productService.addProduct(new Product("lenovo","laptop","room",2023));

//            List<Product> productList=  productService.getAllProducts();
//           // System.out.println(productList);
//        for(Product product: productList){
//            System.out.println(product);
//        }
//          Product p= productService.getProduct("asus book");
//        System.out.println(p);

//        ProductDB productDB=new ProductDB();
        ProductService service=new ProductService();
        List<Product> productList= service.getAllProducts();

        for(Product p: productList){
            System.out.println(p);

        }


    }
}