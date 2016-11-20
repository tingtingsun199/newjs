import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class lei {
	
	/**
	 * 计算成绩返回总分 最高分 最高分的索引
	 * @param courseList
	 * @return
	 */
	public static int[] think (ArrayList<Node> courseList){
		int[] result = new int[3];
		//总分
		result[0] = 0;
		
		result[1] = 0;
		//得出最高分
		for (int i = 0; i < courseList.size(); i++) {
			int score =Integer.parseInt(courseList.get(i).getTextContent());
			if(score > result[1]){
				result[1] = score; 
				//得出最高分的索引
				result[2] = i;
			}
			result[0]+=score;
		}
		return result;
	}
	
	
	public static String showId(NodeList studentList,int index){
		Element e = (Element) studentList.item(index);
		String studentId = e.getAttribute("学号");
		return studentId;
	}
	
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//构造DOM解析器的工厂实例
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				//构造DOM解析器实例
				DocumentBuilder builder =factory.newDocumentBuilder(); 
				//解析XML文档并返回根元素
				Document document = builder.parse("stady.xml");
				
				Element root = document.getDocumentElement();
				//获取score元素的内容
				NodeList scoreList = root.getElementsByTagName("score");
				//得到根元素student元素的内容
				NodeList studentList = root.getElementsByTagName("student");
				
				
				ArrayList<Node> javaList = new ArrayList<Node>();
				ArrayList<Node> strutsList = new ArrayList<Node>();
				ArrayList<Node> hibernateList = new ArrayList<Node>();
				
				for (int i = 0; i < scoreList.getLength(); i++) {
					
					//获取每个学生的成绩
					Node score = scoreList.item(i);
					
					//获取每个学生的课程
					NodeList courseList = score.getChildNodes();
					
					//把课程存入相应的课程集合
					for (int j = 0; j < courseList.getLength(); j++) {
						
						if(courseList.item(j).getNodeName().equals("Java")){
							javaList.add(courseList.item(j));
						}else if(courseList.item(j).getNodeName().equals("Struts")){
							strutsList.add(courseList.item(j));
						}else if(courseList.item(j).getNodeName().equals("Hibernate")){
							hibernateList.add(courseList.item(j));
						}
					}
					
				}
				
				System.out.println("java最高分是："+think(javaList)[1]);
				System.out.println("平均分是："+(think(javaList)[0]/studentList.getLength()));
				System.out.println("最高分的学号是："+showId(studentList,think(javaList)[2]));
				
				System.out.println("Struts最高分是："+think(strutsList)[1]);
				System.out.println("平均分是："+(think(strutsList)[0]/studentList.getLength()));
				System.out.println("最高分的学号是："+showId(studentList,think(strutsList)[2]));
				
				System.out.println("Hibernate最高分是："+think(hibernateList)[1]);
				System.out.println("平均分是："+(think(hibernateList)[0]/studentList.getLength()));
				System.out.println("最高分的学号是："+showId(studentList,think(hibernateList)[2]));
				
	}
}
