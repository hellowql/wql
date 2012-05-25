package com.sodi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodi.business.ICommand;

public class Controller extends HttpServlet {
    
	public void process(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String next=null;
		String cmd=request.getParameter("cmd");//取出请求中参数cmd的值
		System.out.println("cmd="+cmd);
		Properties props=new Properties();
		//通过类加载器读取属性文件的内容放入输入流
		InputStream in=this.getClass().getClassLoader().getResourceAsStream("config.properties");
		//将输入流加载进Properties对象
		props.load(in);
		ICommand command=null;
		String className=props.getProperty(cmd); //根据cmd的值获得对应的Business的全限定名
		try {
			Class c=Class.forName(className); //获得Business的Class对象
			command=(ICommand)c.newInstance(); //通过Class对象获得其实例，因为所有的Business都实现了ICommand接口，所以不管其实际类型是什么，都强转为ICommand
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//根据不同的cmd调用不同的Business
		/*if("showAll".equals(cmd))
		{
			ShowAllAction showAllAction=new ShowAllAction();
			next=showAllAction.execute(request, response); //通过Business完成业务逻辑；接受要返回的下一页面的地址
		}
		else if("NullDispatcher".equals(cmd))
		{
			NullAction nullAction=new NullAction();
			next=nullAction.execute(request, response);
		}
		else if("verifyLogin".equals(cmd))
		{
			VerifyLoginAction verifyLoginAction=new VerifyLoginAction();
			next=verifyLoginAction.execute(request, response);
		}*/
		next=command.execute(request, response); //调用接口中定义的execute方法，完成业务逻辑 ；这里体现了动态多态 
		System.out.println("next="+next);
		//3. 接受业务逻辑Bean的返回值，转向下一页面
		this.getServletContext().getRequestDispatcher(next).forward(request, response);		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request,response);
	}

}
