import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JBDC1 {
	public static void main(String[] args) {
		//����
		findFriendList();
	}
	
	public static void  findFriendList(){
		
		try{
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//�������ݿ��ַ
			String url="jdbc:mysql://localhost:3306/txl?useUnicode=true&characterEncoding=UTF-8";
			//ȡ�����ݿ�����
			Connection conn=DriverManager.getConnection(url,"root","123456");
			//sql
			String sql="select * from friend";
			//ȡ��SQL���ִ����
			Statement stat=conn.createStatement();
			
			//ִ��SQL
			ResultSet rs=stat.executeQuery(sql);
			//������ѯ
			while(rs.next()){//����һ����
				//ȡ�����ݿ����һ�е�һ����Ϣ
				String name=rs.getString("name");
				System.out.println(name);
				
			}
			//�ر�����
					
			rs.close();
			stat.close();
			conn.close();
					
		}catch(Exception e){
			e.printStackTrace();
		}
			
			
		
	}




}
