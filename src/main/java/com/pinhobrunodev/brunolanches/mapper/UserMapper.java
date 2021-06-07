package com.pinhobrunodev.brunolanches.mapper;

import org.springframework.stereotype.Component;

import com.pinhobrunodev.brunolanches.dto.UserDTO;
import com.pinhobrunodev.brunolanches.dto.UserInsertDTO;
import com.pinhobrunodev.brunolanches.entites.User;

@Component
public class UserMapper {

	//setting the values ​​entered for the entity
	public User toEntity(UserInsertDTO dto) {
		User entity = new User();
		entity.setId(dto.getId());
		entity.setName(dto.getName().substring(0,1).toUpperCase().concat(dto.getName().substring(1)));
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setDate(dto.getDate());
		entity.setCpf(dto.getCpf());
		entity.setAdress(dto.getAdress());
		entity.setNumber(dto.getNumber());
		return entity;
	}
	
	//setting the entity values ​​to the dto
	public UserDTO toUserDTO(User entity) {
		UserDTO dto = new UserDTO();
		dto.setId(entity.getId());
		dto.setDate(entity.getDate());
		dto.setEmail(entity.getEmail());
		dto.setName(entity.getName());
		dto.setPhone(entity.getPhone());
		dto.setAdress(entity.getAdress());
		dto.setNumber(entity.getNumber());
		return dto;
	}
	
}
