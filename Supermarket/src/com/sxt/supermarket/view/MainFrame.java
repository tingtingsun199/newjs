package com.sxt.supermarket.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.sxt.supermarket.Dao.SupermarketDao;
import com.sxt.supermarket.entity.Supermarket;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setFont(new Font("华文行楷", Font.PLAIN, 16));
		setTitle("\u6587\u534E\u8D85\u5E02");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null,
				"\u8D85\u5E02\u5546\u54C1\u4FE1\u606F", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		// 设置边框布局
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		// scrollPane.setBounds(136, 28, 503, 372);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();

		scrollPane.setViewportView(table);

		// 创建列名
		String[] columnName = { "ID", "商品名称", "商品编号", "商品价格（元）", "商品规格", "所属仓库" };
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
		// panel.setPreferredSize(new Dimension(0,70));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// 初始大小
		JButton btnRefresh = new JButton("\u5237\u65B0");
		btnRefresh.addActionListener(this);
		btnRefresh.setPreferredSize(new Dimension(100, 50));
		btnRefresh.setActionCommand("btnRefresh");
		panel.add(btnRefresh);
        
        
		JButton btnDelete = new JButton("\u5220\u9664");
		btnDelete.setPreferredSize(new Dimension(100, 50));
		btnDelete.setActionCommand("btnDelete");
		
		btnDelete.addActionListener(this);
		panel.add(btnDelete);
		

		JButton btnDetail = new JButton("\u8BE6\u7EC6\u4FE1\u606F");
		btnDetail.setPreferredSize(new Dimension(100, 50));
		btnDetail.setActionCommand("btnDetail");
		
		btnDetail.addActionListener(this);
		panel.add(btnDetail);

		JButton btnNature = new JButton("\u4ED3\u5E93\u4FE1\u606F");
		btnNature.setPreferredSize(new Dimension(100, 50));
		btnNature.setActionCommand("btnNature");
		btnNature.addActionListener(this);
		
		panel.add(btnNature);

		JButton btnRefer = new JButton("\u67E5\u8BE2");
		btnRefer.setPreferredSize(new Dimension(100, 50));
		btnRefer.setActionCommand("btnRefer");
		btnRefer.addActionListener(this);
		
		panel.add(btnRefer);

		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.setPreferredSize(new Dimension(100, 50));
		btnAdd.setActionCommand("btnAdd");
		btnAdd.addActionListener(this);
		panel.add(btnAdd);

		JButton btnClose = new JButton("\u8FD4\u56DE");
		btnClose.setPreferredSize(new Dimension(100, 50));
		btnClose.addActionListener(this);
		btnClose.setActionCommand("btnClose");
		panel.add(btnClose);
		contentPane.add(panel, BorderLayout.NORTH);

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
	SupermarketDao supermarketDao = new SupermarketDao();
	private JTable table;

	// 加载数据
	public void loadData() {
		// 清空表格
		dtm.setRowCount(0);

		// 从数据访问层取得所有商品列表
		ArrayList<Supermarket> list = supermarketDao.findSupermarketList();
		// 迭代
		for (int i = 0; i < list.size(); i++) {
			// 每次取一个
			Supermarket s = list.get(i);
			// 组装成对象数组
			Object[] param = { s.getId(), s.getName(), s.getNumber(),
					s.getRise(), s.getStandard(), s.getEntrepot() };
			// 将数据添加到表格数据模型中
			dtm.addRow(param);

		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btnRefresh")) {
			loadData();
		} else if (e.getActionCommand().equals("btnDelete")) {
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
				SupermarketDao dao = new SupermarketDao();
				dao.deleteSupermarket(id);
				// 刷新表格
				loadData();

			}

		} else if (e.getActionCommand().equals("btnAdd")) {
			new AddFrame(this);
		} else if (e.getActionCommand().equals("btnDetail")) {
			// 取得选中的行
			int rowIndex = table.getSelectedRow();
			// 取得选中的行中的商品ID
			int id = (Integer) table.getValueAt(rowIndex, 0);
			// 根据ID查寻出这个商品的详细信息从【数据库中查询】
			SupermarketDao dao = new SupermarketDao();
			//
			Supermarket s = dao.getSupermarketById(id);

			// 弹出一个显示详细信息的界面
			new SupermarketDetailFrame(s);
			// 将数据库中查询出来的信息显示在见面上
			// 仓库
		} else if (e.getActionCommand().equals("btnNature")) {
			EntrepotFrame frame = new EntrepotFrame();
			new EntrepotFrame();
			// 查询
		} else if (e.getActionCommand().equals("btnRefer")) {
			ReferFrame frame = new ReferFrame();
			new ReferFrame();
		} else if (e.getActionCommand().equals("btnClose")) {
			this.dispose();
		}
	}
}
