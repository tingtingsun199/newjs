import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class student {
public static void main(String args[])throws Exception{
	
	//����DOM�������Ĺ�����ʵ��
	DocumentBuilderFactory  factory=DocumentBuilderFactory.newInstance();
	//����DOM������ʵ��
	DocumentBuilder builder=factory.newDocumentBuilder();	
	//����XML�ĵ������ظ�Ԫ��
	Document document=builder.parse("stady.xml");

	//��ȡXML�ĵ��ĸ�Ԫ��		
	Element  root = document.getDocumentElement();                                              
System.out.println("<"+root.getNodeName()+">");

	//�õ���Ԫ��root�ڵ������еĺ��ӽڵ�		
	 NodeList nodelist=root.getChildNodes();                                        
    
    //����ÿ�����ӽڵ�
	for(int i=0;i<nodelist.getLength();i++){
        
		Node node=nodelist.item(i);
        //����ӽڵ���Ԫ�ؽڵ�
		if(node.getNodeType()==Node.ELEMENT_NODE){
            //�����ӽڵ�ǿ��ת����Ԫ�ؽڵ�
			Element elementNode=(Element)node;                                    
			String name=elementNode.getNodeName();
			String id=elementNode.getAttribute("ʱ��");
            //ȡ��Ԫ�ؽڵ���ı�����
			String content=elementNode.getTextContent();
                                
			System.out.print("<"+name+" ʱ��="+id+">"+content+"</"+name+">"+"\n");
		}
		//����ӽڵ����ı��ڵ�
		if(node.getNodeType()==Node.TEXT_NODE){
			System.out.print(node.getNodeValue().trim());
		 }
		}  
			
			System.out.println("</"+root.getNodeName()+">");		
		} 
	   
  }



	


