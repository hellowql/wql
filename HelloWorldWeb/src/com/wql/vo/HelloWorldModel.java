package com.wql.vo;

public class HelloWorldModel {
	private String account;
	private String password;
	private String submitFlag;
	
	public void bussinessExecute(){
		System.out.println("系统处理业务逻辑");
	}
	
	public String getAccount() {
		return account;
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
	public String getSubmitFlag() {
		return submitFlag;
	}
	public void setSubmitFlag(String submitFlag) {
		this.submitFlag = submitFlag;
	}
	
}
