package com.sxt.supermarket.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.sxt.supermarket.Dao.EntrepotDao;
import com.sxt.supermarket.entity.Entrepot;

public class EntrepotFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField smtName;
	private JTextField smtNature;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntrepotFrame frame = new EntrepotFrame();
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
	public EntrepotFrame() {
		setTitle("\u4ED3\u5E93\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 733, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null,
				"\u4ED3\u5E93\u4FE1\u606F\u6DFB\u52A0", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(10, 25, 313, 302);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u4ED3\u5E93\u540D\u79F0\uFF1A");
		lblNewLabel.setBounds(10, 60, 72, 29);
		panel.add(lblNewLabel);

		smtName = new JTextField();
		smtName.setBounds(92, 60, 203, 29);
		panel.add(smtName);
		smtName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u4ED3\u5E93\u529F\u80FD\uFF1A");
		lblNewLabel_1.setBounds(10, 151, 72, 29);
		panel.add(lblNewLabel_1);

		smtNature = new JTextField();
		smtNature.setBounds(92, 151, 203, 29);
		panel.add(smtNature);
		smtNature.setColumns(10);
		// 添加
		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.setActionCommand("btnAdd");
		btnAdd.addActionListener(this);
		btnAdd.setBounds(77, 229, 164, 34);
		panel.add(btnAdd);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u4ED3\u5E93\u8BE6\u60C5",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(363, 25, 344, 405);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 22, 312, 314);
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		// 创建列名
		String[] columnName = { "ID", "仓库名称", "仓库功能" };
		// 数据模型
		dtm = new DefaultTableModel(null, columnName);
		table = new JTable(dtm);
		// 设置表格的高度
		table.setRowHeight(50);
		scrollPane.setViewportView(table);
		// 删除
		JButton btnDelete = new JButton("\u5220\u9664");
		btnDelete.setActionCommand("btnDelete");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(116, 346, 125, 39);
		panel_1.add(btnDelete);
		
		JButton btnClose = new JButton("\u8FD4\u56DE");
		btnClose.addActionListener(this);
		btnClose.setActionCommand("btnClose");
		btnClose.setBounds(118, 374, 93, 23);
		contentPane.add(btnClose);

		loadData();
		// 显示
		this.setVisible(true);
	}

	// 全局变量
	DefaultTableModel dtm;
	EntrepotDao entrepotDao = new EntrepotDao();
	private JTable table;

	// 加载数据
	public void loadData() {
		// 清空表格
		dtm.setRowCount(0);

		// 从数据访问层取得所有商品列表
		ArrayList<Entrepot> list = entrepotDao.findEntrepotList();
		// 迭代
		for (int i = 0; i < list.size(); i++) {
			// 每次取一个
			Entrepot n = list.get(i);
			// 组装成对象数组
			Object[] param = { n.getId(), n.getName(), n.getNature() };
			// 将数据添加到表格数据模型中
			dtm.addRow(param);

		}
	}

	public void actionPerformed(ActionEvent e) {
		// 删除信息
		if (e.getActionCommand().equals("btnDelete")) {
			// 取得选中的行
			int rowIndex = table.getSelectedRow();
			if (rowIndex == -1) {
				JOptionPane.showConfirmDialog(this, "请选中需要删除的行");
				return;
			}
			// 取得选中的ID
			Integer id = (Integer) table.getValueAt(rowIndex, 0);

			int result = JOptionPane.showConfirmDialog(this, "确认删除", "提示",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (result == 0) {
				// 到SupermarketDao数据库删除
				EntrepotDao dao = new EntrepotDao();
				dao.deleteEntrepot(id);
				// 刷新表格
				loadData();

			}
		} else if (e.getActionCommand().equals("btnAdd")) {
			// 添加信息
			// 取得输入框中的信息

			String name = smtName.getText();
			String regexText = "[\\u4E00-\\u9FA5\\uF900-\\uFA2D]{2,4}";
			// 通过正则表达式创建一个模板
			Pattern pattern = Pattern.compile(regexText);
			// 匹配这个电话是否符合这个模板的格式
			Matcher m = pattern.matcher(name);
			boolean ok = m.matches();
			if (!ok) {
				JOptionPane.showMessageDialog(this, "用户名不正确");
				// 将光标移动错误的输入框中
				smtName.requestFocus();
				return;
			}

			String nature = smtNature.getText();

			// 组装成对象
			Entrepot n = new Entrepot(name, nature);

			// 调用Dao【数据处理层】存储当前的商品信息
			EntrepotDao dao = new EntrepotDao();
			dao.savaEntrepot(n);
			// 刷新表格
			loadData();

		}else if(e.getActionCommand().equals("btnClose")){
			this.dispose();
		}

	}
}
