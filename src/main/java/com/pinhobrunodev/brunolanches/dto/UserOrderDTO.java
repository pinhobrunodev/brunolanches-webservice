package com.pinhobrunodev.brunolanches.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.pinhobrunodev.brunolanches.entites.User;

public class UserOrderDTO {

	private Long id;
	private String cpf;
	private List<OrderDTO> orders = new ArrayList<>();

	public UserOrderDTO() {

	}

	public UserOrderDTO(User entity) {
		id = entity.getId();
		cpf = entity.getCpf();
		orders = entity.getOrders().stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderDTO> getOrders() {
		return orders;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

}
