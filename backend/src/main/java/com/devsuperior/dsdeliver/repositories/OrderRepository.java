package com.devsuperior.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("Select distinct obj From Order obj Join fetch obj.products"
			+ " Where obj.status = 0 order by obj.moment ASC")
	List<Order> findOrdersWithProducts();
	
}
