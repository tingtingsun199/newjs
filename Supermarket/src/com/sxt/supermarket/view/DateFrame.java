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
		// ��������
		String[] columnName = { "ID", "��Ʒ����", "��Ʒ�������ڣ��죩", "�����ֿ�" };
		// ����ģ��
		dtm = new DefaultTableModel(null, columnName);

		table = new JTable(dtm);
		// ���ñ��ĸ߶�
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

		// ��Ļ�Ŵ�
		double width = Toolkit.getDefaultToolkit().getScreenSize().width;// �õ���ǰ�ֱ��ʵĸ�
		double height = Toolkit.getDefaultToolkit().getScreenSize().height;// �õ���ǰ�ֱ��ʵĿ�
		this.setSize((int) width, (int) height);// ���ô�С
		this.setLocation(0, 0);// ���ô������

		// ��ʾ
		this.setVisible(true);

	}

	// ȫ�ֱ���
	DefaultTableModel dtm;
	DateDao dateDao = new DateDao();
	private JTable table;

	// ��������
	public void loadData() {
		// ��ձ��
		dtm.setRowCount(0);

		// �����ݷ��ʲ�ȡ��������Ʒ�б�
		ArrayList<Date> list = dateDao.findDateList();
		// ����
		for (int i = 0; i < list.size(); i++) {
			// ÿ��ȡһ��
			Date d = list.get(i);
			// ��װ�ɶ�������
			Object[] param = { d.getId(), d.getName(), d.getDate(),
					d.getEntrepot() };
			// ��������ӵ��������ģ����
			dtm.addRow(param);

		}

	}

	public void actionPerformed(ActionEvent arg0) {
		this.dispose();
	}
}
