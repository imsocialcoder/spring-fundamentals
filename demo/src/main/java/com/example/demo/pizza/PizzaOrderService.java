package com.example.demo.pizza;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PizzaOrderService {
    private PizzaInventoryClient pizzaInventoryClient;
    private HashMap<Integer, PizzaOrderDto> map = new HashMap<>();

    public PizzaOrderService(PizzaInventoryClient pizzaInventoryClient){
        this.pizzaInventoryClient = pizzaInventoryClient;
        map.put(1, new PizzaOrderDto("Margherita", 1));
        map.put(2, new PizzaOrderDto("4 Cheese", 2));
    }
    public PizzaOrderDto getPizzaOrder(Integer id){
        return map.get(id);
    }

    public Map<Integer, PizzaOrderDto> getPizzaOrders(String name){
        return map.entrySet().stream().filter(entry -> entry.getValue().getName().equals(name))
                .collect(Collectors.toMap(entry -> entry.getKey(),   // Lambda expression for key mapping
                        entry -> entry.getValue()));
    }

    public HashMap<Integer, PizzaOrderDto> getPizzaOrders(){
        return map;
    }

    public void addPizzaOrder(PizzaOrderDto pizzaOrderDto){
        if(pizzaInventoryClient.isAvailable(pizzaOrderDto.getName()))
            map.put(map.size() + 1, pizzaOrderDto);
    }
}
