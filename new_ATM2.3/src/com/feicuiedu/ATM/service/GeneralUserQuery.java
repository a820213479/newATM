package com.feicuiedu.ATM.service;

import com.feicuiedu.ATM.entity.User;

public class GeneralUserQuery {
	private User user;

	public GeneralUserQuery(User user) {
		this.user = user;
	}

	public void guq() {

		System.out.println("账户姓名:" + user.getUserName());
		System.out.println("余额:" + user.getBalance());

	}
}
