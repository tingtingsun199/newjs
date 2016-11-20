package com.sxt.supermarket.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sxt.supermarket.entity.Date;

public class DateDao {
	public  ArrayList<Date> findDateList() {
		// ��������Ʒ�ļ���
		ArrayList<Date> dateList = new ArrayList<Date>();

		try {
			Connection conn = getconn();
			// sql
			String sql = "select * from date";
			// ȡ��SQL���ִ����
			Statement stat = conn.createStatement();

			// ִ��SQL
			ResultSet rs = stat.executeQuery(sql);
			// ������ѯ
			while (rs.next()) {
				// ȡ�����ݿ����һ�е�һ����Ϣ
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String date=rs.getString("date");
				String entrepot = rs.getString("entrepot");
				
				
				
				// ��װ����
				Date d = new Date(id, name,date,entrepot);
				// ��������ӵ�������
				dateList.add(d);
			}
			// �ر�����

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dateList;

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
