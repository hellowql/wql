package com.sodi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.sodi.pojo.Paper;

public class PaperDaoImpl implements IPaperDao{

	public List<Paper> getAllPaper() {
		List<Paper> list=new ArrayList<Paper>();
		DbHelper dbHelper=new DbHelper();
		Connection conn=dbHelper.getConn();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			stmt=conn.createStatement();
			String sql="select paperId,papertitle,description from paper";
			rs=stmt.executeQuery(sql);
			Paper paper=null;
			while(rs.next())
			{
				paper=new Paper();
				paper.setPaperId(rs.getInt("paperId"));
				paper.setPaperTitle(rs.getString("papertitle"));
				paper.setDescription(rs.getString("description"));
				list.add(paper);
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
		
		return list;
	}

}
