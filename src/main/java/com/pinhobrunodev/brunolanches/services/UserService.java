package com.pinhobrunodev.brunolanches.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinhobrunodev.brunolanches.dto.UserDTO;
import com.pinhobrunodev.brunolanches.dto.UserInsertDTO;
import com.pinhobrunodev.brunolanches.entites.User;
import com.pinhobrunodev.brunolanches.mapper.UserMapper;
import com.pinhobrunodev.brunolanches.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private UserMapper mapper;

	@Transactional(readOnly = true)
	public List<UserDTO> findAllByBirthDateOrderASC() {
		return repository.findAllByBirthDateOrderASC().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public UserDTO findByName(String name) {
		User entity = repository.findByName(name);
		return mapper.toUserDTO(entity);
	}
	
	@Transactional
	public UserDTO update(UserInsertDTO dto) {
		
		Optional<User> optional = repository.findById(dto.getId());
		if(!optional.isPresent()) {
			System.out.println("nao ta aq");
		}
		User entity = mapper.toEntity(dto);
		repository.save(entity);
		return mapper.toUserDTO(entity);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		User entity = mapper.toEntity(dto);
		repository.save(entity);
		return mapper.toUserDTO(entity);
	}

}
