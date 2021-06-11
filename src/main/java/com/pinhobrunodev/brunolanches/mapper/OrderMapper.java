package com.pinhobrunodev.brunolanches.mapper;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pinhobrunodev.brunolanches.dto.OrderDTO;
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
	
	public OrderDTO toOrderDTO(Order entity) {
		OrderDTO dto = new OrderDTO();
		dto.setId(entity.getId());
		dto.setMoment(entity.getMoment());
		dto.setStatus(entity.getStatus());
		dto.setAddress(entity.getUser().getAddress());
		dto.setClient_name(entity.getUser().getName());
		dto.setClient_phone(entity.getUser().getPhone());
		dto.setNumber(entity.getUser().getNumber());
		dto.setDeliveryman_name(entity.getDeliveryman().getName());
		dto.setDeliveryman_phone(entity.getDeliveryman().getPhone());
		return dto;
	}
}
