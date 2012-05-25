package com.sodi.business;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 给一组相同的行为定义了统一的外观
 * 
 * Command 模式
 * @author Sodi
 *
 */
public interface ICommand {
	public String execute(HttpServletRequest request, HttpServletResponse response);
}
