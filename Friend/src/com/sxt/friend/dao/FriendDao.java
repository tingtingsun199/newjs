package com.sxt.friend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sxt.friend.entity.Friend;

/**
 * 数据访问层
 * @author lenovo
 *
 */

public class FriendDao {
	/**
	 * 根据ID查询出一个朋友的详细信息
	 * 
	 */
	public Friend getFrienById(int id){
		Friend f=null;
		try {
			//取得链接
			Connection conn=getconn();
			//得到语句执行器
			Statement stat=conn.createStatement();
			String sql="select * from friend where id="+id;
			//执行并返回数据结果
			ResultSet rs=stat.executeQuery(sql);
			//询问是否还有下一个
			if(rs.next()){
				
				String name=rs.getString("name");
				String officePhone=rs.getString("officePhone");
				String homePhone=rs.getString("homePhone");
				String address=rs.getString("address");
				
				//组装成对象
				f=new Friend(id,name,officePhone,homePhone,address);
				
			}
			//关闭
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	/**
	 * 保存朋友信息
	 * @param f
	 */
	public void savaFriend(Friend f){
	
		try {
			//得到链接
			Connection conn=getconn();
			//取得执行器
			Statement stat=conn.createStatement();
			//组装SQL
			String sql="insert into friend(name,officePhone,homePhone,address)" +
					"values('"+f.getName()+"','"+f.getOfficePhone()+"','"+f.getHomePhone()+"','"+f.getAddress()+"')";
			//执行
			stat.executeUpdate(sql);
			//关闭
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	/**
	 * 根据ID删除
	 * @param id
	 */
	public void deleteFriend(int id){
		try {
			Connection conn=getconn();
			Statement stat=conn.createStatement();
			String sql="delete from friend where id="+id;
			System.out.println(sql);
			stat.executeUpdate(sql);
			stat.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从数据库加载朋友列表
	 * 
	 * @return list
	 */
	
	public ArrayList<Friend> findFriendList() {
		// 用来存朋友对象的集合
		ArrayList<Friend> friendList = new ArrayList<Friend>();

		try {
			Connection conn = getconn();
			// sql
			String sql = "select * from friend";
			// 取得SQL语句执行器
			Statement stat = conn.createStatement();

			// 执行SQL
			ResultSet rs = stat.executeQuery(sql);
			// 迭代查询
			while (rs.next()) {
				// 取出数据库表中一行的一列信息
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String officePhone = rs.getString("officePhone");
				String homePhone = rs.getString("homePhone");
				String address = rs.getString("address");
				// 组装对象
				Friend f = new Friend(id, name, officePhone, homePhone, address);
				// 将对象添加到集合中
				friendList.add(f);
			}
			// 关闭连接

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return friendList;

	}

	private Connection getconn() throws ClassNotFoundException, SQLException {
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 链接数据库地址
		String url = "jdbc:mysql://localhost:3306/txl?useUnicode=true&characterEncoding=UTF-8";
		// 取得数据库链接
		Connection conn = DriverManager
				.getConnection(url, "root", "123456");
		return conn;
	}
}
