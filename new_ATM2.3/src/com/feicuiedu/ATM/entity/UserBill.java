package com.feicuiedu.ATM.entity;

import java.io.Serializable;

public class UserBill implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String dTime;
	private Double balance_d = 0.0;
	private String wTime;
	private Double balance_w = 0.0;
	private String tTime;
	private Double balance_t = 0.0;

	public String getdTime() {
		return dTime;
	}

	public void setdTime(String dTime) {
		this.dTime = dTime;
	}

	public Double getBalance_d() {
		return balance_d;
	}

	public void setBalance_d(Double balance_d) {
		this.balance_d = balance_d;
	}

	public String getwTime() {
		return wTime;
	}

	public void setwTime(String wTime) {
		this.wTime = wTime;
	}

	public double getBalance_w() {
		return balance_w;
	}

	public void setBalance_w(Double balance_w) {
		this.balance_w = balance_w;
	}

	public String gettTime() {
		return tTime;
	}

	public void settTime(String tTime) {
		this.tTime = tTime;
	}

	public double getBalance_t() {
		return balance_t;
	}

	public void setBalance_t(Double balance_t) {
		this.balance_t = balance_t;
	}
}
