package com.feicuiedu.ATM.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

import com.feicuiedu.ATM.entity.User;
import com.feicuiedu.ATM.entity.UserBill;

public class BaseDao {
	private User user;
	private UserBill userBill;

	public BaseDao(User user, UserBill userBill) {
		this.user = user;
		this.userBill = userBill;
	}

	public void bd() {

		try {
			File file = new File("message" + File.separator + "User.txt");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);

			HashMap<String, User> hashmap = (HashMap<String, User>) ois.readObject();

			Set<String> keys = hashmap.keySet();
			System.out.println(user.getAccount());
			String str = user.getIdCardNumber() + user.getAccount();
			for (String key : keys) {
				if (key.equals(str)) {

					hashmap.put(str, user);

					FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					oos.writeObject(hashmap);
					oos.flush();
					oos.close();
					ois.close();
					break;
				}
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
