package com.sxt.supermarket.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sxt.supermarket.entity.Accounts;

/**
 * �˺Ŵ�����
 * @author lenovo
 *
 */
public class AccountsDao {
	
	public Accounts findAccounts(String username,String pwd){
		Accounts accounts=null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/smt?useUnicode=true&characterEncoding=UTF-8";
			//�õ�����
			Connection conn=DriverManager.getConnection(url, "root", "123456");
			//�õ����ִ����
			Statement stat=conn.createStatement();
			String sql="select * from accounts where username='"+username+"' and pwd='"+pwd+"' ";
			ResultSet rs=stat.executeQuery(sql);
			if(rs.next()){ 
				//������˺Ŵ���������˺ŵ�������Ϣ����
				int id=rs.getInt("id");
				String un=rs.getString("username");
				String pw=rs.getString("pwd");
				int st=rs.getInt("stat");
				//��װ�ɶ���
				accounts=new Accounts(id, un, pw, st);
		
			}
			rs.close();
			stat.close();
			conn.close();
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return accounts;
	}
}
