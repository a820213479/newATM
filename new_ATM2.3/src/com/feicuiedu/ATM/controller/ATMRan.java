package com.feicuiedu.ATM.controller;

import java.util.Scanner;

import com.feicuiedu.ATM.service.AdminLoginSercice;
import com.feicuiedu.ATM.service.GeneralUserLoginService;

/**
 * @author 刘政 登录界面选择
 */
public class ATMRan {
	public void ATM_Run() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("1.管理员登录");
		System.out.println("2.普通用户登录");
		// 进入登录界面,选择登录用户
		// 输入按键1.管理员登录用户,按键2.普通用户登录,输入其他按键提示输入有误,重新进行输入
		while (true) {
			String RIndex = scanner.next();
			if (RIndex.equals("1")) {
				AdminLoginSercice adminLogin = new AdminLoginSercice();
				adminLogin.als();
			} else if (RIndex.equals("2")) {
				GeneralUserLoginService generalUserLogin = new GeneralUserLoginService();
				generalUserLogin.guls();
			} else {
				System.out.println("输入有误,请重新输入!");
			}
		}
	}
}
