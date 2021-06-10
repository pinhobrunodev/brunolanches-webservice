package com.pinhobrunodev.brunolanches.entites.enums;

public enum OrderStatus {
	
	DELIVERED(1),
	PENDING(2);
	
	private Integer code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code);
			return value;
		}
		throw new IllegalArgumentException("Id not found");
	}
	

	
}
