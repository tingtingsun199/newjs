package com.sxt.friend.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;

import com.sxt.friend.entity.Friend;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FriendDetailFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtOfficePhone;
	private JTextField txtHomePhone;
	private JTextField txtAddress;

	

	
	public FriendDetailFrame(Friend f) {
		setTitle("\u4E2A\u4EBA\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 365, 457);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4E2A\u4EBA\u4FE1\u606F\u901A\u8BAF\u5F55", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(21, 26, 306, 329);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 50, 69, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u529E\u516C\u5BA4\u7535\u8BDD");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 121, 69, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BB6\u5EAD\u7535\u8BDD");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 192, 69, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 264, 69, 15);
		panel.add(lblNewLabel_3);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		//将值放到输入框显示
		txtName.setText(f.getName());
		txtName.setBounds(112, 45, 97, 26);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtOfficePhone = new JTextField();
		txtOfficePhone.setEditable(false);
		txtOfficePhone.setText(f.getOfficePhone());
		txtOfficePhone.setBounds(112, 116, 97, 26);
		panel.add(txtOfficePhone);
		txtOfficePhone.setColumns(10);
		
		txtHomePhone = new JTextField();
		txtHomePhone.setEditable(false);
		txtHomePhone.setText(f.getHomePhone());
		txtHomePhone.setBounds(112, 187, 97, 26);
		panel.add(txtHomePhone);
		txtHomePhone.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setText(f.getAddress());
		txtAddress.setBounds(112, 258, 97, 26);
		panel.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBorder(new TitledBorder(null, "\u7167\u7247", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_4.setBounds(219, 42, 77, 126);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("\u5173\u95ED");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(94, 374, 171, 23);
		
		contentPane.add(btnNewButton);
		//窗口初始化完毕以后显示
		this.setVisible(true);
	
	
	
	}
	public void actionPerformed(ActionEvent arg0) {
	this.dispose();
	
	}
}
