package com.pinhobrunodev.brunolanches.exceptions.deliveryman;

import com.pinhobrunodev.brunolanches.utils.DeliverymanMessageUtils;

public class ExceptionDeliverymanNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExceptionDeliverymanNotFound() {
		super(DeliverymanMessageUtils.DELIVERYMAN_NOT_FOUND);
	}

}
