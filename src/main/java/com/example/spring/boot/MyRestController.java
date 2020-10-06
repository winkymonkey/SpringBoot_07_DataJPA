package com.example.spring.boot;

import java.util.List;

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
	
	
	
	/* ===================================================================== */
	@PutMapping("/create")
    public Order createOrderByID(@RequestBody Order order) {
		for(OrderItem item : order.getItems()) {
			item.setOrder(order);
		}
		orderRepository.save(order);
        return order;
    }
	
	/* ===================================================================== */
	@GetMapping(value = "/byId/{orderId}")
    public Order getOrderByOrderId(@PathVariable long orderId) {
        System.out.println("Getting order with orderId=" + orderId);
        Order order = orderRepository.findByOrderId(orderId);
        return order;
    }
	
	@GetMapping(value = "/byTotalPrice/{totalPrice}")
    public List<Order> getOrderByTotalPrice(@PathVariable long totalPrice) {
        System.out.println("Getting order with totalPrice=" + totalPrice);
        List<Order> order = orderRepository.findByTotalPrice(totalPrice);
        return order;
    }
	
	@GetMapping(value = "/byDeliveryLocation/{deliveryLocation}")
    public List<Order> getOrderByDeliveryLocation(@PathVariable String deliveryLocation) {
        System.out.println("Getting order with deliveryLocation=" + deliveryLocation);
        List<Order> order = orderRepository.findByDeliveryLocation(deliveryLocation);
        return order;
    }
	
	/* ===================================================================== */
	@DeleteMapping("/{orderId}")
    public void deleteOrderByID(@PathVariable Long orderId) {
        System.out.println("deleting order with orderId=" + orderId);
        orderRepository.deleteById(orderId);
    }	
	
}
