package com.example.demo.pizza;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "pizza.inventory.environment", havingValue = "local")
public class PizzaInventoryClientLocal implements PizzaInventoryClient {
    @Override
    public boolean isAvailable(String name) {
        return true;
    }
}
