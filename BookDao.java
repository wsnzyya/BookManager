package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java1234.model.Book;
import com.java1234.util.StringUtil;

/**
 * 图书Dao类
 * @author 华敏
 *
 */
public class BookDao {
	/**
	 * 添加图书
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int addBook(Connection con,Book book) throws Exception{
		String sql="insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setInt(5, book.getBookTypeId());
		pstmt.setString(6, book.getBookDesc());
		return pstmt.executeUpdate();
	}
	/**
	 * 图书查询
	 * @param con
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public ResultSet list(Connection con,Book book) throws SQLException{
		StringBuffer sb=new StringBuffer("select * from t_book t,t_bookType tb where t.bookTypeId=tb.id");
		if(StringUtil.isNotEmpty(book.getBookName()))
		{
			sb.append(" and BookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor()))
		{
			sb.append(" and Author like '%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeId()!=null&&book.getBookTypeId()!=-1)
		{
			sb.append(" and BookTypeId like '%"+book.getBookTypeId()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 修改图书
	 * @param con
	 * @param book
	 * @return
	 * @throws SQLException 
	 */
	public int update(Connection con,Book book) throws SQLException{
		String sql="update t_book set bookName=?,author=?,sex=?,price=?,bookTypeId=?,bookDesc=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setInt(5, book.getBookTypeId());
		pstmt.setString(6, book.getBookDesc());
		pstmt.setInt(7, book.getId());
		return pstmt.executeUpdate();
	}
	/**
	 * 删除图书
	 * @param con
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public int delete(Connection con,int id) throws SQLException
	{
		String sql="delete from t_book where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, id);
		return pstmt.executeUpdate();
	}
}
