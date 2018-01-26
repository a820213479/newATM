package com.feicuiedu.ATM.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import com.feicuiedu.ATM.entity.User;
import com.feicuiedu.ATM.entity.UserBill;

public class GeneralDeDao {

	private User user;
	private UserBill userBill;

	public GeneralDeDao(User user, UserBill userBill) {

		this.user = user;
		this.userBill = userBill;

	}

	public void gdd() {

		File file = new File("message" + File.separator + "Money_De.txt");

		try {

			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);

			Map<String, ArrayList<String>> map = (Map<String, ArrayList<String>>) ois.readObject();
			Set<String> keys = map.keySet();
			for (String key : keys) {

				if (key.equals(user.getAccount())) {

					map.get(key).add("\n存款前余额:" + userBill.getBalance_d() + "   存款后余额:" + user.getBalance() + "   存款时间:"
							+ userBill.getdTime());
					break;
				}
			}

			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(map);
			oos.flush();
			oos.close();
			ois.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
