package com.java1234.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ݿ⹤����
 * @author ����
 *
 */
public class DbUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/db_book";
	private String jdbcName="com.mysql.jdbc.Driver";
	private String password="123456";
	private String userName="root";
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, userName, password);
		return con;	
	}
	/**
	 * �ر����ݿ�
	 * @param con
	 * @throws SQLException
	 */
	public void close(Connection con) throws SQLException{
		if(con!=null){
			con.close();
		}
	}
	/**
	 * �������ݿ�����
	 * @param args
	 */
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			Connection con=dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ���");
			dbUtil.close(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}
		
	}

}
