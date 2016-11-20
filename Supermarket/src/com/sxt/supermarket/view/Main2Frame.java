package com.sxt.supermarket.view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main2Frame extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main2Frame frame = new Main2Frame();
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
	public Main2Frame() {
		setTitle("\u6587\u534E\u8D85\u5E02");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 924, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCargo = new JButton("\u5546\u54C1\u57FA\u672C\u4FE1\u606F");
		btnCargo.setBounds(85, 109, 197, 62);
		
		btnCargo.setActionCommand("btnCargo");
		btnCargo.addActionListener(this);
		contentPane.add(btnCargo);
		
		JButton btnDate = new JButton("\u5546\u54C1\u4FDD\u5B58\u65E5\u671F");
		btnDate.setBounds(85, 512, 197, 62);
	
		btnDate.setActionCommand("btnDate");
		btnDate.addActionListener(this);
		contentPane.add(btnDate);
		
		JButton btnEntrepot = new JButton("\u4ED3\u5E93\u4FE1\u606F");
		btnEntrepot.setBounds(1080, 109, 197, 62);
		
		btnEntrepot.addActionListener(this);
		btnEntrepot.setActionCommand("btnEntrepot");
		contentPane.add(btnEntrepot);

		JButton btnRefer = new JButton("\u67E5\u8BE2\u5546\u54C1");
		btnRefer.setBounds(1109, 512, 197, 62);
		
		btnRefer.addActionListener(this);
		
		btnRefer.setActionCommand("btnRefer");
		contentPane.add(btnRefer);

		JButton btnClose = new JButton("\u9000\u51FA");
		btnClose.setBounds(1163, 656, 96, 46);
		
		btnClose.setActionCommand("btnClose");
		btnClose.addActionListener(this);
		contentPane.add(btnClose);
		
				JLabel lblHeadImage = new JLabel();
				lblHeadImage.setIcon(new ImageIcon("image/4.jpg"));
				lblHeadImage.setBounds(0, 0, 1350, 759);
				contentPane.add(lblHeadImage);

		this.setVisible(true);

		// 屏幕放大
		double width = Toolkit.getDefaultToolkit().getScreenSize().width;// 得到当前分辨率的高
		double height = Toolkit.getDefaultToolkit().getScreenSize().height;// 得到当前分辨率的宽
		this.setSize((int) width, (int) height);// 设置大小
		this.setLocation(0, 0);// 设置窗体居中
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btnCargo")) {
			MainFrame frame = new MainFrame();
			new MainFrame();
		} else if (e.getActionCommand().equals("btnEntrepot")) {
			EntrepotFrame frame = new EntrepotFrame();
			new EntrepotFrame();
		} else if (e.getActionCommand().equals("btnRefer")) {
			ReferFrame frame = new ReferFrame();
			new ReferFrame();
		} else if (e.getActionCommand().equals("btnDate")) {
			DateFrame frame = new DateFrame();
			new DateFrame();

		} else if (e.getActionCommand().equals("btnClose")) {
			this.dispose();
		}
	}
}
