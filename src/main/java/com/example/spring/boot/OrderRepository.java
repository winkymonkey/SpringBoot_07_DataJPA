package com.example.spring.boot;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
	
	public static final String FIND_BY_TOTALPRICE = "SELECT o FROM Order o where o.totalPrice >= ?1";
	public static final String FIND_BY_DELIVERYLOCATION = "SELECT * FROM T_ORDER where delivery_location = ?1";
	
	
	@Query
	public Order findByOrderId(long orderId);								//Automatic Custom Query
	
	@Query(value = FIND_BY_TOTALPRICE)
	public List<Order> findByTotalPrice(long totalPrice);					//Manual Custom Query
	
	@Query(value = FIND_BY_DELIVERYLOCATION, nativeQuery = true)
	public List<Order> findByDeliveryLocation(String deliveryLocation);		//Using Native Query
	
}
