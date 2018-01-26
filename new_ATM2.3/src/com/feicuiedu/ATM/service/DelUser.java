package com.feicuiedu.ATM.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.feicuiedu.ATM.entity.User;

/**
 * @author 刘政 删除用户信息
 *
 */
public class DelUser {
	public void du() {
		// 构建Scanner,输入身份证号跟账号
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要删除的用户身份证号跟账号:");
		String index = scanner.nextLine();
		File file = new File("message" + File.separator + "User.txt");
		try {
			// 读取User文件中的ArrayList<Map>集合放入d_list中
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			HashMap<String, User> hashmap = (HashMap<String, User>) ois.readObject();
			// 遍历d_list中的Map,取Map的键放入Set集合中
			Set<String> keys = hashmap.keySet();
			// 遍历Set集合,找出与输入的index相同的,将这个map从d_list中删除,并将新的d_list重新写入文本
			for (String key : keys) {
				if (key.equals(index)) {
					hashmap.remove(index);
					FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					oos.writeObject(hashmap);
					oos.flush();
					oos.close();
					System.out.println("用户销户成功!");
					break;
				}
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
