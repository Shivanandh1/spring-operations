package com.lambda.spring_aws_lambda.Domain;

import lombok.Data;

@Data
public class Order {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Order() {}

    // Add this all-args constructor:
    public Order(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

}
// ...existing code...