package com.sxt.supermarket.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.sxt.supermarket.Dao.DateDao;
import com.sxt.supermarket.entity.Date;

public class DateFrame extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateFrame frame = new DateFrame();
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
	public DateFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 886, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(144, 37, 673, 338);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		// 创建列名
		String[] columnName = { "ID", "商品名称", "商品保存日期（天）", "所属仓库" };
		// 数据模型
		dtm = new DefaultTableModel(null, columnName);

		table = new JTable(dtm);
		// 设置表格的高度
		table.setRowHeight(40);

		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < columnName.length; i++) {
			table.getColumn(columnName[i]).setCellRenderer(render);
		}

		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		contentPane.add(panel, BorderLayout.NORTH);

		JButton btnDelete = new JButton("\u5220\u9664\u65E5\u671F");
		panel.add(btnDelete);
		btnDelete.setPreferredSize(new Dimension(100, 50));

		btnDelete.addActionListener(this);
		btnDelete.setActionCommand("btnDelete");

		JButton btnAmend = new JButton("\u4FEE\u6539\u65E5\u671F");
		panel.add(btnAmend);
		btnAmend.setPreferredSize(new Dimension(100, 50));
		btnAmend.addActionListener(this);
		btnAmend.setActionCommand("btnAmend");
		
				JButton btnClose = new JButton("\u8FD4\u56DE");
				panel.add(btnClose);
				btnClose.setPreferredSize(new Dimension(100, 50));
				btnClose.addActionListener(this);
				btnClose.setActionCommand("btnClose");

		loadData();

		// 屏幕放大
		double width = Toolkit.getDefaultToolkit().getScreenSize().width;// 得到当前分辨率的高
		double height = Toolkit.getDefaultToolkit().getScreenSize().height;// 得到当前分辨率的宽
		this.setSize((int) width, (int) height);// 设置大小
		this.setLocation(0, 0);// 设置窗体居中

		// 显示
		this.setVisible(true);

	}

	// 全局变量
	DefaultTableModel dtm;
	DateDao dateDao = new DateDao();
	private JTable table;

	// 加载数据
	public void loadData() {
		// 清空表格
		dtm.setRowCount(0);

		// 从数据访问层取得所有商品列表
		ArrayList<Date> list = dateDao.findDateList();
		// 迭代
		for (int i = 0; i < list.size(); i++) {
			// 每次取一个
			Date d = list.get(i);
			// 组装成对象数组
			Object[] param = { d.getId(), d.getName(), d.getDate(),
					d.getEntrepot() };
			// 将数据添加到表格数据模型中
			dtm.addRow(param);

		}

	}

	public void actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
