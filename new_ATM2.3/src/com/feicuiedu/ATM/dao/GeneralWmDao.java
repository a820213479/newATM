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

public class GeneralWmDao {
	private User user;
	private UserBill userBill;

	public GeneralWmDao(User user, UserBill userBill) {

		this.user = user;
		this.userBill = userBill;

	}

	public void gwd() {

		File file = new File("message" + File.separator + "Money_Wm.txt");

		try {

			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Map<String, ArrayList<String>> map = (Map<String, ArrayList<String>>) ois.readObject();
			Set<String> keys = map.keySet();

			for (String key : keys) {

				if (key.equals(user.getAccount())) {
					map.get(key).add("\n取款前余额:" + userBill.getBalance_w() + "   取款后余额:"
							+ user.getBalance() + "   取款时间:" + userBill.getwTime());
					break;
				}
			}

			FileOutputStream fos1 = new FileOutputStream(file);
			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);

			oos1.writeObject(map);
			oos1.flush();
			oos1.close();
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
