package com.feicuiedu.ATM.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.feicuiedu.ATM.dao.BaseDao;
import com.feicuiedu.ATM.dao.GeneralWmDao;
import com.feicuiedu.ATM.entity.User;
import com.feicuiedu.ATM.entity.UserBill;

public class GeneralUserWithdrawMoney {
	private User user;
	private UserBill userBill;

	public GeneralUserWithdrawMoney(User user, UserBill userBill) {
		this.user = user;
		this.userBill = userBill;
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
	String wt = sdf.format(new Date());

	Scanner scanner = new Scanner(System.in);

	public void guwm() {
		here: while (true) {
			System.out.println("请输入取款金额:");
			double wIndex = scanner.nextDouble();

			if (wIndex % 100 == 0 && wIndex <= user.getBalance()) {

				here1: while (true) {
					System.out.println("1.确认\n2.重新输入\n3.返回主菜单");
					String wIndex2 = scanner.next();
					while (true) {

						if (wIndex2.equals("1")) {
							userBill.setBalance_w(user.getBalance());
							double bal = user.getBalance() - wIndex;
							user.setBalance(bal);
							userBill.setwTime(wt);

							/*try {
								File file = new File("message" + File.separator + "User.txt");
								FileInputStream fis = new FileInputStream(file);
								ObjectInputStream ois = new ObjectInputStream(fis);

								HashMap<String, User> hashmap = (HashMap<String, User>) ois.readObject();

								Set<String> keys = hashmap.keySet();

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
							}*/

							BaseDao basedao = new BaseDao(user, userBill);
							basedao.bd();
							
							GeneralWmDao wmdao = new GeneralWmDao(user, userBill);
							wmdao.gwd();

							System.out.println("成功取款:" + wIndex + "元");
							System.out.println("存款时间:" + wt);
							System.out.println("取款成功,正在返回主菜单!");
							System.out.println("返回主菜单成功!");
							break here;
						} else if (wIndex2.equals("2")) {
							break here1;
						} else if (wIndex2.equals("3")) {

							System.out.println("正在返回主菜单!");
							System.out.println("返回主菜单成功!");
							break here;
						} else {
							System.out.println("输入有误,请重新输入!");
							break;
						}
					}
					continue;
				}
			} else if (wIndex % 100 != 0 && wIndex <= user.getBalance()) {
				System.out.println("请输入100的整数倍取款金额!");

			} else if (wIndex % 100 != 0 && wIndex > user.getBalance()) {
				System.out.println("余额不足,请输入100的整数倍取款金额!");

			} else if (wIndex % 100 == 0 && wIndex > user.getBalance()) {
				System.out.println("余额不足!");

			} else {
				System.out.println("输入有误,请重新输入!");
			}
		}
	}
}
