package com.pinhobrunodev.brunolanches.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.pinhobrunodev.brunolanches.entites.Deliveryman;

public class DeliverymanOrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String deliveryman_name;
	private String deliveryman_phone;

	private List<OrderDTO> orders = new ArrayList<>();

	public DeliverymanOrderDTO() {

	}

	public DeliverymanOrderDTO(Long id, String name, String phone) {
		super();
		this.id = id;
		deliveryman_name = name;
		deliveryman_phone = phone;
	}

	public DeliverymanOrderDTO(Deliveryman entity) {
		id = entity.getId();
		deliveryman_name = entity.getName();
		deliveryman_phone = entity.getPhone();
		orders = entity.getOrders().stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<OrderDTO> getDeliverymanOrders() {
		return orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeliverymanOrderDTO other = (DeliverymanOrderDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
