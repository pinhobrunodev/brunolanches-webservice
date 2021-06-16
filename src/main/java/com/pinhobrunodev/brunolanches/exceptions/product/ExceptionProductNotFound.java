package com.pinhobrunodev.brunolanches.exceptions.product;

import com.pinhobrunodev.brunolanches.utils.ProductMessageUtils;

public class ExceptionProductNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExceptionProductNotFound() {
		super(ProductMessageUtils.PRODUCT_NOT_FOUND);
	}

}
