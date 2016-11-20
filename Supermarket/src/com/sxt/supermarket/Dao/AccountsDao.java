package com.sxt.supermarket.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sxt.supermarket.entity.Accounts;

/**
 * 账号处理类
 * @author lenovo
 *
 */
public class AccountsDao {
	
	public Accounts findAccounts(String username,String pwd){
		Accounts accounts=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/smt?useUnicode=true&characterEncoding=UTF-8";
			//得到链接
			Connection conn=DriverManager.getConnection(url, "root", "123456");
			//得到语句执行器
			Statement stat=conn.createStatement();
			String sql="select * from accounts where username='"+username+"' and pwd='"+pwd+"' ";
			ResultSet rs=stat.executeQuery(sql);
			if(rs.next()){ 
				//如果有账号存在则将这个账号的所有信息读出
				int id=rs.getInt("id");
				String un=rs.getString("username");
				String pw=rs.getString("pwd");
				int st=rs.getInt("stat");
				//组装成对象
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
