package com.springwork.ProductSpringDemo.controller;

import com.springwork.ProductSpringDemo.model.Product;
import com.springwork.ProductSpringDemo.service.Impl.ProductServiceImpl;
import com.springwork.ProductSpringDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/getAllProducts")
   public List<Product> getAllProducts(){
         return productService.getAllProducts();
    }
    @PostMapping("/saveProducts")
    public Product saveProducts(@RequestBody Product product){

        return productService.saveProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id")
                                    Integer productid){
        productService.deleteproduct(productid);
        return "deleted successfully";
    }

    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable Integer id){

        return productService.updateProduct(product,id);

    }
}
