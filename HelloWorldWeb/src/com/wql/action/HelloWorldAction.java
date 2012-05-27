package com.wql.action;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action {
	private String account;
	private String password;
	private String submitFlag;
	

	@Override
	public String execute() throws Exception {
		System.out.println("用户输入的参数为==="+"account="+account+",password="+password+",submitFlag="+submitFlag);  
        return "toWelcome";  
	}
	
	
//	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
//		HelloWorldModel hwm=(HelloWorldModel) req.getAttribute("helloModel");
////		hwm.bussinessExecute();
//		System.out.println("this is post");
//		System.out.println("用户输入的参数为："+hwm);
//		req.setAttribute("hwm", hwm);
//		req.getRequestDispatcher("/servletimpl/welcome.jsp").forward(req, resp);
//    }

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
