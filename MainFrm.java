package com.java1234.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.SynchronousQueue;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table=null; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		menuBar.add(menu);
		
		JMenu mnNewMenu = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		menu.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			/**
			 * 添加图书处理
			 */
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm booktypeaddinterfrm=new BookTypeAddInterFrm();
				table.add(booktypeaddinterfrm);
				booktypeaddinterfrm.setVisible(true);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookTypeManageInterFrm booktypemanageinterfrm=new BookTypeManageInterFrm();
				booktypemanageinterfrm.setVisible(true);
				table.add(booktypemanageinterfrm);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		mnNewMenu.add(menuItem_1);
		
		JMenu menu_2 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		menu.add(menu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm=new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
				table.add(bookAddInterFrm);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu_2.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookManageInterFrm bookManageInterFrm=new BookManageInterFrm();
				bookManageInterFrm.setVisible(true);
				table.add(bookManageInterFrm);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menu_2.add(menuItem_3);
		
		JMenuItem menuItem = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			/**
			 * 安全退出事件处理
			 */
			public void actionPerformed(ActionEvent arg0) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出系统?");
				if(result==0){
					dispose();
				}
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menuBar.add(menu_1);
		
		JMenuItem mntmJava = new JMenuItem("java1234");
		mntmJava.addActionListener(new ActionListener() {
			/**
			 * java1234事件处理
			 */
			public void actionPerformed(ActionEvent e) {
				Java1234InterFrm java1234interfrm=new Java1234InterFrm();
				table.add(java1234interfrm);
				java1234interfrm.setVisible(true);
			}
		});
		menu_1.add(mntmJava);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		table.setBackground(Color.LIGHT_GRAY);
		contentPane.add(table, BorderLayout.CENTER);
		
		//设置窗口最大化
		this.setExtendedState(MAXIMIZED_BOTH);
	}

}
