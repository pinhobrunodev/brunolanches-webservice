package com.pinhobrunodev.brunolanches.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinhobrunodev.brunolanches.dto.DeliverymanDTO;
import com.pinhobrunodev.brunolanches.entites.Deliveryman;
import com.pinhobrunodev.brunolanches.mapper.DeliverymanMapper;
import com.pinhobrunodev.brunolanches.repositories.DeliverymanRepository;

@Service
public class DeliverymanService {

	@Autowired
	private DeliverymanRepository repository;
	@Autowired
	private DeliverymanMapper mapper;
	
	@Transactional
	public DeliverymanDTO insert(DeliverymanDTO dto) {
		Deliveryman entity = mapper.toEntity(dto);
		repository.save(entity);
		return mapper.toDeliverymanDTO(entity);
	}
	
	@Transactional
	public DeliverymanDTO update(DeliverymanDTO dto) {
		Deliveryman entity = mapper.toEntity(dto);
		repository.save(entity);
		return mapper.toDeliverymanDTO(entity);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<DeliverymanDTO> findAllOrderByNameASC(){
		return repository.findAllOrderByNameASC().stream().map(x->new DeliverymanDTO(x)).collect(Collectors.toList());
	}
	@Transactional(readOnly = true)
	public DeliverymanDTO findByEmail(String email) {
		Deliveryman entity = repository.findByEmail(email);
		return mapper.toDeliverymanDTO(entity);
	}
}
