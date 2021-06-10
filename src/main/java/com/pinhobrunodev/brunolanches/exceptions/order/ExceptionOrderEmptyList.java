package com.pinhobrunodev.brunolanches.exceptions.order;

import com.pinhobrunodev.brunolanches.utils.OrderMessageUtils;

public class ExceptionOrderEmptyList extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	
	public ExceptionOrderEmptyList() {
		super(OrderMessageUtils.EMPTY_ORDERS);
	}
}
