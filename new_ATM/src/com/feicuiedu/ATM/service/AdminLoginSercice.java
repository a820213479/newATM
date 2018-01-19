package com.feicuiedu.ATM.service;

import java.util.Scanner;

public class AdminLoginSercice {
	Scanner scanner = new Scanner(System.in);

	public void als() {

		System.out.println("请输入用户名:");
		String adminUserName = scanner.next();

		System.out.println("请输入密码:");
		String adminUserPassword = scanner.next();

		// 登录成功
		System.out.println("请选择功能项目");
		// 1.开户2.销户3.显示所用用户信息4.修改账户信息
		System.out.println("1.开户\n2.销户\n3.显示所有用户信息\n4.修改账户信息");
		String index = scanner.next();

		if (index.equals("1")) {
			AdminAddUser addUser = new AdminAddUser();
			addUser.aau();
		} else if (index.equals("2")) {
			DelUser delUser = new DelUser();
			delUser.du();
		} else if (index.equals("3")) {
			QueryUser queryUser = new QueryUser();
			queryUser.qu();
		} else if (index.equals("4")) {
			AlterUser alterUser = new AlterUser();
			alterUser.au();
		} else {
			System.out.println("xxxxxxxxxxxxxxxxxxx");
		}

	}
}
