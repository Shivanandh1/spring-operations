package com.lambda.spring_aws_lambda.repository;

import com.lambda.spring_aws_lambda.Domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public class OrderDao {

    public List<Order> buildOrders(){
        return Stream.of(new Order(101,"mobile",200.0,2),
                        new Order(102,"book",80.0,5),
                        new Order(393,"book",345.0,4)).toList();

    }

}
