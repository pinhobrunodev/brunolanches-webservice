package com.pinhobrunodev.brunolanches.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.pinhobrunodev.brunolanches.entites.User;

public class UserInsertDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String phone;
	private String email;
	private LocalDate date;
	private String cpf;
	
	public UserInsertDTO() {
		
	}
	
	public UserInsertDTO(Long id, String name, String phone, String email, LocalDate date, String cpf) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.date = date;
		this.cpf = cpf;
	}
	
	// data that will be entered into the client-side
	
	public UserInsertDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		phone = entity.getPhone();
		email = entity.getEmail();
		date = entity.getDate();
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
	
}
