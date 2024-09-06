package com.springdatabase.springwork;

import com.springdatabase.springwork.model.Product;
import com.springdatabase.springwork.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringworkApplication {

	public static void main(String[] args) {
   ApplicationContext context= SpringApplication.run(SpringworkApplication.class, args);

		ProductService service=context.getBean(ProductService.class);

		List<Product> product= service.getAllProducts();
		 for(Product p:product ){
			  System.out.println(p);

		 }
	}

}
