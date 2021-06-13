package com.pinhobrunodev.brunolanches.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinhobrunodev.brunolanches.dto.DeliverymanDTO;
import com.pinhobrunodev.brunolanches.dto.DeliverymanInsertDTO;
import com.pinhobrunodev.brunolanches.dto.DeliverymanOrderDTO;
import com.pinhobrunodev.brunolanches.entites.Deliveryman;
import com.pinhobrunodev.brunolanches.exceptions.deliveryman.ExceptionDeliverymanBusiness;
import com.pinhobrunodev.brunolanches.exceptions.deliveryman.ExceptionDeliverymanNotFound;
import com.pinhobrunodev.brunolanches.exceptions.deliveryman.ExceptionEmptyDeliverymanList;
import com.pinhobrunodev.brunolanches.exceptions.deliveryman.ExceptionEmptyDeliverymanOrderList;
import com.pinhobrunodev.brunolanches.mapper.DeliverymanMapper;
import com.pinhobrunodev.brunolanches.repositories.DeliverymanRepository;
import com.pinhobrunodev.brunolanches.utils.DeliverymanMessageUtils;

@Service
public class DeliverymanService {

	@Autowired
	private DeliverymanRepository repository;
	@Autowired
	private DeliverymanMapper mapper;

	@Transactional
	public DeliverymanDTO insert(DeliverymanInsertDTO dto) {
		Optional<Deliveryman> validationInsertDeliveryman = repository.findByNameAndPhoneAndEmailAndCpf(dto.getName(),
				dto.getPhone(), dto.getEmail(), dto.getCpf());
		Optional<Deliveryman> validationInsertPhone = repository.findByPhone(dto.getPhone());
		Optional<Deliveryman> validationInsertEmail = repository.findByEmail(dto.getEmail());
		Optional<Deliveryman> validationInsertCpf = repository.findByCpf(dto.getCpf());
		if (validationInsertDeliveryman.isPresent()) {
			throw new ExceptionDeliverymanBusiness(DeliverymanMessageUtils.DELIVERYMAN_ALREADY_EXISTS);
		}
		if (validationInsertPhone.isPresent()) {
			throw new ExceptionDeliverymanBusiness(DeliverymanMessageUtils.PHONE_ALREADY_IN_USE);
		}
		if (validationInsertEmail.isPresent()) {
			throw new ExceptionDeliverymanBusiness(DeliverymanMessageUtils.EMAIL_ALREADY_IN_USE);
		}
		if (validationInsertCpf.isPresent()) {
			throw new ExceptionDeliverymanBusiness(DeliverymanMessageUtils.CPF_ALREADY_IN_USE);
		}
		Deliveryman entity = mapper.toEntity(dto);
		repository.save(entity);
		return mapper.toDeliverymanDTO(entity);
	}

	@Transactional
	public DeliverymanDTO update(DeliverymanInsertDTO dto) {
		Optional<Deliveryman> validationUpdateDeliveryman = repository.findDeliverymanAndUpdate(dto.getId(),
				dto.getCpf(), dto.getEmail(), dto.getName(), dto.getPhone());
		Optional<Deliveryman> validationUpdatePhone = repository.findByPhoneAndId(dto.getId(), dto.getPhone());
		Optional<Deliveryman> validationUpdateEmail = repository.findByEmailAndId(dto.getId(), dto.getEmail());
		Optional<Deliveryman> validationUpdateCpf = repository.findByCpfAndId(dto.getId(), dto.getCpf());
		Optional<Deliveryman> validationInsertIdtoUpdate = repository.findById(dto.getId());

		if (!validationInsertIdtoUpdate.isPresent()) {
			throw new ExceptionDeliverymanNotFound();
		}
		if (validationUpdateDeliveryman.isPresent()) {
			throw new ExceptionDeliverymanBusiness(DeliverymanMessageUtils.DELIVERYMAN_ALREADY_EXISTS);
		}
		if (validationUpdateCpf.isPresent()) {
			throw new ExceptionDeliverymanBusiness(DeliverymanMessageUtils.CPF_ALREADY_IN_USE);
		}
		if (validationUpdatePhone.isPresent()) {
			throw new ExceptionDeliverymanBusiness(DeliverymanMessageUtils.PHONE_ALREADY_IN_USE);
		}
		if (validationUpdateEmail.isPresent()) {
			throw new ExceptionDeliverymanBusiness(DeliverymanMessageUtils.EMAIL_ALREADY_IN_USE);
		}

		Deliveryman entity = mapper.toEntity(dto);
		repository.save(entity);
		return mapper.toDeliverymanDTO(entity);
	}

	@Transactional
	public void delete(Long id) {
		if (repository.getOne(id) == null) {
			throw new ExceptionDeliverymanNotFound();
		}
		repository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<DeliverymanDTO> findAllDeliverymanByNameASC() {
		List<Deliveryman> list = repository.findAllDeliverymanByNameASC();
		if(list.isEmpty()) {
			throw new ExceptionEmptyDeliverymanList();
		}
		return repository.findAllDeliverymanByNameASC().stream().map(x -> new DeliverymanDTO(x))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public DeliverymanDTO findByEmail(String email) {
		return repository.findByEmail(email.substring(0, 1).toLowerCase().concat(email.substring(1)))
				.map(x -> new DeliverymanDTO(x)).orElseThrow(ExceptionDeliverymanNotFound::new);
	}

	@Transactional(readOnly = true)
	public List<DeliverymanOrderDTO> findAllOrdersByDeliverymaIdDelivered(Long id) {
		List<Deliveryman> list = repository.findAllOrdersByDeliverymaIdDelivered(id);
		if(list.isEmpty()) {
			throw new ExceptionEmptyDeliverymanOrderList(DeliverymanMessageUtils.EMPTY_DELIVERED_ORDERS_LIST);
		}
		Optional<Deliveryman> validation = repository.findById(id);
		if (!validation.isPresent()) {
			throw new ExceptionDeliverymanNotFound();
		}
		return repository.findAllOrdersByDeliverymaIdDelivered(id).stream().map(x -> new DeliverymanOrderDTO(x))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<DeliverymanOrderDTO> findAllOrdersByDeliverymanIdPending(Long id) {
		List<Deliveryman> list = repository.findAllOrdersByDeliverymaIdPending(id);
		if(list.isEmpty()) {
			throw new ExceptionEmptyDeliverymanOrderList(DeliverymanMessageUtils.EMPTY_PENDING_ORDERS_LIST);
		}
		Optional<Deliveryman> validation = repository.findById(id);
		if (!validation.isPresent()) {
			throw new ExceptionDeliverymanNotFound();
		}
		return repository.findAllOrdersByDeliverymaIdPending(id).stream().map(x -> new DeliverymanOrderDTO(x))
				.collect(Collectors.toList());
	}
}
