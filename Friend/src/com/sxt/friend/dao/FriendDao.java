package com.sxt.friend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sxt.friend.entity.Friend;

/**
 * ���ݷ��ʲ�
 * @author lenovo
 *
 */

public class FriendDao {
	/**
	 * ����ID��ѯ��һ�����ѵ���ϸ��Ϣ
	 * 
	 */
	public Friend getFrienById(int id){
		Friend f=null;
		try {
			//ȡ������
			Connection conn=getconn();
			//�õ����ִ����
			Statement stat=conn.createStatement();
			String sql="select * from friend where id="+id;
			//ִ�в��������ݽ��
			ResultSet rs=stat.executeQuery(sql);
			//ѯ���Ƿ�����һ��
			if(rs.next()){
				
				String name=rs.getString("name");
				String officePhone=rs.getString("officePhone");
				String homePhone=rs.getString("homePhone");
				String address=rs.getString("address");
				
				//��װ�ɶ���
				f=new Friend(id,name,officePhone,homePhone,address);
				
			}
			//�ر�
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	/**
	 * ����������Ϣ
	 * @param f
	 */
	public void savaFriend(Friend f){
	
		try {
			//�õ�����
			Connection conn=getconn();
			//ȡ��ִ����
			Statement stat=conn.createStatement();
			//��װSQL
			String sql="insert into friend(name,officePhone,homePhone,address)" +
					"values('"+f.getName()+"','"+f.getOfficePhone()+"','"+f.getHomePhone()+"','"+f.getAddress()+"')";
			//ִ��
			stat.executeUpdate(sql);
			//�ر�
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	/**
	 * ����IDɾ��
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
	 * �����ݿ���������б�
	 * 
	 * @return list
	 */
	
	public ArrayList<Friend> findFriendList() {
		// ���������Ѷ���ļ���
		ArrayList<Friend> friendList = new ArrayList<Friend>();

		try {
			Connection conn = getconn();
			// sql
			String sql = "select * from friend";
			// ȡ��SQL���ִ����
			Statement stat = conn.createStatement();

			// ִ��SQL
			ResultSet rs = stat.executeQuery(sql);
			// ������ѯ
			while (rs.next()) {
				// ȡ�����ݿ����һ�е�һ����Ϣ
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String officePhone = rs.getString("officePhone");
				String homePhone = rs.getString("homePhone");
				String address = rs.getString("address");
				// ��װ����
				Friend f = new Friend(id, name, officePhone, homePhone, address);
				// ��������ӵ�������
				friendList.add(f);
			}
			// �ر�����

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return friendList;

	}

	private Connection getconn() throws ClassNotFoundException, SQLException {
		// ��������
		Class.forName("com.mysql.jdbc.Driver");
		// �������ݿ��ַ
		String url = "jdbc:mysql://localhost:3306/txl?useUnicode=true&characterEncoding=UTF-8";
		// ȡ�����ݿ�����
		Connection conn = DriverManager
				.getConnection(url, "root", "123456");
		return conn;
	}
}
