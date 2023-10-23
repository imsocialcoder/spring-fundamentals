package com.example.demo.pizza;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@ConditionalOnProperty(name = "pizza.inventory.environment", havingValue = "remote")
public class PizzaInventoryClassRemote implements PizzaInventoryClient{
    @Override
    public boolean isAvailable(String name) {
        Random random = new Random();
        return random.nextBoolean();
    }
}
