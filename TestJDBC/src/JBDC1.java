import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JBDC1 {
	public static void main(String[] args) {
		//调用
		findFriendList();
	}
	
	public static void  findFriendList(){
		
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//链接数据库地址
			String url="jdbc:mysql://localhost:3306/txl?useUnicode=true&characterEncoding=UTF-8";
			//取得数据库链接
			Connection conn=DriverManager.getConnection(url,"root","123456");
			//sql
			String sql="select * from friend";
			//取得SQL语句执行器
			Statement stat=conn.createStatement();
			
			//执行SQL
			ResultSet rs=stat.executeQuery(sql);
			//迭代查询
			while(rs.next()){//有下一个吗
				//取出数据库表中一行的一列信息
				String name=rs.getString("name");
				System.out.println(name);
				
			}
			//关闭连接
					
			rs.close();
			stat.close();
			conn.close();
					
		}catch(Exception e){
			e.printStackTrace();
		}
			
			
		
	}




}
