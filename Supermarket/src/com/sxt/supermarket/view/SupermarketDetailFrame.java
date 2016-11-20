package com.sxt.supermarket.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sxt.supermarket.entity.Supermarket;

public class SupermarketDetailFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField smtName;
	private JTextField smtNumber;
	private JTextField smtRise;
	private JTextField smtStandard;
	private JTextField smtEntrepot;

	/**
	 * Create the frame.
	 */
	public SupermarketDetailFrame(Supermarket s) {
		setTitle("\u5546\u54C1\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 592, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null,
				"\u5546\u54C1\u8BE6\u7EC6\u4FE1\u606F", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(33, 28, 498, 299);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel.setBounds(39, 29, 71, 25);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setBounds(39, 81, 71, 25);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u9500\u552E\u4EF7\u683C\uFF1A");
		lblNewLabel_2.setBounds(39, 136, 71, 25);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u5546\u54C1\u89C4\u683C\uFF1A");
		lblNewLabel_3.setBounds(39, 191, 71, 25);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u6240\u5C5E\u4ED3\u5E93\uFF1A");
		lblNewLabel_4.setBounds(39, 246, 71, 25);
		panel.add(lblNewLabel_4);

		smtName = new JTextField();
		smtName.setEditable(false);
		// 将值放入信息框
		smtName.setText(s.getName());
		smtName.setBounds(135, 25, 263, 33);
		panel.add(smtName);
		smtName.setColumns(10);

		smtNumber = new JTextField();
		smtNumber.setEditable(false);

		smtNumber.setText(s.getNumber());
		smtNumber.setBounds(135, 77, 263, 33);
		panel.add(smtNumber);
		smtNumber.setColumns(10);

		smtRise = new JTextField();
		smtRise.setEditable(false);
		smtRise.setText(s.getRise());
		smtRise.setBounds(135, 132, 263, 33);
		panel.add(smtRise);
		smtRise.setColumns(10);

		smtStandard = new JTextField();
		smtStandard.setEditable(false);
		smtStandard.setText(s.getStandard());
		smtStandard.setBounds(135, 187, 263, 33);
		panel.add(smtStandard);
		smtStandard.setColumns(10);

		smtEntrepot = new JTextField();
		smtEntrepot.setEditable(false);
		smtEntrepot.setText(s.getEntrepot());
		smtEntrepot.setBounds(135, 242, 263, 33);
		panel.add(smtEntrepot);
		smtEntrepot.setColumns(10);

		JButton btnNewButton = new JButton("\u5173\u95ED");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(169, 358, 212, 45);
		contentPane.add(btnNewButton);

		// 窗口初始化完毕以后显示
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		this.dispose();

	}
}
