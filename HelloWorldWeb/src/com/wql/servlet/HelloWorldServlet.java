package com.wql.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wql.vo.HelloWorldModel;

public class HelloWorldServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		doPost(req, resp);
    }
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		HelloWorldModel hwm=(HelloWorldModel) req.getAttribute("helloModel");
//		hwm.bussinessExecute();
		System.out.println("用户输入的参数为："+hwm);
		req.setAttribute("hwm", hwm);
		req.getRequestDispatcher("/servletimpl/welcome.jsp").forward(req, resp);
    }

}
