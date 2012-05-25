package com.sodi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sodi.pojo.Login;
import com.sodi.pojo.Paper;

public class LoginDaoImpl implements ILoginDao{

	
	public Login getOneLogin(Login tmpLogin) {
		Login login=null;
		DbHelper dbHelper=new DbHelper();
		Connection conn=dbHelper.getConn();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			stmt=conn.createStatement();
			String sql="select loginId,loginName,email,password from login where loginName='"+tmpLogin.getLoginName()+"' and password='"+tmpLogin.getPassword()+"'";
			rs=stmt.executeQuery(sql);
			Paper paper=null;
			if(rs.next())
			{
				login=new Login();
				login.setLoginId(rs.getInt("loginId"));
				login.setLoginName(rs.getString("loginName"));
				login.setEmail(rs.getString("email"));
				login.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)
				{
					rs.close();
				}			
				if(stmt!=null)
				{
					stmt.close();
				}
				dbHelper.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return login;
	}

}
