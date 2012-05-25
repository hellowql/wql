package com.sodi.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sodi.dao.IPaperDao;
import com.sodi.dao.PaperDaoImpl;
import com.sodi.pojo.Paper;

public class ShowAllAction implements ICommand{
	//1. ȡ�������еĲ�����
	//3. ���ؿ�����Ҫת�����һҳ�� 
	public String execute(HttpServletRequest request, HttpServletResponse response)
	{
		String nextPage=null;
		IPaperDao paperDao=new PaperDaoImpl();
		List<Paper> list=paperDao.getAllPaper(); //���� Dao���ҵ���߼� 
		request.setAttribute("paperList", list); //׼����һҳ��Ҫ��ʾ������
		nextPage="/WEB-INF/main.jsp";
		return nextPage;
	}
}
