package com.sxt.friend.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sxt.friend.dao.FriendDao;
import com.sxt.friend.entity.Friend;

public class AddFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtOfficePhone;
	private JTextField txtHomePhone;
	private JTextField txtAddress;
	private JTextField textField_4;
	
	mainFrame mf;
	

	/**
	 * Create the frame.
	 */
	public AddFrame(mainFrame mf) {
		//接受外面传入的引入变量
		this.mf=mf;
		
		
		setTitle("\u6DFB\u52A0\u670B\u53CB");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 457, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u6DFB\u52A0\u670B\u53CB\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 21, 411, 371);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(26, 44, 66, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u529E\u516C\u7535\u8BDD\uFF1A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(26, 111, 66, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BB6\u5EAD\u7535\u8BDD\uFF1A");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(26, 177, 66, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(26, 243, 66, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u7167\u7247\uFF1A");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(26, 309, 66, 15);
		panel.add(lblNewLabel_4);
		
		txtName = new JTextField();
		txtName.setBounds(122, 37, 127, 28);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtOfficePhone = new JTextField();
		txtOfficePhone.setBounds(122, 104, 127, 28);
		panel.add(txtOfficePhone);
		txtOfficePhone.setColumns(10);
		
		txtHomePhone = new JTextField();
		txtHomePhone.setBounds(122, 170, 127, 28);
		panel.add(txtHomePhone);
		txtHomePhone.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(122, 236, 257, 28);
		panel.add(txtAddress);
		txtAddress.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(122, 302, 127, 28);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBorder(new TitledBorder(null, "\u7167\u7247", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_5.setBounds(273, 27, 114, 165);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("\u9009\u62E9\u56FE\u7247");
		btnNewButton_1.setBounds(294, 305, 93, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(86, 420, 278, 47);
		contentPane.add(btnNewButton);
		
		this.setVisible(true);
	}

	
	public void actionPerformed(ActionEvent argo){
		//取得输入框中的信息
		String name=txtName.getText();
		String regexText="[\\u4E00-\\u9FA5\\uF900-\\uFA2D]{2,4}";
		//通过正则表达式创建一个模板
		Pattern pattern=Pattern.compile(regexText);
		//匹配这个电话是否符合这个模板的格式
		Matcher m=pattern.matcher(name);
		boolean ok=m.matches();
		if(!ok){
			JOptionPane.showMessageDialog(this, "用户名不正确");
			//将光标移动错误的输入框中
			txtName.requestFocus();
			
			
			return;
			
		}
		
		
		String officePhone=txtOfficePhone.getText();
		String homePhone=txtHomePhone.getText();
		String address=txtAddress.getText();
		
		//组装成对象
		Friend f=new Friend(name,officePhone,homePhone,address);
		
		//调用Dao【数据处理层】存储当前的朋友信息
		FriendDao dao=new FriendDao();
		dao.savaFriend(f);
		//刷新表格
		mf.loadData();
		this.dispose();
	}
	
}
