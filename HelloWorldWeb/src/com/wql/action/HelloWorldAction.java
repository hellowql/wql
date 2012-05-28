package com.wql.action;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.PreResultListener;
import com.wql.listener.MyPreResult;

public class HelloWorldAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String account;
	private String password;
	private String submitFlag;

	@Override
	public String execute() throws Exception {
		this.businessExecute(); 
		PreResultListener pr=new MyPreResult();
		ActionContext.getContext().getActionInvocation().addPreResultListener(pr);
        return "toWelcome";  
	}

	private void businessExecute() {
		System.out.println("用户输入的参数为==="+"account="+account+",password="+password+",submitFlag="+submitFlag);
	}
	
	@Override
	public void validate(){
		if(StringUtils.isEmpty(StringUtils.trim(account))){
			this.addFieldError("account", this.getText("accountNull"));
		}
		if(StringUtils.isEmpty(StringUtils.trim(password))){
			this.addFieldError("password", this.getText("passwordNull"));
		}else if(StringUtils.trim(password).length()<6){
			this.addFieldError("password", this.getText("passwordLenthShort"));
		}
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
