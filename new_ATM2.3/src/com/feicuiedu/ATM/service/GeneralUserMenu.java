package com.feicuiedu.ATM.service;

import java.io.IOException;
import java.util.Scanner;

import com.feicuiedu.ATM.controller.ATMRan;
import com.feicuiedu.ATM.entity.User;
import com.feicuiedu.ATM.entity.UserBill;

public class GeneralUserMenu {

	private User user;
	private UserBill userBill;

	public GeneralUserMenu(User user, UserBill userBill) {
		this.user = user;
		this.userBill = userBill;
	}

	public void gum() {

		while (true) {
			System.out.println("请选择要办理的业务");
			System.out.println("******************************");
			System.out.println("1.查询\n2.转账\n3.取款\n4.存款\n5.流水\n6.退出登录");
			System.out.println("******************************");

			Scanner scanner = new Scanner(System.in);

			String index = scanner.next();
			if (index.equals("1")) {
				// 如果选择1.查询,进去信息查询界面进行操作
				GeneralUserQuery userQuery = new GeneralUserQuery(user);
				userQuery.guq();
				System.out.println("返回上一级请按  1");
				// 选择返回上一层按键 1 时,从查询界面返回菜单界面,输入其他字符提示:输入有误,请重新输入!
				while (true) {
					String returnMenu = scanner.next();
					if (returnMenu.equals("1")) {
						break;
					} else {
						System.out.println("输入有误,请重新输入!");
					}
				}
			} else if (index.equals("2")) {
				// 选择2.转账时,进入转账功能页面进行操作
				GeneralUserTransferAccounts userTransferAccounts = new GeneralUserTransferAccounts(user, userBill);

				try {
					userTransferAccounts.guta();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (index.equals("3")) {
				// 选择3.取款时,进入取款功能页面进行操作
				GeneralUserWithdrawMoney userWithdrawMoney = new GeneralUserWithdrawMoney(user, userBill);

				userWithdrawMoney.guwm();

			} else if (index.equals("4")) {
				// 选择4.存款时,进入取款功能页面进行操作
				GeneralUserDeposit userDeposit = new GeneralUserDeposit(user, userBill);
				userDeposit.gud();

			} else if (index.equals("5")) {
				// 选择5.流水时,进入流水功能页面进行操作
				GeneralUserBill userBill0 = new GeneralUserBill(user, userBill);
				userBill0.gub();

			} else if (index.equals("6")) {
				// 选择6.退出登录时,返回登录界面
				ATMRan run = new ATMRan();
				run.ATM_Run();
			} else {
				System.out.println("输入有误,请重新输入!");
			}
		}
	}

}
