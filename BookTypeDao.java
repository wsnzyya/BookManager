package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java1234.model.BookType;
import com.java1234.util.StringUtil;

public class BookTypeDao {
	/**
	 * 添加图书类别
	 * @param con
	 * @param booktype
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,BookType booktype) throws Exception{
		String sql="insert into t_bookType values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, booktype.getBookTypeName());
		pstmt.setString(2, booktype.getBookTypeDesc());
		return pstmt.executeUpdate();
		
	}
	/**
	 * 查询图书类别
	 * @param con
	 * @param booktype
	 * @return
	 * @throws SQLException
	 */
	public ResultSet list(Connection con,BookType booktype) throws SQLException{
		StringBuffer sb=new StringBuffer("select * from t_bookType");
		if(StringUtil.isNotEmpty(booktype.getBookTypeName())){
			sb.append(" and BookTypeName like '%"+booktype.getBookTypeName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
	    return pstmt.executeQuery();
	}
	/**
	 * 更新图书类别
	 * @param con
	 * @param bookType
	 * @return
	 * @throws SQLException 
	 */
	public int update(Connection con,BookType bookType) throws SQLException{
		String sql="update t_bookType set BookTypeName=?,BookTypeDesc=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());
		return pstmt.executeUpdate();
	}
	/**
	 * 图书类别删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id) throws Exception{
		String sql="delete from t_bookType where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();	
	}

}
