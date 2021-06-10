package com.pinhobrunodev.brunolanches.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pinhobrunodev.brunolanches.entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	
	@Query("SELECT obj FROM Order obj ORDER BY obj.moment ASC")
	List<Order> findAllOrdersByInstantASC();

	@Query("SELECT obj FROM Order obj WHERE obj.status = 1 ORDER BY obj.moment ASC")
	List<Order> findAllOrdersByStatusPENDINGOrderByMomentASC();
	
	@Query("SELECT obj FROM Order obj WHERE obj.status = 0 ORDER BY obj.moment ASC")
	List<Order> findAllOrdersByStatusDELIVEREDOrderByMomentASC();

}
