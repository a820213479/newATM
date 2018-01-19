package com.feicuiedu.ATM.entity;

import java.io.Serializable;

public class User implements Serializable{
	private String account;
	private String password;
	private String userName;
	private String gender;
	private String idCardNumber;
	private String educationBackground;
	private Double balance;
	private String address;
	
	
	/*public User(String account, String password, String userName, String gender, String idCardNumber,
			String educationBackground, Double balance, String address) {
		
	}*/
	public String getAccount() {
		return account;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	
	public String getIdCardNumber() {
		return idCardNumber;
	}
	
	public String getEducationBackground() {
		return educationBackground;
	}
	public void setEducationBackground(String educationBackground) {
		this.educationBackground = educationBackground;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "账号:" + account + ", 密码:" + password + ", 姓名:" + userName + ", 性别:" + gender
				+ ", 身份证号:" + idCardNumber + ", 学历:" + educationBackground + ", 余额:"
				+ balance + ", 联系地址:" + address;
	}
	
	
	
}
