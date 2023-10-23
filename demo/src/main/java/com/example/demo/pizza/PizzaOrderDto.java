package com.example.demo.pizza;


public class PizzaOrderDto {
    private final String name;
    private final Integer quantity;

    public PizzaOrderDto(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
