package com.sodi.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��һ����ͬ����Ϊ������ͳһ�����
 * 
 * Command ģʽ
 * @author Sodi
 *
 */
public interface ICommand {
	public String execute(HttpServletRequest request, HttpServletResponse response);
}
