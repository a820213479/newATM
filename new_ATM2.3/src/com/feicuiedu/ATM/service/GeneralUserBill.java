package com.feicuiedu.ATM.service;

import java.util.Scanner;

import com.feicuiedu.ATM.entity.User;
import com.feicuiedu.ATM.entity.UserBill;

public class GeneralUserBill {
	private User user;
	private UserBill userBill;

	public GeneralUserBill(User user, UserBill userBill) {
		this.user = user;
		this.userBill = userBill;
	}

	public void gub() {

		while (true) {
			System.out.println("1.查看存款流水\n2.查看取款流水 \n3.查看转账流水\n4.返回上一层");
			Scanner scanner = new Scanner(System.in);
			String bIndex = scanner.next();
			if (bIndex.equals("1")) {

				GeneralUserBill_DE userBill_DE = new GeneralUserBill_DE(user, userBill);
				userBill_DE.gub_d();

			} else if (bIndex.equals("2")) {
				GeneralUserBill_Wm userBill_Wm = new GeneralUserBill_Wm(user, userBill);
				userBill_Wm.gub_w();
			} else if (bIndex.equals("3")) {
				GeneralUserBill_Ta userBill_Ta = new GeneralUserBill_Ta(user, userBill);
				userBill_Ta.gub_t();
			} else if (bIndex.equals("4")) {
				break;
			} else {

			}
		}
	}
}
