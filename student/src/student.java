import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class student {
public static void main(String args[])throws Exception{
	
	//构造DOM解析器的工厂类实例
	DocumentBuilderFactory  factory=DocumentBuilderFactory.newInstance();
	//构造DOM解析器实例
	DocumentBuilder builder=factory.newDocumentBuilder();	
	//解析XML文档并返回根元素
	Document document=builder.parse("stady.xml");

	//获取XML文档的根元素		
	Element  root = document.getDocumentElement();                                              
System.out.println("<"+root.getNodeName()+">");

	//得到根元素root节点下所有的孩子节点		
	 NodeList nodelist=root.getChildNodes();                                        
    
    //遍历每个孩子节点
	for(int i=0;i<nodelist.getLength();i++){
        
		Node node=nodelist.item(i);
        //如果子节点是元素节点
		if(node.getNodeType()==Node.ELEMENT_NODE){
            //将孩子节点强制转换成元素节点
			Element elementNode=(Element)node;                                    
			String name=elementNode.getNodeName();
			String id=elementNode.getAttribute("时间");
            //取得元素节点的文本内容
			String content=elementNode.getTextContent();
                                
			System.out.print("<"+name+" 时间="+id+">"+content+"</"+name+">"+"\n");
		}
		//如果子节点是文本节点
		if(node.getNodeType()==Node.TEXT_NODE){
			System.out.print(node.getNodeValue().trim());
		 }
		}  
			
			System.out.println("</"+root.getNodeName()+">");		
		} 
	   
  }



	


