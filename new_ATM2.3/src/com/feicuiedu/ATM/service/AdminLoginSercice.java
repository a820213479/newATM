package com.feicuiedu.ATM.service;

import java.util.Scanner;

import com.feicuiedu.ATM.controller.ATMRan;

/**
 * @author 刘政 管理员登录
 */
public class AdminLoginSercice {
	Scanner scanner = new Scanner(System.in);

	public void als() {
		// 先进行账号判断,账号输入错误重新输入
		// 账号判断通过后判断密码,密码输入错误则重新输入密码,账号密码全部通过后进入功能菜单
		here: while (true) {
			System.out.println("请输入用户名:");
			String adminUserName = scanner.next();
			if (adminUserName.equals("admin")) {
				System.out.println("请输入密码:");
				while (true) {
					String adminUserPassword = scanner.next();
					if (adminUserPassword.equals("123456")) {
						break here;
					} else {
						System.out.println("密码输入错误,请重新输入!");
					}
				}
			} else {
				System.out.println("账号不存在,请重新输入!");
			}
		}

		// 登录成功,进入管理员功能选择菜单
		System.out.println("请选择功能项目");
		// 1.开户2.销户3.显示所用用户信息4.修改账户信息5.返回登录界面
		// 输入1-5选择功能,输入其他按键提示输入有误,重新进行按键选择
		while (true) {
			System.out.println("1.开户\n2.销户\n3.显示所有用户信息\n4.修改账户信息\n5.退出登录");
			String index = scanner.next();
			if (index.equals("1")) {
				AdminAddUser addUser = new AdminAddUser();// 选择1进入开户功能
				addUser.aau();
			} else if (index.equals("2")) {
				DelUser delUser = new DelUser();// 选择2进入销户功能
				delUser.du();
			} else if (index.equals("3")) {
				QueryUser queryUser = new QueryUser();// 选择3显示所有用户信息
				queryUser.qu();
			} else if (index.equals("4")) {
				AlterUser alterUser = new AlterUser();// 选择4进入修改用户信息功能
				alterUser.au();
			} else if (index.equals("5")) {
				ATMRan run = new ATMRan();// 选择5返回登录界面
				run.ATM_Run();
			} else {
				System.out.println("输入有误,请重新输入!");// 输入其他按键返回重新进行选择
			}
		}
	}
}
