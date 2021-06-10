package com.pinhobrunodev.brunolanches.mapper;

import java.time.Instant;

import com.pinhobrunodev.brunolanches.dto.OrderDTO;
import com.pinhobrunodev.brunolanches.entites.Order;

public class OrderMapper {

	
	

	public Order toEntity(OrderDTO dto) {
		Order entity = new Order();
		entity.setId(dto.getId());
		entity.setMoment(Instant.now());
		entity.setOrderStatus(dto.getOrderStatus().PENDING);
		return entity;
	}
	
	public OrderDTO toOrderDTO(Order entity) {
		OrderDTO dto = new OrderDTO();
		dto.setId(entity.getId());
		dto.setMoment(entity.getMoment());
		dto.setOrderStatus(entity.getOrderStatus());
		return dto;
	}
}
