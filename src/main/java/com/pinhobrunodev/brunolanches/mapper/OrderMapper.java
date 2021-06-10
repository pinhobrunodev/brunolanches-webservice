package com.pinhobrunodev.brunolanches.mapper;

import java.time.Instant;

import org.springframework.stereotype.Component;

import com.pinhobrunodev.brunolanches.dto.OrderDTO;
import com.pinhobrunodev.brunolanches.entites.Order;

@Component
public class OrderMapper {

	
	

	public Order toEntity(OrderDTO dto) {
		Order entity = new Order();
		entity.setId(dto.getId());
		entity.setMoment(Instant.now());
		entity.setStatus(dto.getStatus().PENDING);
		return entity;
	}
	
	public OrderDTO toOrderDTO(Order entity) {
		OrderDTO dto = new OrderDTO();
		dto.setId(entity.getId());
		dto.setMoment(entity.getMoment());
		dto.setStatus(entity.getStatus());
		return dto;
	}
}
