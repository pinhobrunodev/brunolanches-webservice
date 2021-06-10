package com.pinhobrunodev.brunolanches.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.pinhobrunodev.brunolanches.entites.Order;
import com.pinhobrunodev.brunolanches.entites.enums.OrderStatus;

public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;	
	private Integer status;
	
	
	public OrderDTO() {
		
	}
	
	public OrderDTO(Order order) {
		id = order.getId();
		moment=order.getMoment();
		setOrderStatus(order.getOrderStatus());
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

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(status);
	}

	public void setOrderStatus(OrderStatus status) {
		if (status != null) {
			this.status = status.getCode();
		}
	}
	

}
