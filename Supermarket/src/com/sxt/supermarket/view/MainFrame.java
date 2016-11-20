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
		setFont(new Font("�����п�", Font.PLAIN, 16));
		setTitle("\u6587\u534E\u8D85\u5E02");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null,
				"\u8D85\u5E02\u5546\u54C1\u4FE1\u606F", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		// ���ñ߿򲼾�
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		// scrollPane.setBounds(136, 28, 503, 372);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();

		scrollPane.setViewportView(table);

		// ��������
		String[] columnName = { "ID", "��Ʒ����", "��Ʒ���", "��Ʒ�۸�Ԫ��", "��Ʒ���", "�����ֿ�" };
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
		// panel.setPreferredSize(new Dimension(0,70));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// ��ʼ��С
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
	SupermarketDao supermarketDao = new SupermarketDao();
	private JTable table;

	// ��������
	public void loadData() {
		// ��ձ��
		dtm.setRowCount(0);

		// �����ݷ��ʲ�ȡ��������Ʒ�б�
		ArrayList<Supermarket> list = supermarketDao.findSupermarketList();
		// ����
		for (int i = 0; i < list.size(); i++) {
			// ÿ��ȡһ��
			Supermarket s = list.get(i);
			// ��װ�ɶ�������
			Object[] param = { s.getId(), s.getName(), s.getNumber(),
					s.getRise(), s.getStandard(), s.getEntrepot() };
			// ��������ӵ��������ģ����
			dtm.addRow(param);

		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("btnRefresh")) {
			loadData();
		} else if (e.getActionCommand().equals("btnDelete")) {
			// ȡ��ѡ�е���
			int rowIndex = table.getSelectedRow();
			if (rowIndex == -1) {
				JOptionPane.showConfirmDialog(this, "��ѡ����Ҫɾ������");
				return;
			}
			// ȡ��ѡ�е�ID
			Integer id = (Integer) table.getValueAt(rowIndex, 0);

			int result = JOptionPane.showConfirmDialog(this, "ȷ��ɾ��", "��ʾ",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (result == 0) {
				// ��SupermarketDao���ݿ�ɾ��
				SupermarketDao dao = new SupermarketDao();
				dao.deleteSupermarket(id);
				// ˢ�±��
				loadData();

			}

		} else if (e.getActionCommand().equals("btnAdd")) {
			new AddFrame(this);
		} else if (e.getActionCommand().equals("btnDetail")) {
			// ȡ��ѡ�е���
			int rowIndex = table.getSelectedRow();
			// ȡ��ѡ�е����е���ƷID
			int id = (Integer) table.getValueAt(rowIndex, 0);
			// ����ID��Ѱ�������Ʒ����ϸ��Ϣ�ӡ����ݿ��в�ѯ��
			SupermarketDao dao = new SupermarketDao();
			//
			Supermarket s = dao.getSupermarketById(id);

			// ����һ����ʾ��ϸ��Ϣ�Ľ���
			new SupermarketDetailFrame(s);
			// �����ݿ��в�ѯ��������Ϣ��ʾ�ڼ�����
			// �ֿ�
		} else if (e.getActionCommand().equals("btnNature")) {
			EntrepotFrame frame = new EntrepotFrame();
			new EntrepotFrame();
			// ��ѯ
		} else if (e.getActionCommand().equals("btnRefer")) {
			ReferFrame frame = new ReferFrame();
			new ReferFrame();
		} else if (e.getActionCommand().equals("btnClose")) {
			this.dispose();
		}
	}
}
