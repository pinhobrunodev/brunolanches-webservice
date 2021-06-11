package com.pinhobrunodev.brunolanches.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pinhobrunodev.brunolanches.dto.UserDTO;
import com.pinhobrunodev.brunolanches.dto.UserInsertDTO;
import com.pinhobrunodev.brunolanches.dto.UserOrderDTO;
import com.pinhobrunodev.brunolanches.entites.User;
import com.pinhobrunodev.brunolanches.exceptions.order.ExceptionOrderStatus;
import com.pinhobrunodev.brunolanches.exceptions.user.ExceptionEmptyUserList;
import com.pinhobrunodev.brunolanches.exceptions.user.ExceptionUserBusiness;
import com.pinhobrunodev.brunolanches.exceptions.user.ExceptionUserNotFound;
import com.pinhobrunodev.brunolanches.mapper.UserMapper;
import com.pinhobrunodev.brunolanches.repositories.UserRepository;
import com.pinhobrunodev.brunolanches.utils.OrderMessageUtils;
import com.pinhobrunodev.brunolanches.utils.UserMessageUtils;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private UserMapper mapper;

	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		Optional<User> validationUserInsert = repository.findByNameAndCpfAndEmailAndPhone(dto.getName(), dto.getCpf(),
				dto.getEmail(), dto.getPhone());
		Optional<User> validationUserEmail = repository.findByEmail(dto.getEmail());
		Optional<User> validationUserPhone = repository.findByPhone(dto.getPhone());
		Optional<User> validationUserCpf = repository.findByCpf(dto.getCpf());
		Optional<User> validationAddressAndNumberHouse = repository.findByAddressAndNumber(dto.getAddress(),
				dto.getNumber());
		if (validationUserInsert.isPresent()) {
			throw new ExceptionUserBusiness(UserMessageUtils.USER_ALREADY_EXISTS);
		}
		if (validationUserEmail.isPresent()) {
			throw new ExceptionUserBusiness(UserMessageUtils.EMAIL_ALREADY_EXISTS);
		}
		if (validationUserPhone.isPresent()) {
			throw new ExceptionUserBusiness(UserMessageUtils.PHONE_ALREADY_EXISTS);
		}
		if (validationUserCpf.isPresent()) {
			throw new ExceptionUserBusiness(UserMessageUtils.CPF_ALREADY_EXISTS);
		}
		if (validationAddressAndNumberHouse.isPresent()) {
			throw new ExceptionUserBusiness(UserMessageUtils.ADRESS_ALREADY_EXISTS);
		}
		User entity = mapper.toEntity(dto);
		repository.save(entity);
		return mapper.toUserDTO(entity);
	}

	@Transactional
	public UserDTO update(UserInsertDTO dto) {
		Optional<User> validationUserUpdate = repository.findUserAndUpdate(dto.getId(), dto.getName(), dto.getEmail(),
				dto.getPhone());
		Optional<User> validationUserEmailUpdate = repository.findByEmailAndId(dto.getEmail(), dto.getId());
		Optional<User> validationUserPhoneUpdate = repository.findByPhoneAndId(dto.getPhone(), dto.getId());
		Optional<User> validationUserCpfUpdate = repository.findByCpfAndId(dto.getCpf(), dto.getId());
		Optional<User> validationAdressAndNumberHouseAnId = repository.findByAddressAndNumberAndId(dto.getAddress(),
				dto.getNumber(), dto.getId());
		if (validationUserUpdate.isPresent()) {
			throw new ExceptionUserBusiness(UserMessageUtils.USER_ALREADY_EXISTS);
		}
		if (validationUserEmailUpdate.isPresent()) {
			throw new ExceptionUserBusiness(UserMessageUtils.EMAIL_ALREADY_EXISTS);
		}
		if (validationUserPhoneUpdate.isPresent()) {
			throw new ExceptionUserBusiness(UserMessageUtils.PHONE_ALREADY_EXISTS);
		}
		if (validationUserCpfUpdate.isPresent()) {
			throw new ExceptionUserBusiness(UserMessageUtils.CPF_ALREADY_EXISTS);
		}
		if (validationAdressAndNumberHouseAnId.isPresent()) {
			throw new ExceptionUserBusiness(UserMessageUtils.ADRESS_ALREADY_EXISTS);
		}
		User entity = mapper.toEntity(dto);
		repository.save(entity);
		return mapper.toUserDTO(entity);
	}

	@Transactional
	public void delete(Long id) {
		Optional<User> validationIdForDelete = repository.findById(id);
		System.out.println(validationIdForDelete);
		if (!validationIdForDelete.isPresent()) {
			throw new ExceptionUserNotFound();
		}
		repository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public List<UserDTO> findAllByBirthDateOrderASC() {
		List<User> validation = repository.findAllByBirthDateOrderASC();
		if(validation.isEmpty()) {
			throw new ExceptionEmptyUserList();
		}
		return repository.findAllByBirthDateOrderASC().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public UserDTO findByName(String name) {
		return repository.findByName(name.substring(0, 1).toUpperCase().concat(name.substring(1)))
				.map(x -> new UserDTO(x)).orElseThrow(ExceptionUserNotFound::new);

	}

	@Transactional(readOnly = true)
	public List<UserOrderDTO> findAllOrderByUserIdStatusPending(Long id) {
		List<User> list = repository.findAllOrderByUserIdStatusPending(id);
		Optional<User> validation = repository.findById(id);
		if (!validation.isPresent()) {
			throw new ExceptionUserNotFound();
		}
		if (list.isEmpty()) {
			throw new ExceptionOrderStatus(OrderMessageUtils.EMPTY_PENDING_ORDERS);
		}
		return repository.findAllOrderByUserIdStatusPending(id).stream().map(x -> new UserOrderDTO(x))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<UserOrderDTO> findAllOrderByUserIdStatusDelivered(Long id) {
		List<User> list = repository.findAllOrderByUserIdStatusDelivered(id);
		Optional<User> validation = repository.findById(id);
		if (!validation.isPresent()) {
			throw new ExceptionUserNotFound();
		}
		if (list.isEmpty()) {
			throw new ExceptionOrderStatus(OrderMessageUtils.EMPTY_DELIVERED_ORDERS);
		}

		return repository.findAllOrderByUserIdStatusDelivered(id).stream().map(x -> new UserOrderDTO(x))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<UserOrderDTO> findAllOrdersByUserId(Long id) {
		Optional<User> validation = repository.findById(id);
		if (!validation.isPresent()) {
			throw new ExceptionUserNotFound();
		}
		return repository.findAllOrdersByUserId(id).stream().map(x -> new UserOrderDTO(x)).collect(Collectors.toList());
	}

}
