package com.feicuiedu.ATM.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.feicuiedu.ATM.dao.AdminAddUserDao;
import com.feicuiedu.ATM.dao.Bill_De_Dao;
import com.feicuiedu.ATM.dao.Bill_Ta_Dao;
import com.feicuiedu.ATM.dao.Bill_Wm_Dao;
import com.feicuiedu.ATM.entity.User;
import com.feicuiedu.ATM.entity.UserBill;

/**
 * @author 刘政 开户功能处理
 */
public class AdminAddUser {
	Scanner scanner = new Scanner(System.in);
	User user = new User();
	UserBill userBill = new UserBill();

	public void aau() {
		// 输入用户姓名,姓名长度不大于10
		System.out.println("请输入姓名:");
		String userName;
		while (true) {
			userName = scanner.nextLine();
			if (userName.length() <= 10) {
				user.setUserName(userName);
				break;
			} else {
				System.out.println("输入有误,请输入不大于10位的姓名!");
			}
		}
		// 选择性别,性别选择后用于户账号生成
		System.out.println("请输入性别:(01代表男,02代表女)");
		System.out.println("特别强调:性别请务必确认输入正确,输入成功后不可修改!");
		System.out.println("特别强调:性别请务必确认输入正确,输入成功后不可修改!");
		System.out.println("特别强调:性别请务必确认输入正确,输入成功后不可修改!");
		System.out.println("重要的事情说三遍!!!");
		String gender;
		while (true) {
			gender = scanner.nextLine();
			if (gender.equals("01")) {
				String gen01 = "男";
				user.setGender(gen01);
				break;
			} else if (gender.equals("02")) {
				String gen02 = "女";
				user.setGender(gen02);
				break;
			} else {
				System.out.println("输入有误,请输入01或02选择性别!");
			}
		}
		// 输入身份证号,身份证号输入后不可修改
		System.out.println("请输入身份证号:");
		System.out.println("特别强调:身份证号请务必确认输入正确,输入成功后不可修改!");
		System.out.println("特别强调:身份证号请务必确认输入正确,输入成功后不可修改!");
		System.out.println("特别强调:身份证号请务必确认输入正确,输入成功后不可修改!");
		System.out.println("重要的事情说三遍!!!");
		String idCardNumber;
		while (true) {
			idCardNumber = scanner.nextLine();
			// 身份证号由18位数字组成,输入不符合规范则重新进行输入
			if (idCardNumber.matches("[0-9]{18}")) {
				user.setIdCardNumber(idCardNumber);
				break;
			} else {
				System.out.println("输入有误,请输入18位数字的身份证号!");
			}
		}
		// 选择学历,选择按键1-4,输入其他按键提示输入有误,重新进行输入
		System.out.println("请输入学历:(1代表小学,2代表中学,3代表大学,4代表其他)");
		String educationBackground;
		while (true) {
			educationBackground = scanner.nextLine();
			if (educationBackground.equals("1")) {
				String edu1 = "小学";
				user.setEducationBackground(edu1);
				break;
			} else if (educationBackground.equals("2")) {
				String edu2 = "中学";
				user.setEducationBackground(edu2);
				break;
			} else if (educationBackground.equals("3")) {
				String edu3 = "大学";
				user.setEducationBackground(edu3);
				break;
			} else if (educationBackground.equals("4")) {
				String edu4 = "其他";
				user.setEducationBackground(edu4);
				break;
			} else {
				System.out.println("输入有误,请输入1-4选择学历!");
			}
		}
		// 输入联系地址,长度不大于50
		System.out.println("请输入联系地址:");
		String address;
		while (true) {
			address = scanner.nextLine();
			if (address.length() <= 50) {
				user.setAddress(address);
				break;
			} else {
				System.out.println("输入有误,请输入长度不大于50的联系地址!");
			}
		}
		// 设置用户密码,密码要求为8-16位,且至少包含一个阿拉伯数字,一个大写英文字母和一个小写英文字母
		System.out.println("请设置密码:(密码为8-16位,且至少包含一个阿拉伯数字,一个大写英文字母和一个小写英文字母)");
		String password;
		while (true) {
			password = scanner.nextLine();
			if (password.matches("^(?=.*[\\x00-\\xff].*)(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{8,16}$")) {
				user.setPassword(password);
				break;
			} else {
				System.out.println("密码安全性太弱,请按规定格式输入密码!");
			}
		}
		// 生成时间戳,用于唯一账号的生成
		SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String time = dateformat1.format(new Date());
		// System.out.println(time);
		// 自动生成账号,账号格式为37+性别编号+时间戳
		String account = "37" + gender + time;
		user.setAccount(account);
		// 默认初始余额为0.0元
		Double balance = 0.0;
		user.setBalance(balance);
		// 账号生成后调用存储方法存入文本

		AdminAddUserDao addUserDao = new AdminAddUserDao(user, userBill);
		addUserDao.aaud();

		Bill_De_Dao bill_dao = new Bill_De_Dao(user, userBill);
		bill_dao.bdd();

		Bill_Wm_Dao wm_dao = new Bill_Wm_Dao(user, userBill);
		wm_dao.bwd();

		Bill_Ta_Dao ta_dao = new Bill_Ta_Dao(user, userBill);
		ta_dao.btd();

		// 存储成功后提示新增成功
		System.out.println("开户成功,用户账号为:" + account + ",请牢记账号密码!");
		System.out.println("正在返回上一级菜单!");
		System.out.println("返回成功!");
	}
}
