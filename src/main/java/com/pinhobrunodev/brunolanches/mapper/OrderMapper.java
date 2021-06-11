package com.pinhobrunodev.brunolanches.mapper;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pinhobrunodev.brunolanches.dto.OrderDTO;
import com.pinhobrunodev.brunolanches.dto.OrderInsertDTO;
import com.pinhobrunodev.brunolanches.entites.Order;
import com.pinhobrunodev.brunolanches.entites.enums.OrderStatus;
import com.pinhobrunodev.brunolanches.repositories.UserRepository;

@Component
public class OrderMapper {

	
	@Autowired
	private UserRepository repository;

	public Order toEntity(OrderInsertDTO dto) {
		Order entity = new Order();
		entity.setId(dto.getId());
		entity.setMoment(Instant.now());
		entity.setStatus(OrderStatus.PENDING);
		entity.setUser(repository.getOne(dto.getUser_id()));
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
		return dto;
	}
}
