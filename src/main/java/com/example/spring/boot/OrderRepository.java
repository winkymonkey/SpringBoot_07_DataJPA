package com.example.spring.boot;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
	
	public static final String FIND_BY_DELIVERYLOCATION = "SELECT * FROM Order o where o.deliveryLocation = ?1"; 
	public static final String FIND_BY_TOTALPRICE = "SELECT o FROM Order o where o.totalPrice >= ?1";
	
	
	@Query(value = FIND_BY_DELIVERYLOCATION, nativeQuery = true)
	public Order findByDeliveryLocation(String deliveryLocation);
	
	@Query(value = FIND_BY_TOTALPRICE)
	public Order findByTotalPrice(long totalPrice);
	
}
