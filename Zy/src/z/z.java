package z;

import java.util.Scanner;

public class z {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		
		final double KILOGRAMS_PER_POUND=0.45359237;
		final double METERS_PER_INCHE=0.0254;
		System.out.print("���������أ�����:");
		double weightInPound=input.nextDouble();
		System.out.print("��������ߣ�Ӣ�磩:");
		double heightInInches=input.nextDouble();
		double heightInMeters=heightInInches/METERS_PER_INCHE;
		double weightInkilograms=weightInPound/KILOGRAMS_PER_POUND;
		double BMI=weightInkilograms/(Math.pow(heightInMeters, 2));
		System.out.print("BMIֵΪ"+(int)(BMI*100)/100.0);
		if(BMI<18.5){
			System.out.print("��̫���ˣ���Ե�ɣ�");
		}
		if(BMI>=18.5 && BMI<=25){
			System.out.print("Ů�����أ��뱣��Ŷ��");
			
		}
		if(BMI>=25 && BMI<=28){
			System.out.print("�е�С�֣������������Ů������");
			
		}
		if(BMI>=28 && BMI<=32){
			System.out.print("��̫���ˣ��������ã�����ʣ�");
		}
		if(BMI>32){
			System.out.print("������̫���ˣ���ע��͹���....");
		}
		
	}

}
