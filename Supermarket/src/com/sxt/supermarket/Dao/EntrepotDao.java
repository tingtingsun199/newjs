package com.sxt.supermarket.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sxt.supermarket.entity.Entrepot;

/**
 * �ֿ���
 * @author lenovo
 *
 */
public class EntrepotDao {
	
	/**
	 * ������Ʒ��Ϣ
	 * @param n
	 */
	public void savaEntrepot(Entrepot n){
	
		try {
			//�õ�����
			Connection conn=getconn();
			//ȡ��ִ����
			Statement stat=conn.createStatement();
			//��װSQL
			String sql="insert into entrepot(name,nature)" +
					"values('"+n.getName()+"','"+n.getNature()+"')";
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
	public void deleteEntrepot(int id){
		try {
			Connection conn=getconn();
			Statement stat=conn.createStatement();
			String sql="delete from entrepot where id="+id;
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
	
	public  ArrayList<Entrepot> findEntrepotList() {
		// ��������Ʒ�ļ���
		ArrayList<Entrepot> entrepotList = new ArrayList<Entrepot>();

		try {
			Connection conn = getconn();
			// sql
			String sql = "select * from entrepot";
			// ȡ��SQL���ִ����
			Statement stat = conn.createStatement();

			// ִ��SQL
			ResultSet rs = stat.executeQuery(sql);
			// ������ѯ
			while (rs.next()) {
				// ȡ�����ݿ����һ�е�һ����Ϣ
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String nature = rs.getString("nature");
				
				// ��װ����
				Entrepot n = new Entrepot(id, name,nature);
				// ��������ӵ�������
				entrepotList.add(n);
			}
			// �ر�����

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return entrepotList;

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
