package com.sodi.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodi.dao.IPaperDao;
import com.sodi.dao.PaperDaoImpl;
import com.sodi.pojo.Paper;

public class ShowAllAction implements ICommand{
	//1. 取出请求中的参数，
	//3. 返回控制器要转向的下一页面 
	public String execute(HttpServletRequest request, HttpServletResponse response)
	{
		String nextPage=null;
		IPaperDao paperDao=new PaperDaoImpl();
		List<Paper> list=paperDao.getAllPaper(); //调用 Dao完成业务逻辑 
		request.setAttribute("paperList", list); //准备下一页面要显示的数据
		nextPage="/WEB-INF/main.jsp";
		return nextPage;
	}
}
