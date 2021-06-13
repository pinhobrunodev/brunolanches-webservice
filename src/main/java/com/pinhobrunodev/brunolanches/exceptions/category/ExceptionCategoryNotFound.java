package com.pinhobrunodev.brunolanches.exceptions.category;

import com.pinhobrunodev.brunolanches.utils.CategoryMessageUtils;

public class ExceptionCategoryNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ExceptionCategoryNotFound() {
		super(CategoryMessageUtils.CATEGORY_NOT_FOUND);
	}
}
