package com.sxt.supermarket.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.sxt.supermarket.Dao.AccountsDao;
import com.sxt.supermarket.entity.Accounts;

public class LoginFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField smtUserName;
	private JPasswordField smtPwd;
	private JCheckBox txtJz;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("\u8D85\u5E02\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("    \u6587\u534E\u8D85\u5E02");
		lblNewLabel.setFont(new Font("�����п�", Font.PLAIN, 71));
		lblNewLabel.setBounds(0, 0, 442, 174);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5458\u5DE5\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(59, 191, 75, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(59, 255, 75, 23);
		contentPane.add(lblNewLabel_2);

		btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(173, 344, 121, 29);
		contentPane.add(btnNewButton);

		smtUserName = new JTextField();
		smtUserName.setBounds(154, 184, 202, 36);
		contentPane.add(smtUserName);
		smtUserName.setColumns(10);

		smtPwd = new JPasswordField();
		smtPwd.setEchoChar('*');
		smtPwd.setBounds(154, 248, 202, 36);
		contentPane.add(smtPwd);

		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// ���ûس���Ĭ��ִ�а�ť
		this.getRootPane().setDefaultButton(btnNewButton);

		txtJz = new JCheckBox("\u8BB0\u4F4F\u5BC6\u7801");
		txtJz.setBounds(97, 303, 103, 23);
		contentPane.add(txtJz);
		// ���ڴ򿪺��Ƿ���ʾ�˺ŵ������
		try {
			// ȡ��������е�������˺Ų��浽�˺���
			Properties pro = new Properties();
			pro.load(new FileInputStream("account.properties"));
			String un = pro.getProperty("username");
			String pw = pro.getProperty("pwd");
			if (un != null && !un.equals("")) {
				smtUserName.setText(un);
				smtPwd.setText(pw);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent arg0) {
		// ȡ����������˺ź�����
		String username = smtUserName.getText();
		String pwd = smtPwd.getText();

		// ����AccountsDao��ѯ�û��Ƿ����
		AccountsDao accountsDao = new AccountsDao();

		// ����DAO���ݷ��ʲ���ȡ���Ƿ�������˺�
		Accounts accounts = accountsDao.findAccounts(username, pwd);

		// ������
		if (accounts == null) {
			JOptionPane.showMessageDialog(this, "�˺Ż��������");
		} else {
			// ===========================
			if (txtJz.isSelected()) {
				try {
					Properties pro = new Properties();
					pro.load(new FileInputStream("account.properties"));
					pro.setProperty("username", username);
					pro.setProperty("pwd", pwd);
					pro.store(new FileOutputStream("account.properties"), "");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			// ============================
			// �ȴ�������
			new Main2Frame();
			// �ٹص�¼����
			this.dispose();
		}
		// ����
	}
}
