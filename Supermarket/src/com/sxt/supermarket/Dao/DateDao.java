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
		// 用来存商品的集合
		ArrayList<Date> dateList = new ArrayList<Date>();

		try {
			Connection conn = getconn();
			// sql
			String sql = "select * from date";
			// 取得SQL语句执行器
			Statement stat = conn.createStatement();

			// 执行SQL
			ResultSet rs = stat.executeQuery(sql);
			// 迭代查询
			while (rs.next()) {
				// 取出数据库表中一行的一列信息
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String date=rs.getString("date");
				String entrepot = rs.getString("entrepot");
				
				
				
				// 组装对象
				Date d = new Date(id, name,date,entrepot);
				// 将对象添加到集合中
				dateList.add(d);
			}
			// 关闭连接

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dateList;

	}

	private Connection getconn() throws ClassNotFoundException, SQLException {
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 链接数据库地址
		String url = "jdbc:mysql://localhost:3306/smt?useUnicode=true&characterEncoding=UTF-8";
		// 取得数据库链接
		Connection conn = DriverManager
				.getConnection(url, "root", "123456");
		return conn;
	}
}
