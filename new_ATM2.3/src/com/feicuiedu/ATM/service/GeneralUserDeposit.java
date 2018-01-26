package com.feicuiedu.ATM.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.feicuiedu.ATM.dao.BaseDao;
import com.feicuiedu.ATM.dao.GeneralDeDao;
import com.feicuiedu.ATM.entity.User;
import com.feicuiedu.ATM.entity.UserBill;

public class GeneralUserDeposit {

	Scanner scanner = new Scanner(System.in);

	private User user;
	private UserBill userBill;

	public GeneralUserDeposit(User user, UserBill userBill) {
		this.user = user;
		this.userBill = userBill;
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
	String dt = sdf.format(new Date());

	public void gud() {

		here: while (true) {
			System.out.println("请输入存款金额:");
			double dIndex = scanner.nextDouble();

			if (dIndex % 100 == 0) {

				here1: while (true) {
					System.out.println("1.确认\n2.重新输入\n3.返回主菜单");
					String dIndex2 = scanner.next();
					while (true) {

						if (dIndex2.equals("1")) {

							userBill.setBalance_d(user.getBalance());
							double bal = user.getBalance() + dIndex;
							user.setBalance(bal);
							userBill.setdTime(dt);

							BaseDao basedao = new BaseDao(user, userBill);
							basedao.bd();

							GeneralDeDao dedao = new GeneralDeDao(user, userBill);
							dedao.gdd();

							System.out.println("成功存款:" + dIndex + "元");
							System.out.println("存款时间:" + dt);
							System.out.println("存款成功,正在返回主菜单!");
							System.out.println("返回主菜单成功!");
							break here;
						} else if (dIndex2.equals("2")) {
							break here1;
						} else if (dIndex2.equals("3")) {

							System.out.println("正在返回主菜单!");
							System.out.println("返回主菜单成功!");
							break here;
						} else {
							System.out.println("输入有误,请重新输入!");
							break;
						}
					}
					continue;
				}
			} else if (dIndex % 100 != 0) {
				System.out.println("请输入100的整数倍存款金额!");

			} else {
				System.out.println("输入有误,请重新输入!");
			}
		}
	}

}
