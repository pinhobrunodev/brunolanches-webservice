package com.pinhobrunodev.brunolanches.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinhobrunodev.brunolanches.entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
