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
		
		//��������
		String[] columnName={"ID","����","��˾�绰","��ͥ�绰","��ͥסַ"};
		//����ģ��
		dtm=new DefaultTableModel(null,columnName);
		
		table = new JTable(dtm);
		
		//���ñ��ĸ߶�
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
		//��ʾ
		this.setVisible(true);
		
	}
	//ȫ�ֱ���
	DefaultTableModel dtm;
	FriendDao friendDao=new FriendDao();
	private JTable table;
	//��������
	public void loadData(){
		//��ձ��
		dtm.setRowCount(0);
		
		//�����ݷ��ʲ�ȡ�����������б�
		ArrayList<Friend> list=friendDao.findFriendList();
		//����
		for(int i=0;i<list.size();i++){
			//ÿ��ȡһ��
			Friend f=list.get(i);
			//��װ�ɶ�������
			Object[] param={f.getId(),f.getName(),f.getOfficePhone(),f.getHomePhone(),
					f.getAddress()};
			//��������ӵ��������ģ����
			dtm.addRow(param);
			
			
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("btnRefresh")){
			loadData();	
		}else if(e.getActionCommand().equals("btnDelete")){
			//ȡ��ѡ�е���
			int rowIndex=table.getSelectedRow();
			if(rowIndex==-1){
				JOptionPane.showConfirmDialog(this, "��ѡ����Ҫɾ������");
				return;
			}
			//ȡ��ѡ�е�ID
			Integer id=(Integer)table.getValueAt(rowIndex, 0);
			
			int result=JOptionPane.showConfirmDialog(this,"ȷ��ɾ��","��ʾ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(result==0){
				//��FriendDao���ݿ�ɾ��
			FriendDao dao=new FriendDao();
			dao.deleteFriend(id);
			//ˢ�±��
			loadData();
			
			}
			
			
		}else if(e.getActionCommand().equals("btnAdd")){
			new AddFrame(this);
		}else if(e.getActionCommand().equals("btnDetail")){
			//ȡ��ѡ�е���
			int rowIndex=table.getSelectedRow();
			//ȡ��ѡ�е����е�����ID
			int id=(Integer)table.getValueAt(rowIndex, 0);
			//����ID��Ѱ��������ѵ���ϸ��Ϣ�ӡ����ݿ��в�ѯ��
			FriendDao dao=new FriendDao();
			//
			Friend f=dao.getFrienById(id);
			
			//����һ����ʾ��ϸ��Ϣ�Ľ���
			new FriendDetailFrame(f);
			//�����ݿ��в�ѯ��������Ϣ��ʾ�ڼ�����
		}
		
		
		
	}
}
