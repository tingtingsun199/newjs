package com.sxt.supermarket.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sxt.supermarket.entity.Supermarket;

/**
 * 数据访问层
 * @author lenovo
 *
 */
public class SupermarketDao {
	/**
	 * 根据ID查询出一个商品的详细信息
	 * 
	 */
	public Supermarket getSupermarketById(int id){
		Supermarket s=null;
		try {
			//取得链接
			Connection conn=getconn();
			//得到语句执行器
			Statement stat=conn.createStatement();
			String sql="select * from supermarket where id="+id;
			//执行并返回数据结果
			ResultSet rs=stat.executeQuery(sql);
			//询问是否还有下一个
			if(rs.next()){
				
				String name=rs.getString("name");
				String number=rs.getString("number");
				String rise=rs.getString("rise");
				String standard=rs.getString("standard");
				String entrepot=rs.getString("entrepot");
				
				//组装成对象
				s=new Supermarket(id,name,number,rise,standard,entrepot);
				
			}
			//关闭
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * 保存商品信息
	 * @param s
	 */
	public void savaSupermarket(Supermarket s){
	
		try {
			//得到链接
			Connection conn=getconn();
			//取得执行器
			Statement stat=conn.createStatement();
			//组装SQL
			String sql="insert into supermarket(name,number,rise,standard,entrepot)" +
					"values('"+s.getName()+"','"+s.getNumber()+"','"+s.getRise()+"','"+s.getStandard()+"','"+s.getEntrepot()+"')";
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
	 * 从数据库加载商品列表
	 * 
	 * @return list
	 */
	
	public ArrayList<Supermarket> findSupermarketList() {
		// 用来存商品的集合
		ArrayList<Supermarket> supermarketList = new ArrayList<Supermarket>();

		try {
			Connection conn = getconn();
			// sql
			String sql = "select * from supermarket";
			// 取得SQL语句执行器
			Statement stat = conn.createStatement();

			// 执行SQL
			ResultSet rs = stat.executeQuery(sql);
			// 迭代查询
			while (rs.next()) {
				// 取出数据库表中一行的一列信息
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String number = rs.getString("number");
				String rise = rs.getString("rise");
				String standard = rs.getString("standard");
				String entrepot = rs.getString("entrepot");
				// 组装对象
				Supermarket s = new Supermarket(id, name, number, rise, standard,entrepot);
				// 将对象添加到集合中
				supermarketList.add(s);
			}
			// 关闭连接

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return supermarketList;

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
