package com.pinhobrunodev.brunolanches.exceptions.deliveryman;

import com.pinhobrunodev.brunolanches.utils.DeliverymanMessageUtils;

public class ExceptionEmptyDeliverymanList extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public ExceptionEmptyDeliverymanList() {
		super(DeliverymanMessageUtils.EMPTY_DELIVERYMAN_LIST);
	}
}
