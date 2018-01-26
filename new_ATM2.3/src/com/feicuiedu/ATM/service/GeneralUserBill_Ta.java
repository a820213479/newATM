package com.feicuiedu.ATM.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.feicuiedu.ATM.entity.User;
import com.feicuiedu.ATM.entity.UserBill;

public class GeneralUserBill_Ta {

	private User user;
	private UserBill userBill;

	public GeneralUserBill_Ta(User user, UserBill userBill) {
		this.user = user;
		this.userBill = userBill;
	}

	public void gub_t() {
		here: while (true) {

			File file = new File("message" + File.separator + "Money_Ta.txt");

			try {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				HashMap<String, ArrayList<String>> map = (HashMap<String, ArrayList<String>>) ois.readObject();
				Set<String> keys = map.keySet();
				for (String key : keys) {
					if (user.getAccount().equals(key)) {

						System.out.println(map.get(key));
						break;

					}
				}
				ois.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("返回上一层请按1");
			Scanner scanner = new Scanner(System.in);

			while (true) {
				String s = scanner.next();
				if (s.equals("1")) {
					break here;
				} else {
					System.out.println("输入有误,请重新输入!");
				}
			}
		}
	}
}
