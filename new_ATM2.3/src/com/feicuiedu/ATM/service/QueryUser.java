package com.feicuiedu.ATM.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.feicuiedu.ATM.entity.User;

/**
 * @author 刘政 查询所有账户信息
 */
public class QueryUser {
	public void qu() {
		File file = new File("message" + File.separator + "User.txt");
		while (true) {
			try {
				// 创建新的ArrayList<Map>,将文本中的信息写入list并打印到控制台
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				HashMap<String, User> hashmap = (HashMap<String, User>) ois.readObject();
				Set<String> keys = hashmap.keySet();

				for (String key : keys) {
					User user = (User) hashmap.get(key);
					System.out.println(user);
				}
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 信息显示结束,提示按任意键返回上一级
			System.out.println("请按任意键返回上一层");
			Scanner scanner = new Scanner(System.in);
			String index = scanner.nextLine();
			break;
		}
	}
}
