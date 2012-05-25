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
		String cmd=request.getParameter("cmd");//ȡ�������в���cmd��ֵ
		System.out.println("cmd="+cmd);
		Properties props=new Properties();
		//ͨ�����������ȡ�����ļ������ݷ���������
		InputStream in=this.getClass().getClassLoader().getResourceAsStream("config.properties");
		//�����������ؽ�Properties����
		props.load(in);
		ICommand command=null;
		String className=props.getProperty(cmd); //����cmd��ֵ��ö�Ӧ��Business��ȫ�޶���
		try {
			Class c=Class.forName(className); //���Business��Class����
			command=(ICommand)c.newInstance(); //ͨ��Class��������ʵ������Ϊ���е�Business��ʵ����ICommand�ӿڣ����Բ�����ʵ��������ʲô����ǿתΪICommand
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
		//���ݲ�ͬ��cmd���ò�ͬ��Business
		/*if("showAll".equals(cmd))
		{
			ShowAllAction showAllAction=new ShowAllAction();
			next=showAllAction.execute(request, response); //ͨ��Business���ҵ���߼�������Ҫ���ص���һҳ��ĵ�ַ
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
		next=command.execute(request, response); //���ýӿ��ж����execute���������ҵ���߼� �����������˶�̬��̬ 
		System.out.println("next="+next);
		//3. ����ҵ���߼�Bean�ķ���ֵ��ת����һҳ��
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
