package com.pinhobrunodev.brunolanches.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.pinhobrunodev.brunolanches.entites.Order;
import com.pinhobrunodev.brunolanches.entites.enums.OrderStatus;

public class OrderInsertDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	private OrderStatus status;
	private Long user_id;
	private Long deliveryman_id;

	public OrderInsertDTO() {

	}

	public OrderInsertDTO(Order order) {
		id = order.getId();
		moment = order.getMoment();
		status = order.getStatus();
		user_id = order.getUser().getId();
		deliveryman_id = order.getDeliveryman().getId();
	}

	public Long getDeliveryman_id() {
		return deliveryman_id;
	}

	public void setDeliveryman_id(Long deliveryman_id) {
		this.deliveryman_id = deliveryman_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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

}
