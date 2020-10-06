package com.example.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/main")
public class MyRestController {
	
	private final OrderRepository orderRepository;
	
	@Autowired
    public MyRestController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
	
	
	
	@PutMapping("/create")
    public Order createOrderByID(@RequestBody Order order) {
		orderRepository.save(order);
        return order;
    }
	
	@GetMapping(value = "/{deliveryLocation}")
    public Order getOrderByTotalPrice(@PathVariable String totalPrice) {
        System.out.println("Getting order with totalPrice=" + totalPrice);
        return orderRepository.findByTotalPrice(totalPrice);
    }
	
	@DeleteMapping("/{orderId}")
    public void deleteOrderByID(@PathVariable Long orderId) {
        System.out.println("deleting order with orderId=" + orderId);
        orderRepository.deleteById(orderId);
    }	
	
}
