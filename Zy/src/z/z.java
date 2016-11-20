package z;

import java.util.Scanner;

public class z {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		
		final double KILOGRAMS_PER_POUND=0.45359237;
		final double METERS_PER_INCHE=0.0254;
		System.out.print("请输入体重（磅）:");
		double weightInPound=input.nextDouble();
		System.out.print("请输入身高（英寸）:");
		double heightInInches=input.nextDouble();
		double heightInMeters=heightInInches/METERS_PER_INCHE;
		double weightInkilograms=weightInPound/KILOGRAMS_PER_POUND;
		double BMI=weightInkilograms/(Math.pow(heightInMeters, 2));
		System.out.print("BMI值为"+(int)(BMI*100)/100.0);
		if(BMI<18.5){
			System.out.print("你太瘦了，多吃点吧！");
		}
		if(BMI>=18.5 && BMI<=25){
			System.out.print("女神体重，请保持哦！");
			
		}
		if(BMI>=25 && BMI<=28){
			System.out.print("有点小胖，多跑跑你就是女神啦！");
			
		}
		if(BMI>=28 && BMI<=32){
			System.out.print("你太胖了，这样不好，快减肥！");
		}
		if(BMI>32){
			System.out.print("唉！你太胖了！不注意就挂了....");
		}
		
	}

}
