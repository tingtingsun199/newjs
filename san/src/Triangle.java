import java.util.Scanner;


public class Triangle {
	
		public static void main(String[] args){
		Scanner sca=new Scanner(System.in);
		System.out.println("�����������ε�������,�м��Կո����:");
	     float a=sca.nextFloat();
		 float b = sca.nextFloat();
		 float c=sca.nextFloat();
		 
		 double p = (a+b+c)/2;
		double area =Math.sqrt(p*(p-a)*(p-b)*(p-c));
		 
		if(a+b>c&&a+c>b&&b+c>a){
		System.out.println("�����ε��ܳ���:"+(a+b+c));
		System.out.println("�����ε������:"+area);
		}else{
		System.out.println("������Ч");
		}
	}
		
	}
	

	
	
	
	