package com.feicuiedu.ATM.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.feicuiedu.ATM.entity.User;

public class AdminAddUserDao {
	private User user;

	public AdminAddUserDao(User user) {
		this.user = user;
	}

	public void aaud() {

		File file = new File("User.txt");

		ArrayList<User> list = new ArrayList<>();
		list.add(user);

		String idkey = user.getIdCardNumber() + user.getAccount();
		Map<String, ArrayList<User>> map1 = new HashMap<>();
		map1.put(idkey, list);

		try {

			FileInputStream fff = new FileInputStream("User.txt");
			byte[] by = new byte[1024];
			int size = fff.available();

			if (size == 0) {
				ArrayList<Map> arrayList = new ArrayList<>();
				arrayList.add(map1);
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(arrayList);
				oos.flush();
				oos.close();

			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				ArrayList<Map> arrayList1 = (ArrayList<Map>) ois.readObject();

				arrayList1.add(map1);

				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(arrayList1);
				oos.flush();
				oos.close();

			}

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		try {
			FileInputStream fis1 = new FileInputStream(file);
			ObjectInputStream ois1 = new ObjectInputStream(fis1);

			ArrayList<Map> list2 = (ArrayList<Map>) ois1.readObject();
			for (Map map2 : list2) {

				Set<String> keys = map2.keySet();
				ArrayList<User> userList = null;

				for (String key : keys) {

					userList = (ArrayList<User>) map2.get(key);

					for (User user1 : userList) {
						System.out.println(user1);
					}
				}

			}

			ois1.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
