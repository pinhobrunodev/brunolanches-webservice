package com.pinhobrunodev.brunolanches.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.pinhobrunodev.brunolanches.entites.Order;
import com.pinhobrunodev.brunolanches.entites.enums.OrderStatus;

public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	private OrderStatus status;
	private String client_name;
	private String client_phone;
	private String address;
	private String number;
	private String deliveryman_name;
	private String deliveryman_phone;
	
	private List<ProductDTO> products = new ArrayList<>();

	public OrderDTO() {

	}

	public OrderDTO(Order order) {
		id = order.getId();
		moment = order.getMoment();
		status = order.getStatus();
		client_name = order.getUser().getName();
		client_phone = order.getUser().getPhone();
		address = order.getUser().getAddress();
		number = order.getUser().getNumber();
		deliveryman_name = order.getDeliveryman().getName();
		deliveryman_phone = order.getDeliveryman().getPhone();
		products = order.getProducts().stream().map(x-> new ProductDTO(x)).collect(Collectors.toList());
	}

	public List<ProductDTO> getProducts() {
		return products;
	}
	
	public String getDeliveryman_name() {
		return deliveryman_name;
	}

	public void setDeliveryman_name(String deliveryman_name) {
		this.deliveryman_name = deliveryman_name;
	}

	public String getDeliveryman_phone() {
		return deliveryman_phone;
	}

	public void setDeliveryman_phone(String deliveryman_phone) {
		this.deliveryman_phone = deliveryman_phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getClient_phone() {
		return client_phone;
	}

	public void setClient_phone(String client_phone) {
		this.client_phone = client_phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
