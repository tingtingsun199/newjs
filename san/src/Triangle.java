import java.util.Scanner;


public class Triangle {
	
		public static void main(String[] args){
		Scanner sca=new Scanner(System.in);
		System.out.println("请输入三角形的三条边,中间以空格隔开:");
	     float a=sca.nextFloat();
		 float b = sca.nextFloat();
		 float c=sca.nextFloat();
		 
		 double p = (a+b+c)/2;
		double area =Math.sqrt(p*(p-a)*(p-b)*(p-c));
		 
		if(a+b>c&&a+c>b&&b+c>a){
		System.out.println("三角形的周长是:"+(a+b+c));
		System.out.println("三角形的面积是:"+area);
		}else{
		System.out.println("输入无效");
		}
	}
		
	}
	

	
	
	
	