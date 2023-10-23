package com.example.demo.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pizza-orders")
public class PizzaOrderController {
    private PizzaOrderService pizzaOrderService;
    @Autowired
    public PizzaOrderController(PizzaOrderService pizzaOrderService){
        this.pizzaOrderService = pizzaOrderService;
    }

    @GetMapping("/{id}")
    public PizzaOrderDto getPizzaOrder(@PathVariable Integer id){
        return pizzaOrderService.getPizzaOrder(id);
    }

    @GetMapping("/")
    public HashMap<Integer, PizzaOrderDto> getPizzaOrders(){
        return pizzaOrderService.getPizzaOrders();
    }

    @GetMapping("/filter/{name}")
    public Map<Integer, PizzaOrderDto> getPizzaOrders(@PathVariable String name){
        return pizzaOrderService.getPizzaOrders(name);
    }

    @PostMapping("/")
    public void createPizzaOrder(@RequestBody PizzaOrderDto pizzaOrderDto){
        pizzaOrderService.addPizzaOrder(pizzaOrderDto);
    }
}
