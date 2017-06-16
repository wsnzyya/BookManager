package com.java1234.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库工具类
 * @author 华敏
 *
 */
public class DbUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/db_book";
	private String jdbcName="com.mysql.jdbc.Driver";
	private String password="123456";
	private String userName="root";
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, userName, password);
		return con;	
	}
	/**
	 * 关闭数据库
	 * @param con
	 * @throws SQLException
	 */
	public void close(Connection con) throws SQLException{
		if(con!=null){
			con.close();
		}
	}
	/**
	 * 测试数据库连接
	 * @param args
	 */
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			Connection con=dbUtil.getCon();
			System.out.println("数据库连接成功！");
			dbUtil.close(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}
		
	}

}
