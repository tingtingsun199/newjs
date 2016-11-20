import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class Testtable extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testtable frame = new Testtable();
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
	public Testtable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		//���Բ���
		
		contentPane.setBorder(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//��������
		String[] columnName={"����","�칫�绰","��ͥ�绰","��ַ"};
		
		
		//����ģ��
		dtm=new DefaultTableModel(null,columnName);
		//�������
		JTable table=new JTable(dtm);
		//table.setBounds(10,10,400,30);
		JScrollPane jsp=new JScrollPane(table);
		
		jsp.setBounds(10,10,400,300);
		//�������ӵ������
		contentPane.add(jsp);
		
		//������
		loadData();
	}
	
	DefaultTableModel dtm;

	public void loadData(){
		
		//ȡ�ñ�������ģ��
		
		
		//��֯������
		ArrayList<Friend> list=new ArrayList<Friend>();
		list.add(new Friend("һ��","139-4454-2362","0723-1665456","ɽ��"));
		list.add(new Friend("����","139-4454-2462","0723-1662356","�Ķ�"));
		list.add(new Friend("����","139-4454-2562","0723-1665956","ɽ��"));
		list.add(new Friend("�ķ�","139-4454-6562","0723-1665856","դ��"));
		//ѭ���������е�������ӵ�����ģ����
		
		for(int i=0;i<list.size();i++){
			Friend f=list.get(i);
			Object[] data={f.getName(),f.getOfficephone(),f.getHomephone(),f.getAddress()};
			dtm.addRow(data);
		}
	}
}
