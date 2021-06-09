package com.pinhobrunodev.brunolanches.mapper;

import org.springframework.stereotype.Component;

import com.pinhobrunodev.brunolanches.dto.DeliverymanDTO;
import com.pinhobrunodev.brunolanches.entites.Deliveryman;

@Component
public class DeliverymanMapper {

	
	public Deliveryman toEntity(DeliverymanDTO dto) {
		Deliveryman entity = new Deliveryman();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setPhone(dto.getPhone());
		entity.setEmail(dto.getEmail());
		return entity;
	}
	
	
	public DeliverymanDTO toDeliverymanDTO(Deliveryman entity) {
		DeliverymanDTO dto = new DeliverymanDTO();
		dto.setId(entity.getId());
		dto.setCpf(entity.getCpf());
		dto.setEmail(entity.getEmail());
		dto.setName(entity.getName());
		dto.setPhone(entity.getPhone());
		return dto;
	}
}
