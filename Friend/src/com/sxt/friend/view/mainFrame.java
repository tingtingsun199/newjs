package com.sxt.friend.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sxt.friend.dao.FriendDao;
import com.sxt.friend.entity.Friend;

public class mainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public mainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 472);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u6587\u4EF6(F)");
		mnNewMenu.setMnemonic('F');
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6253\u5F00");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u65B0\u5EFA");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5173\u95ED");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5168\u90E8\u5173\u95ED");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 437, 271);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		
		scrollPane.setViewportView(table);
		
		//创建列名
		String[] columnName={"ID","姓名","公司电话","家庭电话","家庭住址"};
		//数据模型
		dtm=new DefaultTableModel(null,columnName);
		
		table = new JTable(dtm);
		
		//设置表格的高度
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u5237\u65B0");
		btnNewButton.setActionCommand("btnRefresh");
		btnNewButton.setBounds(354, 33, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("\u5220\u9664");
		btnDelete.setActionCommand("btnDelete");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(251, 33, 93, 23);
		contentPane.add(btnDelete);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.addActionListener(this);
		btnAdd.setActionCommand("btnAdd");
		btnAdd.setBounds(148, 33, 93, 23);
		contentPane.add(btnAdd);
		
		JButton btnDetil = new JButton("\u67E5\u770B\u8BE6\u7EC6");
		btnDetil.setActionCommand("btnDetail");
		btnDetil.addActionListener(this);
		btnDetil.setBounds(28, 33, 93, 23);
		contentPane.add(btnDetil);
		
		loadData();
		//显示
		this.setVisible(true);
		
	}
	//全局变量
	DefaultTableModel dtm;
	FriendDao friendDao=new FriendDao();
	private JTable table;
	//加载数据
	public void loadData(){
		//清空表格
		dtm.setRowCount(0);
		
		//从数据访问层取得所有朋友列表
		ArrayList<Friend> list=friendDao.findFriendList();
		//迭代
		for(int i=0;i<list.size();i++){
			//每次取一个
			Friend f=list.get(i);
			//组装成对象数组
			Object[] param={f.getId(),f.getName(),f.getOfficePhone(),f.getHomePhone(),
					f.getAddress()};
			//将数据添加到表格数据模型中
			dtm.addRow(param);
			
			
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("btnRefresh")){
			loadData();	
		}else if(e.getActionCommand().equals("btnDelete")){
			//取得选中的行
			int rowIndex=table.getSelectedRow();
			if(rowIndex==-1){
				JOptionPane.showConfirmDialog(this, "请选中需要删除的行");
				return;
			}
			//取得选中的ID
			Integer id=(Integer)table.getValueAt(rowIndex, 0);
			
			int result=JOptionPane.showConfirmDialog(this,"确认删除","提示",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(result==0){
				//到FriendDao数据库删除
			FriendDao dao=new FriendDao();
			dao.deleteFriend(id);
			//刷新表格
			loadData();
			
			}
			
			
		}else if(e.getActionCommand().equals("btnAdd")){
			new AddFrame(this);
		}else if(e.getActionCommand().equals("btnDetail")){
			//取得选中的行
			int rowIndex=table.getSelectedRow();
			//取得选中的行中的朋友ID
			int id=(Integer)table.getValueAt(rowIndex, 0);
			//根据ID查寻出这个朋友的详细信息从【数据库中查询】
			FriendDao dao=new FriendDao();
			//
			Friend f=dao.getFrienById(id);
			
			//弹出一个显示详细信息的界面
			new FriendDetailFrame(f);
			//将数据库中查询出来的信息显示在见面上
		}
		
		
		
	}
}
