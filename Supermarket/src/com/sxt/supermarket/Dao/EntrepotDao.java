package com.sxt.supermarket.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sxt.supermarket.entity.Entrepot;

/**
 * 仓库类
 * @author lenovo
 *
 */
public class EntrepotDao {
	
	/**
	 * 保存商品信息
	 * @param n
	 */
	public void savaEntrepot(Entrepot n){
	
		try {
			//得到链接
			Connection conn=getconn();
			//取得执行器
			Statement stat=conn.createStatement();
			//组装SQL
			String sql="insert into entrepot(name,nature)" +
					"values('"+n.getName()+"','"+n.getNature()+"')";
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
	 * 从数据库加载商品列表
	 * 
	 * @return list
	 */
	
	public  ArrayList<Entrepot> findEntrepotList() {
		// 用来存商品的集合
		ArrayList<Entrepot> entrepotList = new ArrayList<Entrepot>();

		try {
			Connection conn = getconn();
			// sql
			String sql = "select * from entrepot";
			// 取得SQL语句执行器
			Statement stat = conn.createStatement();

			// 执行SQL
			ResultSet rs = stat.executeQuery(sql);
			// 迭代查询
			while (rs.next()) {
				// 取出数据库表中一行的一列信息
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String nature = rs.getString("nature");
				
				// 组装对象
				Entrepot n = new Entrepot(id, name,nature);
				// 将对象添加到集合中
				entrepotList.add(n);
			}
			// 关闭连接

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return entrepotList;

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
