package com.java1234.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.java1234.dao.BookDao;
import com.java1234.dao.BookTypeDao;
import com.java1234.model.Book;
import com.java1234.model.BookType;
import com.java1234.util.DbUtil;
import com.java1234.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeManageInterFrm extends JInternalFrame {
	private JTextField s_bookTypeNameTxt;
	private JTable bookTypeTable;
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao booktypedao=new BookTypeDao();
	private JTextField idTxt;
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	private BookDao bookDao=new BookDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManageInterFrm frame = new BookTypeManageInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookTypeManageInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		setBounds(100, 100, 564, 511);
		
		JScrollPane scrollpane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0");
		
		s_bookTypeNameTxt = new JTextField();
		s_bookTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookTypeSearchActionPerformed();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(82)
							.addComponent(lblNewLabel)
							.addGap(29)
							.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(button))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel, 0, 0, Short.MAX_VALUE)
								.addComponent(scrollpane, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(43, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(20)
					.addComponent(scrollpane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		bookTypeDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdateActionEvent(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/modify.png")));
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/delete.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeDeleteActionEvent(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(30)
							.addComponent(btnNewButton_1))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_3)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(bookTypeDescTxt))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addGap(18)
								.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addGap(27)
								.addComponent(lblNewLabel_2)
								.addGap(18)
								.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(40, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTypeTable = new JTable();
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeTableMousePressed(e);
			}
		});
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(122);
		bookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(138);
		scrollpane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new BookType());
		//设置文本域边框
		bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
	}
	/**
	 * 图书类别删除事件处理
	 * @param e
	 */
	private void bookTypeDeleteActionEvent(ActionEvent evt) {
		Connection con=null;
		String id=idTxt.getText();
		Book book=new Book();
		book.setBookTypeId(Integer.parseInt(id));
		if(StringUtil.isEmpty(id))
		{
			JOptionPane.showMessageDialog(null, "请选择要删除的记录！");
			return;
		}
		int num=JOptionPane.showConfirmDialog(null, "确定要删除这条记录吗？");
		if(num==0){
			try {
				con=dbUtil.getCon();
				ResultSet rs=bookDao.list(con, book);
				if(!rs.next())
				{
					int deleteNum=booktypedao.delete(con, id);
					if(deleteNum==1){
						JOptionPane.showMessageDialog(null, "删除成功！");
						fillTable(new BookType());
						resetValue();
					}else{
						JOptionPane.showMessageDialog(null, "删除失败！");
					}
				}else{
					JOptionPane.showMessageDialog(null, "您要删除的图书类别下还有图书，不能删除该类别！");
					return;
				}	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 图书类别修改事件处理
	 * @param e
	 */
	private void bookTypeUpdateActionEvent(ActionEvent evt) {
		// TODO Auto-generated method stub
		String id=idTxt.getText();
		String bookTypeName=bookTypeNameTxt.getText();
		String bookTypeDesc=bookTypeDescTxt.getText();
		BookType bookType=new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
		if(StringUtil.isEmpty(id))
		{
			JOptionPane.showMessageDialog(null, "请选择要修改的记录！");
			return;
		}
		if(StringUtil.isEmpty(bookTypeName))
		{
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空！");
			return;
		}
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNum=booktypedao.update(con, bookType);
			if(modifyNum==1){
				JOptionPane.showMessageDialog(null, "修改成功！");
				resetValue();
				fillTable(new BookType());
			}else{
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "修改失败！");
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 表格行点击事件处理
	 * @param e
	 */
	private void bookTypeTableMousePressed(MouseEvent evt) {
		int row=bookTypeTable.getSelectedRow();
		idTxt.setText((String) bookTypeTable.getValueAt(row, 0));
		bookTypeNameTxt.setText((String) bookTypeTable.getValueAt(row, 1));
		bookTypeDescTxt.setText((String) bookTypeTable.getValueAt(row, 2));
	}
	/**
	 * 重置表单
	 */
	private void resetValue(){
		idTxt.setText("");
		bookTypeNameTxt.setText("");
		bookTypeDescTxt.setText("");
	}

	/**
	 * 图书类别查询处理
	 */
	private void bookTypeSearchActionPerformed(){
		String s_bookTypeName=this.s_bookTypeNameTxt.getText();
		BookType bookType=new BookType();
		bookType.setBookTypeName(s_bookTypeName);
		fillTable(bookType);
	}
	/**
	 * 初始化图书类别表格
	 * @param booktype
	 */
	private void fillTable(BookType booktype){
		DefaultTableModel dtm=(DefaultTableModel) bookTypeTable.getModel();
		dtm.setRowCount(0);//设置成零行
		Connection con=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=booktypedao.list(con, booktype);
			while(rs.next())
			{
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("BookTypeName"));
				v.add(rs.getString("BookTypeDesc"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
