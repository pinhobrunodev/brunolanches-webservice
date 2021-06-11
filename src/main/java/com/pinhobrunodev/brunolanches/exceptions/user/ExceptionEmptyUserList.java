package com.pinhobrunodev.brunolanches.exceptions.user;

import com.pinhobrunodev.brunolanches.utils.UserMessageUtils;

public class ExceptionEmptyUserList extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	public ExceptionEmptyUserList() {
		super(UserMessageUtils.EMPTY_USER_LIST);
	}

}
