package com.pinhobrunodev.brunolanches.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinhobrunodev.brunolanches.dto.OrderDTO;
import com.pinhobrunodev.brunolanches.dto.OrderInsertDTO;
import com.pinhobrunodev.brunolanches.dto.ProductDTO;
import com.pinhobrunodev.brunolanches.entites.Deliveryman;
import com.pinhobrunodev.brunolanches.entites.Order;
import com.pinhobrunodev.brunolanches.entites.Product;
import com.pinhobrunodev.brunolanches.entites.User;
import com.pinhobrunodev.brunolanches.entites.enums.OrderStatus;
import com.pinhobrunodev.brunolanches.exceptions.deliveryman.ExceptionDeliverymanNotFound;
import com.pinhobrunodev.brunolanches.exceptions.order.ExceptionOrderEmptyList;
import com.pinhobrunodev.brunolanches.exceptions.order.ExceptionOrderNotFound;
import com.pinhobrunodev.brunolanches.exceptions.order.ExceptionOrderStatus;
import com.pinhobrunodev.brunolanches.exceptions.user.ExceptionUserNotFound;
import com.pinhobrunodev.brunolanches.mapper.OrderMapper;
import com.pinhobrunodev.brunolanches.repositories.DeliverymanRepository;
import com.pinhobrunodev.brunolanches.repositories.OrderRepository;
import com.pinhobrunodev.brunolanches.repositories.ProductRepository;
import com.pinhobrunodev.brunolanches.repositories.UserRepository;
import com.pinhobrunodev.brunolanches.utils.OrderMessageUtils;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	@Autowired
	private OrderMapper mapper;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DeliverymanRepository deliverymanRepository;
	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public OrderDTO insert(OrderInsertDTO dto) {
		Optional<User> user = userRepository.findById(dto.getUser_id());
		Optional<Deliveryman> deliveryman = deliverymanRepository.findById(dto.getDeliveryman_id());
		if (!user.isPresent()) {
			throw new ExceptionUserNotFound();
		}
		if(!deliveryman.isPresent()) {
			throw new ExceptionDeliverymanNotFound();
		}
		Order entity = mapper.toEntity(dto);
		for(ProductDTO x : dto.getProducts()) {
			Product aux = productRepository.getOne(x.getId());
			entity.getProducts().add(aux);
		}
		repository.save(entity);
		return new OrderDTO(entity);
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

	@Transactional
	public OrderDTO setDelivered(Long id) {

		Optional<Order> validation = repository.findById(id);
		if (!validation.isPresent()) {
			throw new ExceptionOrderNotFound();
		}
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		repository.save(order);
		return new OrderDTO(order);
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
