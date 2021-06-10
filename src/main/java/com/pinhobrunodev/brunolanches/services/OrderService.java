package com.pinhobrunodev.brunolanches.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinhobrunodev.brunolanches.dto.OrderDTO;
import com.pinhobrunodev.brunolanches.entites.Order;
import com.pinhobrunodev.brunolanches.exceptions.order.ExceptionOrderEmptyList;
import com.pinhobrunodev.brunolanches.exceptions.order.ExceptionOrderNotFound;
import com.pinhobrunodev.brunolanches.exceptions.order.ExceptionOrderStatus;
import com.pinhobrunodev.brunolanches.mapper.OrderMapper;
import com.pinhobrunodev.brunolanches.repositories.OrderRepository;
import com.pinhobrunodev.brunolanches.utils.OrderMessageUtils;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	@Autowired
	private OrderMapper mapper;

	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order entity = mapper.toEntity(dto);
		repository.save(entity);
		return mapper.toOrderDTO(entity);
	}

	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		return repository.findById(id).map(x -> new OrderDTO(x)).orElseThrow(ExceptionOrderNotFound::new);
	}

	@Transactional(readOnly = true)
	public List<OrderDTO> findAllOrdersByStatusPENDINGOrderByMomentASC() {
		List<Order> validation = repository.findAllOrdersByStatusPENDINGOrderByMomentASC();
		if (validation.isEmpty()) {
			throw new ExceptionOrderStatus(OrderMessageUtils.EMPTY_PENDING_ORDERS);
		}
		return repository.findAllOrdersByStatusPENDINGOrderByMomentASC().stream().map(x -> new OrderDTO(x))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<OrderDTO> findAllOrdersByStatusDELIVEREDOrderByMomentASC() {
		List<Order> validation = repository.findAllOrdersByStatusDELIVEREDOrderByMomentASC();
		if (validation.isEmpty()) {
			throw new ExceptionOrderStatus(OrderMessageUtils.EMPTY_DELIVERED_ORDERS);
		}
		return repository.findAllOrdersByStatusDELIVEREDOrderByMomentASC().stream().map(x -> new OrderDTO(x))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<OrderDTO> findAllOrdersByInstantASC() {
		List<Order> validation = repository.findAllOrdersByInstantASC();
		if (validation.isEmpty()) {
			throw new ExceptionOrderEmptyList();
		}
		return repository.findAllOrdersByInstantASC().stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
}
