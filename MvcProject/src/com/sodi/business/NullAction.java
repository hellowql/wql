package com.sodi.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodi.dao.IPaperDao;
import com.sodi.dao.PaperDaoImpl;
import com.sodi.pojo.Paper;

public class NullAction implements ICommand {
	//1. ȡ�������еĲ�����
	//3. ���ؿ�����Ҫת�����һҳ�� 
	public String execute(HttpServletRequest request, HttpServletResponse response)
	{
		String nextPage=null;	
		nextPage="/WEB-INF/"+request.getParameter("page");
		return nextPage;
	}
}
