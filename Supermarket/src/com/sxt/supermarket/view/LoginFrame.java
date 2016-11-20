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
		lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 71));
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

		// 设置回车的默认执行按钮
		this.getRootPane().setDefaultButton(btnNewButton);

		txtJz = new JCheckBox("\u8BB0\u4F4F\u5BC6\u7801");
		txtJz.setBounds(97, 303, 103, 23);
		contentPane.add(txtJz);
		// 窗口打开后是否显示账号到输入框
		try {
			// 取得输入框中的密码和账号并存到账号中
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
		// 取得你输入的账号和密码
		String username = smtUserName.getText();
		String pwd = smtPwd.getText();

		// 调用AccountsDao查询用户是否存在
		AccountsDao accountsDao = new AccountsDao();

		// 调用DAO数据访问层来取得是否有这个账号
		Accounts accounts = accountsDao.findAccounts(username, pwd);

		// 不存在
		if (accounts == null) {
			JOptionPane.showMessageDialog(this, "账号或密码错误");
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
			// 先打开主窗口
			new Main2Frame();
			// 再关登录窗口
			this.dispose();
		}
		// 存在
	}
}
