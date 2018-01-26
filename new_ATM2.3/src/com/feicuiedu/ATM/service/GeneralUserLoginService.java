package com.feicuiedu.ATM.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.feicuiedu.ATM.entity.User;
import com.feicuiedu.ATM.entity.UserBill;

public class GeneralUserLoginService {
	User user = new User();
	UserBill userBill = new UserBill();

	public void guls() {
		Scanner scanner = new Scanner(System.in);
		File file = new File("message" + File.separator + "User.txt");
		String id_account;
		String password;
		System.out.println("请输入账号:");
		try {
			while (true) {
				id_account = scanner.nextLine();
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				HashMap<String, User> hashmap = (HashMap<String, User>) ois.readObject();
				Set<String> keys = hashmap.keySet();
				for (String key : keys) {
					if ((key.startsWith(id_account) && id_account.length() == 18)
							|| (key.endsWith(id_account) && id_account.length() == 21)) {

						User user = hashmap.get(key);

						while (true) {
							System.out.println("请输入密码:");
							password = scanner.nextLine();
							if (user.getPassword().equals(password)) {
								System.out.println(user.getUserName() + "你好,欢迎使用坑你钱银行系统!");
								GeneralUserMenu menu = new GeneralUserMenu(user, userBill);
								menu.gum();

							} else {
								System.out.println("密码输入错误,请重新输入!");
							}
						}
					}
				}

				System.out.println("账号不存在,请重新输入!");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
