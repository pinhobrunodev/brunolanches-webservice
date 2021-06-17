package com.pinhobrunodev.brunolanches.mapper;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pinhobrunodev.brunolanches.dto.OrderInsertDTO;
import com.pinhobrunodev.brunolanches.entites.Order;
import com.pinhobrunodev.brunolanches.entites.enums.OrderStatus;
import com.pinhobrunodev.brunolanches.repositories.DeliverymanRepository;
import com.pinhobrunodev.brunolanches.repositories.UserRepository;

@Component
public class OrderMapper {

	
	@Autowired
	private UserRepository repository;
	@Autowired
	private DeliverymanRepository deliverymanRepository;

	public Order toEntity(OrderInsertDTO dto) {
		Order entity = new Order();
		entity.setId(dto.getId());
		entity.setMoment(Instant.now());
		entity.setStatus(OrderStatus.PENDING);
		entity.setUser(repository.getOne(dto.getUser_id()));
		entity.setDeliveryman(deliverymanRepository.getOne(dto.getDeliveryman_id()));
		return entity;
	}
	
}
