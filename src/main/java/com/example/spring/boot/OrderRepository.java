package com.example.spring.boot;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<Order, Integer> {
	
	public static final String FIND_BY_DELIVERYLOCATION = "SELECT * FROM Order o where o.deliveryLocation = ?1"; 
	public static final String FIND_BY_ORDERDATE = "SELECT o FROM Order o where o.orderDate >= ?1";
	
	
	@Query(value = FIND_BY_DELIVERYLOCATION, nativeQuery = true)
	public Order findByDeliveryLocation(String deliveryLocation);
	
	@Query(value = FIND_BY_ORDERDATE)
	public Order findByOrderDate(String orderDate);
	
}
