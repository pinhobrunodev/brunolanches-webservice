package com.pinhobrunodev.brunolanches.exceptions.deliveryman;

public class ExceptionEmptyDeliverymanOrderList extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public ExceptionEmptyDeliverymanOrderList(String msg) {
		super(msg);
	}

}
