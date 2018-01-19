package com.feicuiedu.ATM.controller;

import java.util.Scanner;

import com.feicuiedu.ATM.service.AdminLoginSercice;
import com.feicuiedu.ATM.service.GeneralUserLoginService;

public class ATMRan {
	public void ATM_Run() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("1.管理员登录");
		System.out.println("2.普通用户登录");
		String RIndex = scanner.next();
		if (RIndex.equals("1")) {
			AdminLoginSercice adminLogin = new AdminLoginSercice();
			adminLogin.als();
		} else if (RIndex.equals("2")) {
			GeneralUserLoginService generalUserLogin = new GeneralUserLoginService();
			generalUserLogin.guls();

		} else {

		}

	}
}
