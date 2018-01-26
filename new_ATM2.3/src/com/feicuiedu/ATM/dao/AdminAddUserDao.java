package com.feicuiedu.ATM.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.feicuiedu.ATM.entity.User;
import com.feicuiedu.ATM.entity.UserBill;

/**
 * @author 刘政 将新增用户存储到文本
 */
public class AdminAddUserDao {
	private User user;
	private UserBill userBill;

	public AdminAddUserDao(User user, UserBill userBill) {
		this.user = user;
		this.userBill = userBill;
	}

	public void aaud() {

		File file = new File("message" + File.separator + "User.txt");

		// 创建HashMap,提取用户的身份证跟账号作为key,User作为value,将user传入map
		String idkey = user.getIdCardNumber() + user.getAccount();
		Map<String, User> map = new HashMap<>();
		map.put(idkey, user);

		try {
			// 判断User文本是否为空
			FileInputStream f = new FileInputStream(file);
			byte[] by = new byte[1024];
			int size = f.available();
			// 如果为空,将HashMap,并将map放入arrayList,之后写入文本
			if (size == 0) {

				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(map);
				oos.flush();
				oos.close();
			} else {
				// 如果不为空,先读取文本中的信息写入arrayList1,然后将map添加到arrayList1,再将arrayList1写入文本
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Map<String, User> map1 = new HashMap<>();
				map1 = (Map<String, User>) ois.readObject();
				map1.put(idkey, user);
				FileOutputStream fos1 = new FileOutputStream(file);
				ObjectOutputStream oos1 = new ObjectOutputStream(fos1);

				oos1.writeObject(map1);
				oos1.flush();
				oos1.close();
				ois.close();
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
