package com.sxt.supermarket.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sxt.supermarket.entity.Supermarket;

/**
 * ���ݷ��ʲ�
 * @author lenovo
 *
 */
public class SupermarketDao {
	/**
	 * ����ID��ѯ��һ����Ʒ����ϸ��Ϣ
	 * 
	 */
	public Supermarket getSupermarketById(int id){
		Supermarket s=null;
		try {
			//ȡ������
			Connection conn=getconn();
			//�õ����ִ����
			Statement stat=conn.createStatement();
			String sql="select * from supermarket where id="+id;
			//ִ�в��������ݽ��
			ResultSet rs=stat.executeQuery(sql);
			//ѯ���Ƿ�����һ��
			if(rs.next()){
				
				String name=rs.getString("name");
				String number=rs.getString("number");
				String rise=rs.getString("rise");
				String standard=rs.getString("standard");
				String entrepot=rs.getString("entrepot");
				
				//��װ�ɶ���
				s=new Supermarket(id,name,number,rise,standard,entrepot);
				
			}
			//�ر�
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * ������Ʒ��Ϣ
	 * @param s
	 */
	public void savaSupermarket(Supermarket s){
	
		try {
			//�õ�����
			Connection conn=getconn();
			//ȡ��ִ����
			Statement stat=conn.createStatement();
			//��װSQL
			String sql="insert into supermarket(name,number,rise,standard,entrepot)" +
					"values('"+s.getName()+"','"+s.getNumber()+"','"+s.getRise()+"','"+s.getStandard()+"','"+s.getEntrepot()+"')";
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
	public void deleteSupermarket(int id){
		try {
			Connection conn=getconn();
			Statement stat=conn.createStatement();
			String sql="delete from supermarket where id="+id;
			System.out.println(sql);
			stat.executeUpdate(sql);
			stat.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����ݿ������Ʒ�б�
	 * 
	 * @return list
	 */
	
	public ArrayList<Supermarket> findSupermarketList() {
		// ��������Ʒ�ļ���
		ArrayList<Supermarket> supermarketList = new ArrayList<Supermarket>();

		try {
			Connection conn = getconn();
			// sql
			String sql = "select * from supermarket";
			// ȡ��SQL���ִ����
			Statement stat = conn.createStatement();

			// ִ��SQL
			ResultSet rs = stat.executeQuery(sql);
			// ������ѯ
			while (rs.next()) {
				// ȡ�����ݿ����һ�е�һ����Ϣ
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String number = rs.getString("number");
				String rise = rs.getString("rise");
				String standard = rs.getString("standard");
				String entrepot = rs.getString("entrepot");
				// ��װ����
				Supermarket s = new Supermarket(id, name, number, rise, standard,entrepot);
				// ��������ӵ�������
				supermarketList.add(s);
			}
			// �ر�����

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return supermarketList;

	}

	private Connection getconn() throws ClassNotFoundException, SQLException {
		// ��������
		Class.forName("com.mysql.jdbc.Driver");
		// �������ݿ��ַ
		String url = "jdbc:mysql://localhost:3306/smt?useUnicode=true&characterEncoding=UTF-8";
		// ȡ�����ݿ�����
		Connection conn = DriverManager
				.getConnection(url, "root", "123456");
		return conn;
	}
	
	
	
}
