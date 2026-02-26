package com.lambda.spring_aws_lambda;

import com.lambda.spring_aws_lambda.Domain.Order;
import com.lambda.spring_aws_lambda.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringAwsLambdaApplication {

	@Autowired
	private OrderDao orderDao;

	@Bean
	public Supplier<List<Order>> orders(){
		return ()->orderDao.buildOrders();
	}

	@Bean
	public Function<String,List<Order>> FindOrderByName(){
		return (input)->orderDao.buildOrders().stream().filter(order -> order.getName().equals(input)).toList();
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringAwsLambdaApplication.class, args);
	}

}
