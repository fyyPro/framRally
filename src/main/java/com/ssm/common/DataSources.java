package com.ssm.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSources {

	private static String Driver_Name = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/sushe";
	private static String username = "root";
	private static String password = "1234";
	
	private static Connection con;
	
	public static void main(String[] args) {
		
		try {
			Class.forName(Driver_Name);
			con = DriverManager.getConnection(url, username, password);
			
			String updatesql = "";
			//数据更新,插入，删除
			if(con.isClosed()){
				Statement st = con.createStatement();
				int count = st.executeUpdate(updatesql);
				System.out.println("SQL执行影响的行数："+count);
				if(st != null){
					st.close();
				}
			}
			//数据更新,插入，删除（批量执行）
			if(con.isClosed()){
				Statement st = con.createStatement();
				st.addBatch(updatesql);
				st.addBatch(updatesql);
				st.executeBatch();
				if(st != null){
					st.close();
				}
			}
			//数据查询
			if(con.isClosed()){
				Statement st = con.createStatement();
				String sql = "";
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()){
					
				}
				if(rs != null){
					rs.close();
				}
				if(st != null){
					st.close();
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
