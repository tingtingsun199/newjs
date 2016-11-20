package com.sxt.supermarket.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sxt.supermarket.Dao.SupermarketDao;
import com.sxt.supermarket.entity.Supermarket;

public class AddFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	
	private JTextField smtName;
	private JTextField smtNumber;
	private JTextField smtRise;
	private JTextField smtStandard;

	MainFrame mf;
	private JComboBox smtEntrepot;

	/**
	 * Create the frame.
	 */
	public AddFrame(MainFrame mf) {
		
		//接受外面传入的引入变量
		this.mf=mf;
		
		
		setTitle("\u5546\u54C1\u4FE1\u606F\u6DFB\u52A0\u8868");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 599, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u5546\u54C1\u4FE1\u606F\u6DFB\u52A0", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(48, 25, 485, 332);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		lblNewLabel.setBounds(39, 34, 69, 25);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setBounds(39, 92, 69, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u9500\u552E\u4EF7\u683C\uFF1A");
		lblNewLabel_2.setBounds(39, 152, 69, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5546\u54C1\u89C4\u683C\uFF1A");
		lblNewLabel_3.setBounds(39, 212, 69, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u6240\u5C5E\u4ED3\u5E93\uFF1A");
		lblNewLabel_4.setBounds(39, 272, 69, 25);
		panel_1.add(lblNewLabel_4);
		
		smtName = new JTextField();
		smtName.setBounds(112, 30, 256, 32);
		panel_1.add(smtName);
		smtName.setColumns(10);
		
		smtNumber = new JTextField();
		smtNumber.setBounds(112, 88, 256, 32);
		panel_1.add(smtNumber);
		smtNumber.setColumns(10);
		
		smtRise = new JTextField();
		smtRise.setBounds(112, 148, 256, 32);
		panel_1.add(smtRise);
		smtRise.setColumns(10);
		
		smtStandard = new JTextField();
		smtStandard.setBounds(112, 208, 256, 32);
		panel_1.add(smtStandard);
		smtStandard.setColumns(10);
		
		smtEntrepot = new JComboBox();
		smtEntrepot.setModel(new DefaultComboBoxModel(new String[] {"\u8BF7\u4E0B\u62C9\u9009\u62E9\u4ED3\u5E93", "\u6C34\u679C", "\u852C\u83DC", "\u526F\u98DF", "\u6D17\u6DA4", "\u6587\u5177", "\u8089\u98DF"}));
		smtEntrepot.setBounds(111, 263, 257, 34);
		panel_1.add(smtEntrepot);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(194, 391, 208, 38);
		contentPane.add(btnNewButton);
		
		this.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent argo){
		//取得输入框中的信息
		String name=smtName.getText();
		String regexText="[\\u4E00-\\u9FA5\\uF900-\\uFA2D]{2,4}";
		//通过正则表达式创建一个模板
		Pattern pattern=Pattern.compile(regexText);
		//匹配这个电话是否符合这个模板的格式
		Matcher m=pattern.matcher(name);
		boolean ok=m.matches();
		if(!ok){
			JOptionPane.showMessageDialog(this, "用户名不正确");
			//将光标移动错误的输入框中
			smtName.requestFocus();
			
			
			return;
			
		}
		
		
		String number=smtNumber.getText();
		String rise=smtRise.getText();
		String standard=smtStandard.getText();	
		String entrepot=(String) smtEntrepot.getSelectedItem();
		
		//组装成对象
		Supermarket s=new Supermarket(name,number,rise,standard,entrepot);
		
		//调用Dao【数据处理层】存储当前的商品信息
		SupermarketDao dao=new SupermarketDao();
		dao.savaSupermarket(s);
		//刷新表格
		mf.loadData();
		this.dispose();
	}
}
