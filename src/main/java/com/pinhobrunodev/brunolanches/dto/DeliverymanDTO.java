package com.pinhobrunodev.brunolanches.dto;

import java.io.Serializable;

import com.pinhobrunodev.brunolanches.entites.Deliveryman;

public class DeliverymanDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String phone;
	private String email;
	private String cpf;

	public DeliverymanDTO() {

	}

	public DeliverymanDTO(Long id, String name, String phone, String email, String cpf) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.cpf = cpf;
	}

	public DeliverymanDTO(Deliveryman entity) {
		id = entity.getId();
		name = entity.getName();
		phone = entity.getPhone();
		email = entity.getEmail();
		cpf = entity.getCpf();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		DeliverymanDTO other = (DeliverymanDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
