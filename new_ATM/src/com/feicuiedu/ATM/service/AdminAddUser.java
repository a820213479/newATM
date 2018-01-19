package com.feicuiedu.ATM.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.feicuiedu.ATM.dao.AdminAddUserDao;
import com.feicuiedu.ATM.entity.User;

/**
 * @author 刘政 开户功能处理
 */
public class AdminAddUser {
	Scanner scanner = new Scanner(System.in);
	User user = new User();

	public void aau() {

		System.out.println("请输入姓名:");
		String userName = scanner.nextLine();
		if (userName.length() <= 10) {
			user.setUserName(userName);
		} else {
			System.out.println("输入有误,请重新输入!");
		}

		System.out.println("请输入性别:(01代表男,02代表女)");
		System.out.println("特别强调:性别请务必确认输入正确,输入成功后不可修改!");
		System.out.println("特别强调:性别请务必确认输入正确,输入成功后不可修改!");
		System.out.println("特别强调:性别请务必确认输入正确,输入成功后不可修改!");
		System.out.println("重要的事情说三遍!!!");
		String gender = scanner.nextLine();

		if (gender.equals("01")) {
			String gen01 = "男";
			user.setGender(gen01);
		} else if (gender.equals("02")) {
			String gen02 = "女";
			user.setGender(gen02);
		} else {
			System.out.println("输入有误,请重新输入!");
		}

		System.out.println("请输入身份证号:");
		System.out.println("特别强调:身份证号请务必确认输入正确,输入成功后不可修改!");
		System.out.println("特别强调:身份证号请务必确认输入正确,输入成功后不可修改!");
		System.out.println("特别强调:身份证号请务必确认输入正确,输入成功后不可修改!");
		System.out.println("重要的事情说三遍!!!");
		String idCardNumber = scanner.nextLine();

		if (idCardNumber.matches("[0-9]{18}")) {

			user.setIdCardNumber(idCardNumber);
		} else {

			System.out.println("xxxxxxxxxxxxxxxxxxx");
		}

		System.out.println("请输入学历:");
		System.out.println("请输入性别:(1代表小学,2代表中学,3代表大学,4代表其他)");
		String educationBackground = scanner.nextLine();

		if (educationBackground.equals("1")) {
			String edu1 = "小学";
			user.setEducationBackground(edu1);
		} else if (educationBackground.equals("2")) {
			String edu2 = "中学";
			user.setEducationBackground(edu2);
		} else if (educationBackground.equals("3")) {
			String edu3 = "大学";
			user.setEducationBackground(edu3);
		} else if (educationBackground.equals("4")) {
			String edu4 = "其他";
			user.setEducationBackground(edu4);
		} else {

			System.out.println("xxxxxxxxxxxxxxxxxxx");
		}

		System.out.println("请输入联系地址:");
		String address = scanner.nextLine();
		if (address.length() <= 50) {

			user.setAddress(address);
		} else {

			System.out.println("xxxxxxxxxxxxxxxxxxx");
		}

		user.setAddress(address);

		System.out.println("请设置密码:");
		String password = scanner.nextLine();
		user.setPassword(password);

		SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String time = dateformat1.format(new Date());
		// System.out.println(time);

		String account = "37" + gender + time;
		user.setAccount(account);

		Double balance = 0.0;
		user.setBalance(balance);
		
		
		/*ArrayList<User> list = new ArrayList<>();
		list.add(user);
		
		String idkey = user.getIdCardNumber() + user.getAccount();
		Map<String,ArrayList<User>> map1 = new HashMap<>();
		map1.put(idkey,map1);*/
		
		
		AdminAddUserDao addUserDao = new AdminAddUserDao(user);
		addUserDao.aaud();
		
		
		
	}
}
