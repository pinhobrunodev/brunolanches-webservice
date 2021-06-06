package com.pinhobrunodev.brunolanches.exceptions.user;

import com.pinhobrunodev.brunolanches.utils.UserMessageUtils;

public class ExceptionUserNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExceptionUserNotFound() {
		super(UserMessageUtils.USER_NOT_FOUD);
	}
}
