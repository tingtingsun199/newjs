package com.sxt.friend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sxt.friend.entity.Account;

/**
 * �˺����ݴ�����
 * @author lenovo
 *
 */
public class AcountDao {
	
	public Account findAccount(String username,String pwd){
		Account account=null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/txl?useUnicode=true&characterEncoding=UTF-8";
			//�õ�����
			Connection conn=DriverManager.getConnection(url, "root", "123456");
			//�õ����ִ����
			Statement stat=conn.createStatement();
			String sql="select * from account where username='"+username+"' and pwd='"+pwd+"' ";
			ResultSet rs=stat.executeQuery(sql);
			if(rs.next()){
				//������˺Ŵ���������˺ŵ�������Ϣ����
				int id=rs.getInt("id");
				String un=rs.getString("username");
				String pw=rs.getString("pwd");
				int st=rs.getInt("stat");
				//��װ�ɶ���
				account=new Account(id, un, pw, st);
		
			}
			rs.close();
			stat.close();
			conn.close();
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return account;
	}
}
	


