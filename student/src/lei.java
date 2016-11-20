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
	 * ����ɼ������ܷ� ��߷� ��߷ֵ�����
	 * @param courseList
	 * @return
	 */
	public static int[] think (ArrayList<Node> courseList){
		int[] result = new int[3];
		//�ܷ�
		result[0] = 0;
		
		result[1] = 0;
		//�ó���߷�
		for (int i = 0; i < courseList.size(); i++) {
			int score =Integer.parseInt(courseList.get(i).getTextContent());
			if(score > result[1]){
				result[1] = score; 
				//�ó���߷ֵ�����
				result[2] = i;
			}
			result[0]+=score;
		}
		return result;
	}
	
	
	public static String showId(NodeList studentList,int index){
		Element e = (Element) studentList.item(index);
		String studentId = e.getAttribute("ѧ��");
		return studentId;
	}
	
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//����DOM�������Ĺ���ʵ��
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				//����DOM������ʵ��
				DocumentBuilder builder =factory.newDocumentBuilder(); 
				//����XML�ĵ������ظ�Ԫ��
				Document document = builder.parse("stady.xml");
				
				Element root = document.getDocumentElement();
				//��ȡscoreԪ�ص�����
				NodeList scoreList = root.getElementsByTagName("score");
				//�õ���Ԫ��studentԪ�ص�����
				NodeList studentList = root.getElementsByTagName("student");
				
				
				ArrayList<Node> javaList = new ArrayList<Node>();
				ArrayList<Node> strutsList = new ArrayList<Node>();
				ArrayList<Node> hibernateList = new ArrayList<Node>();
				
				for (int i = 0; i < scoreList.getLength(); i++) {
					
					//��ȡÿ��ѧ���ĳɼ�
					Node score = scoreList.item(i);
					
					//��ȡÿ��ѧ���Ŀγ�
					NodeList courseList = score.getChildNodes();
					
					//�ѿγ̴�����Ӧ�Ŀγ̼���
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
				
				System.out.println("java��߷��ǣ�"+think(javaList)[1]);
				System.out.println("ƽ�����ǣ�"+(think(javaList)[0]/studentList.getLength()));
				System.out.println("��߷ֵ�ѧ���ǣ�"+showId(studentList,think(javaList)[2]));
				
				System.out.println("Struts��߷��ǣ�"+think(strutsList)[1]);
				System.out.println("ƽ�����ǣ�"+(think(strutsList)[0]/studentList.getLength()));
				System.out.println("��߷ֵ�ѧ���ǣ�"+showId(studentList,think(strutsList)[2]));
				
				System.out.println("Hibernate��߷��ǣ�"+think(hibernateList)[1]);
				System.out.println("ƽ�����ǣ�"+(think(hibernateList)[0]/studentList.getLength()));
				System.out.println("��߷ֵ�ѧ���ǣ�"+showId(studentList,think(hibernateList)[2]));
				
	}
}
