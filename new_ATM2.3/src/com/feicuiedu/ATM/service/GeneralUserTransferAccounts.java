package com.feicuiedu.ATM.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.feicuiedu.ATM.dao.BaseDao;
import com.feicuiedu.ATM.entity.User;
import com.feicuiedu.ATM.entity.UserBill;

public class GeneralUserTransferAccounts {

	private User user;
	private UserBill userBill;

	public GeneralUserTransferAccounts(User user, UserBill userBill) {
		this.user = user;
		this.userBill = userBill;
	}

	Scanner scanner = new Scanner(System.in);

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
	String ta = sdf.format(new Date());

	public void guta() throws IOException, ClassNotFoundException {
		here: while (true) {
			while (true) {
				System.out.println("请输入对方银行卡号:");
				String indexCardNumber = scanner.next();

				File file = new File("message" + File.separator + "User.txt");

				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);

				HashMap<String, User> hashmap = (HashMap<String, User>) ois.readObject();
				Set<String> keys = hashmap.keySet();
				for (String key : keys) {

					if (key.endsWith(indexCardNumber)) {

						System.out.println("请输入转账金额:");
						double indexBalance = scanner.nextDouble();

						if (indexBalance >= 0 && indexBalance <= user.getBalance()) {

							System.out.println("1.确认\n2.重新输入\n3.返回主菜单");

							String index = scanner.next();

							while (true) {
								if (index.equals("1")) {

									System.out.println("1.确认转账\n2.返回上一级\n3.退卡");
									String index2 = scanner.next();

									if (index2.equals("1")) {
										userBill.setBalance_t(user.getBalance());
										double bal = user.getBalance() - indexBalance;
										user.setBalance(bal);
										userBill.settTime(ta);

										FileInputStream fis1 = new FileInputStream(file);
										ObjectInputStream ois1 = new ObjectInputStream(fis1);
										HashMap<String, User> hashmap1 = (HashMap<String, User>) ois1.readObject();

										String str = user.getIdCardNumber() + user.getAccount();

										hashmap1.put(str, user);
										FileOutputStream fos1 = new FileOutputStream(file);
										ObjectOutputStream oos1 = new ObjectOutputStream(fos1);

										oos1.writeObject(hashmap1);

										oos1.flush();
										oos1.close();
										ois1.close();

										
										/*BaseDao basedao = new BaseDao(user, userBill);
										basedao.bd();*/
										
										File file2 = new File("message" + File.separator + "Money_Ta.txt");

										try {

											FileInputStream fis2 = new FileInputStream(file2);
											ObjectInputStream ois2 = new ObjectInputStream(fis2);
											Map<String, ArrayList<String>> map2 = (Map<String, ArrayList<String>>) ois2
													.readObject();
											Set<String> keys2 = map2.keySet();

											for (String key2 : keys2) {

												if (key2.equals(user.getAccount())) {
													map2.get(key2)
															.add("\n转账前余额:" + userBill.getBalance_t() + "   转账后余额:"
																	+ user.getBalance() + "   转账时间:"
																	+ userBill.gettTime());
													break;
												}
											}

											FileOutputStream fos2 = new FileOutputStream(file2);
											ObjectOutputStream oos2 = new ObjectOutputStream(fos2);

											oos2.writeObject(map2);
											oos2.flush();
											oos2.close();
											ois2.close();
										} catch (FileNotFoundException e) {
											e.printStackTrace();
										} catch (IOException e) {
											e.printStackTrace();
										} catch (ClassNotFoundException e) {
											e.printStackTrace();
										}

										Set<String> keys2 = hashmap1.keySet();
										for (String key2 : keys2) {
											if (key2.endsWith(indexCardNumber)) {

												User user = hashmap1.get(key2);
												user.setBalance(user.getBalance() + indexBalance);
												System.out.println(user);

												File file3 = new File("message" + File.separator + "Money_Ta.txt");

												try {

													FileInputStream fis3 = new FileInputStream(file3);
													ObjectInputStream ois3 = new ObjectInputStream(fis3);
													Map<String, ArrayList<String>> map3 = (Map<String, ArrayList<String>>) ois3
															.readObject();
													Set<String> keys3 = map3.keySet();

													for (String key3 : keys3) {

														if (key3.equals(user.getAccount())) {
															map3.get(key3)
																	.add("\n收账前余额:" + userBill.getBalance_t()
																			+ "   收账后余额:" + user.getBalance()
																			+ "   收账时间:" + userBill.gettTime());
															break;
														}
													}

													FileOutputStream fos3 = new FileOutputStream(file3);
													ObjectOutputStream oos3 = new ObjectOutputStream(fos3);

													oos3.writeObject(map3);
													oos3.flush();
													oos3.close();
													ois3.close();
												} catch (FileNotFoundException e) {
													e.printStackTrace();
												} catch (IOException e) {
													e.printStackTrace();
												} catch (ClassNotFoundException e) {
													e.printStackTrace();
												}

											}

											break;
										}

										System.out.println("成功转账:" + indexBalance + "元");
										System.out.println("存款时间:" + ta);
										System.out.println("转账成功,正在返回主菜单!");
										System.out.println("返回主菜单成功!");
										break here;

									} else if (index2.equals("2")) {

										System.out.println("正在返回上一级...");
										break;

									} else if (index2.equals("3")) {

										GeneralUserMenu userMenu = new GeneralUserMenu(user, userBill);
										userMenu.gum();

									} else {

										System.out.println("输入有误,请重新输入!");
									}

								} else if (index.equals("2")) {

									break;

								} else if (index.equals("3")) {

									break here;

								} else {
									System.out.println("输入有误,请重新输入!");
								}

							}

						} else if (indexBalance > user.getBalance()) {

							System.out.println("余额不足!");

						} else {

							System.out.println("输入有误,请重新输入!");

						}

					}

				}

				ois.close();

			}
		}
	}
}
