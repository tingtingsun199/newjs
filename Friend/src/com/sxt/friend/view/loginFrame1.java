package com.sxt.friend.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sxt.friend.dao.AcountDao;
import com.sxt.friend.entity.Account;

public class loginFrame1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame1 frame = new loginFrame1();
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
	public loginFrame1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeadImage= new JLabel();
		lblHeadImage.setIcon(new ImageIcon("image/1.jpg"));
		lblHeadImage.setBounds(0, 0, 385, 119);
		contentPane.add(lblHeadImage);
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u8D26\u53F7\uFF1A");
		lblNewLabel.setBounds(42, 153, 74, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(62, 205, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		txtUserName = new JTextField();
		txtUserName.setText("sun");
		txtUserName.setBounds(126, 148, 172, 30);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPwd = new JPasswordField();
		txtPwd.setText("123");
		txtPwd.setEchoChar('��');
		txtPwd.setBounds(126, 197, 172, 30);
		contentPane.add(txtPwd);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(149, 237, 100, 35);
		contentPane.add(btnNewButton);
		//���ûس���Ĭ��ִ�а�ť
		this.getRootPane().setDefaultButton(btnNewButton);
	}
	public void actionPerformed(ActionEvent arg0) {
		//ȡ����������˺ź�����
		String username=txtUserName.getText();
		String pwd=txtPwd.getText();
		
		//����AccountDao��ѯ�û��Ƿ����
		AcountDao accountDao=new AcountDao();
		
		//����DAO���ݷ��ʲ���ȡ���Ƿ�������˺�
		Account account=accountDao.findAccount(username,pwd);
		
		//������
		if(account==null){
			JOptionPane.showMessageDialog(this, "�˺Ż��������");
		}else{
			//�ȴ�������
			new mainFrame();
			//�ٹص�¼����
			this.dispose();
		}
		//����
	}
}
