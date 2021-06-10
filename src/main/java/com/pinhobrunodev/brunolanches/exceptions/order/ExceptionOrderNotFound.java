package com.pinhobrunodev.brunolanches.exceptions.order;

import com.pinhobrunodev.brunolanches.utils.OrderMessageUtils;

public class ExceptionOrderNotFound extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public ExceptionOrderNotFound() {
		super(OrderMessageUtils.ORDER_NOT_FOUND);
	}

}
