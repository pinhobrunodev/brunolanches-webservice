package com.pinhobrunodev.brunolanches.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinhobrunodev.brunolanches.dto.OrderDTO;
import com.pinhobrunodev.brunolanches.entites.Order;
import com.pinhobrunodev.brunolanches.mapper.OrderMapper;
import com.pinhobrunodev.brunolanches.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	@Autowired
	private OrderMapper mapper;

	public OrderDTO insert(OrderDTO dto) {
		Order entity = mapper.toEntity(dto);
		repository.save(entity);
		return mapper.toOrderDTO(entity);
	}

	public OrderDTO findById(Long id) {
		return repository.findById(id).map(x -> new OrderDTO(x)).orElseThrow(IllegalArgumentException::new);
	}

	public List<OrderDTO> findAllOrdersByStatusPENDINGOrderByMomentASC() {
		return repository.findAllOrdersByStatusPENDINGOrderByMomentASC().stream().map(x -> new OrderDTO(x))
				.collect(Collectors.toList());
	}

	public List<OrderDTO> findAllOrdersByStatusDELIVEREDOrderByMomentASC(int status) {
		return repository.findAllOrdersByStatusDELIVEREDOrderByMomentASC().stream().map(x -> new OrderDTO(x))
				.collect(Collectors.toList());
	}

	public List<OrderDTO> findAllOrdersByInstantASC() {
		return repository.findAllOrdersByInstantASC().stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
}
