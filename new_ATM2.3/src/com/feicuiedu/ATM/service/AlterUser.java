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
 * @author 刘政 修改用户信息
 */
public class AlterUser {
	User user = new User();

	public void au() {
		// 构建Scanner,输入身份证号跟账号
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要修改的用户身份证号跟账号:");
		String index = scanner.nextLine();
		File file = new File("message" + File.separator + "User.txt");
		try {

			// 读取User文件中的ArrayList<Map>集合放入q_list中
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			HashMap<String, User> hashmap = (HashMap<String, User>) ois.readObject();

			// 遍历q_list中的Map,取Map的键放入Set集合中
			Set<String> keys = hashmap.keySet();
			// 遍历Set集合,找出与输入的index相同的,将这个map放入ArrayList<User>,并赋值user对象
			for (String key : keys) {
				if (key.equals(index)) {

					User user = hashmap.get(key);

					here1: while (true) {
						// 选择要修改的用户信息1.修改密码2.修改姓名3.修改学历4.修改联系地址
						System.out.println("请选择要修改的选项\n1.修改密码\n2.修改姓名\n3.修改学历\n4.修改联系地址");
						String index1 = scanner.nextLine();
						if (index1.equals("1")) {
							// 修改用户密码,密码要求为8-16位,且至少包含一个阿拉伯数字,一个大写英文字母和一个小写英文字母
							System.out.println("请输入新密码!(密码为8-16位,且至少包含一个阿拉伯数字,一个大写英文字母和一个小写英文字母)");
							String newPassword;
							while (true) {
								newPassword = scanner.nextLine();
								if (newPassword.matches(
										"^(?=.*[\\x00-\\xff].*)(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{8,16}$")) {
									user.setPassword(newPassword);
									break;
								} else {
									System.out.println("密码安全性太弱,请按规定格式输入密码!");
								}
							}
							System.out.println("您的新密码为:" + newPassword);
						} else if (index1.equals("2")) {
							// 修改用户姓名,姓名长度不大于10
							System.out.println("请输入新姓名!");
							String newUserName;
							while (true) {
								newUserName = scanner.nextLine();
								if (newUserName.length() <= 10) {
									user.setUserName(newUserName);
									break;
								} else {
									System.out.println("输入有误,请输入不大于10位的姓名!");
								}
							}
							System.out.println("您的新姓名为:" + newUserName);
						} else if (index1.equals("3")) {
							// 修改学历,选择按键1-4,输入其他按键提示输入有误,重新进行输入
							System.out.println("请输入新学历!");
							String newEducationBackground;
							while (true) {
								newEducationBackground = scanner.nextLine();
								if (newEducationBackground.equals("1")) {
									String edu1 = "小学";
									user.setEducationBackground(edu1);
									break;
								} else if (newEducationBackground.equals("2")) {
									String edu2 = "中学";
									user.setEducationBackground(edu2);
									break;
								} else if (newEducationBackground.equals("3")) {
									String edu3 = "大学";
									user.setEducationBackground(edu3);
									break;
								} else if (newEducationBackground.equals("4")) {
									String edu4 = "其他";
									user.setEducationBackground(edu4);
									break;
								} else {
									System.out.println("输入有误,请输入1-4选择学历!");
								}
							}
							System.out.println("您的新学历为:" + newEducationBackground);
						} else if (index1.equals("4")) {
							// 修改联系地址,长度不大于50
							System.out.println("请输入新联系地址!");
							String newAddress;
							while (true) {
								newAddress = scanner.nextLine();
								if (newAddress.length() <= 50) {
									user.setAddress(newAddress);
									break;
								} else {
									System.out.println("输入有误,请输入长度不大于50的联系地址!");
								}
							}
							System.out.println("您的新联系地址为:" + newAddress);
						} else {
							System.out.println("输入选项有误,是否继续修改!");
						}
						while (true) {
							System.out.println("继续修改请按1,结束修改请按2");
							String index2 = scanner.nextLine();
							if ("1".equals(index2)) {
								break;
							} else if ("2".equals(index2)) {
								break here1;
							} else {
								System.out.println("输入有误,请重新输入!");
							}
						}
					}
					// 修改完成后重新写入文本并返回上一级菜单
					FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					oos.writeObject(hashmap);
					oos.flush();
					oos.close();
					System.out.println("用户信息修改成功,返回上一级菜单!");
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
