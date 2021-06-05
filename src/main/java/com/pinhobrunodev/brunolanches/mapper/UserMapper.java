package com.pinhobrunodev.brunolanches.mapper;

import org.springframework.stereotype.Component;

import com.pinhobrunodev.brunolanches.entites.User;
import com.pinhobrunodev.brunolanches.repositories.dto.UserDTO;
import com.pinhobrunodev.brunolanches.repositories.dto.UserInsertDTO;

@Component
public class UserMapper {

	//setting the values ​​entered for the entity
	public User toEntity(UserInsertDTO dto) {
		User entity = new User();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPhone(dto.getPhone());
		entity.setDate(dto.getDate());
		entity.setCpf(dto.getCpf());
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
		return dto;
	}
	
}
