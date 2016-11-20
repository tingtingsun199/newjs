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
		// ���
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

		// ��������
		String[] columnName = { "ID", "�ֿ�����", "�ֿ⹦��" };
		// ����ģ��
		dtm = new DefaultTableModel(null, columnName);
		table = new JTable(dtm);
		// ���ñ��ĸ߶�
		table.setRowHeight(50);
		scrollPane.setViewportView(table);
		// ɾ��
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
		// ��ʾ
		this.setVisible(true);
	}

	// ȫ�ֱ���
	DefaultTableModel dtm;
	EntrepotDao entrepotDao = new EntrepotDao();
	private JTable table;

	// ��������
	public void loadData() {
		// ��ձ��
		dtm.setRowCount(0);

		// �����ݷ��ʲ�ȡ��������Ʒ�б�
		ArrayList<Entrepot> list = entrepotDao.findEntrepotList();
		// ����
		for (int i = 0; i < list.size(); i++) {
			// ÿ��ȡһ��
			Entrepot n = list.get(i);
			// ��װ�ɶ�������
			Object[] param = { n.getId(), n.getName(), n.getNature() };
			// ��������ӵ��������ģ����
			dtm.addRow(param);

		}
	}

	public void actionPerformed(ActionEvent e) {
		// ɾ����Ϣ
		if (e.getActionCommand().equals("btnDelete")) {
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
				EntrepotDao dao = new EntrepotDao();
				dao.deleteEntrepot(id);
				// ˢ�±��
				loadData();

			}
		} else if (e.getActionCommand().equals("btnAdd")) {
			// �����Ϣ
			// ȡ��������е���Ϣ

			String name = smtName.getText();
			String regexText = "[\\u4E00-\\u9FA5\\uF900-\\uFA2D]{2,4}";
			// ͨ��������ʽ����һ��ģ��
			Pattern pattern = Pattern.compile(regexText);
			// ƥ������绰�Ƿ�������ģ��ĸ�ʽ
			Matcher m = pattern.matcher(name);
			boolean ok = m.matches();
			if (!ok) {
				JOptionPane.showMessageDialog(this, "�û�������ȷ");
				// ������ƶ�������������
				smtName.requestFocus();
				return;
			}

			String nature = smtNature.getText();

			// ��װ�ɶ���
			Entrepot n = new Entrepot(name, nature);

			// ����Dao�����ݴ���㡿�洢��ǰ����Ʒ��Ϣ
			EntrepotDao dao = new EntrepotDao();
			dao.savaEntrepot(n);
			// ˢ�±��
			loadData();

		}else if(e.getActionCommand().equals("btnClose")){
			this.dispose();
		}

	}
}
