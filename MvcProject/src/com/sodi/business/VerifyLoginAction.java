package com.sodi.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sodi.dao.ILoginDao;
import com.sodi.dao.IPaperDao;
import com.sodi.dao.LoginDaoImpl;
import com.sodi.dao.PaperDaoImpl;
import com.sodi.pojo.Login;
import com.sodi.pojo.Paper;

public class VerifyLoginAction  implements ICommand{
	//1. ȡ�������еĲ�����
	//3. ���ؿ�����Ҫת�����һҳ�� 
	public String execute(HttpServletRequest request, HttpServletResponse response)
	{
		String nextPage=null;
		String loginName=request.getParameter("login");
		String password=request.getParameter("password");
		Login tmpLogin=new Login();	
		tmpLogin.setLoginName(loginName);
		tmpLogin.setPassword(password);
		ILoginDao loginDao=new LoginDaoImpl();
		Login login=loginDao.getOneLogin(tmpLogin);
		if(login==null)
		{
			nextPage="/WEB-INF/login.jsp";
		}
		else //��½�ɹ�
		{
			HttpSession session=request.getSession();//�ѵ�½��Ϣ����session
			session.setAttribute("login", login);	
			String url=request.getParameter("url");	
			if(!"".equals(url))
			{
				request.setAttribute("url", url);	
				response.addHeader("refresh","5;url="+url);
			}
			nextPage="/next?cmd=showAll";
		}
		return nextPage;
	}
}
