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
		//绝对布局
		
		contentPane.setBorder(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//列名数组
		String[] columnName={"姓名","办公电话","家庭电话","地址"};
		
		
		//数据模型
		dtm=new DefaultTableModel(null,columnName);
		//创建表格
		JTable table=new JTable(dtm);
		//table.setBounds(10,10,400,30);
		JScrollPane jsp=new JScrollPane(table);
		
		jsp.setBounds(10,10,400,300);
		//将表格添加到面板中
		contentPane.add(jsp);
		
		//当窗口
		loadData();
	}
	
	DefaultTableModel dtm;

	public void loadData(){
		
		//取得表格的数据模型
		
		
		//组织好数据
		ArrayList<Friend> list=new ArrayList<Friend>();
		list.add(new Friend("一飞","139-4454-2362","0723-1665456","山东"));
		list.add(new Friend("二飞","139-4454-2462","0723-1662356","四东"));
		list.add(new Friend("三飞","139-4454-2562","0723-1665956","山西"));
		list.add(new Friend("四飞","139-4454-6562","0723-1665856","栅东"));
		//循环将集合中的数据添加到数据模型中
		
		for(int i=0;i<list.size();i++){
			Friend f=list.get(i);
			Object[] data={f.getName(),f.getOfficephone(),f.getHomephone(),f.getAddress()};
			dtm.addRow(data);
		}
	}
}
