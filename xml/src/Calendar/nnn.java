package Calendar;

	import java.util.Scanner;
public class nnn {
	

	
	public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			System.out.print("������");
			String name = input.next();
			
	System.out.print("ѧ�ţ�");
			String number = input.next();
			
			System.out.println("��������ݣ�");
			int year = input.nextInt();
			
	System.out.println("�������һ�������ڼ���");
			int day = input.nextInt();
	System.out.println("\t\t\t"+year+ "����");
					
			for(int month= 1; month <= 12; month++){
				
	switch(month){
				case 1:
					System.out.println("\n"+"\t\t\t"+"һ��");
					break;
				case 2:
					System.out.println("\n"+"\t\t\t"+"����");
					break;
				case 3:
					System.out.println("\n"+"\t\t\t"+"����");
					break;
				case 4:
					System.out.println("\n"+"\t\t\t"+"����");
					break;
				case 5:
					System.out.println("\n"+"\t\t\t"+"����");
					break;
				case 6:
					System.out.println("\n"+"\t\t\t"+"����");
					break;
				case 7:
					System.out.println("\n"+"\t\t\t"+"����");
					break;
				case 8:
					System.out.println("\n"+"\t\t\t"+"����");
					break;
				case 9:
					System.out.println("\n"+"\t\t\t"+"����");
					break;			
				case 10:
						System.out.println("\n"+"\t\t\t"+"ʮ��");
						break;			
				case 11:
						System.out.println("\n"+"\t\t\t"+"ʮһ��");
						break;			
				case 12:
						System.out.println("\n"+"\t\t\t"+"ʮ����");
						break;
	}
				System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");
				for (int j = 1; j <= day; j++) {				
	System.out.print("\t");
				}
			
	switch(month){
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						for(int date = 1;date <= 31; date++){
							System.out.print(date +	"\t");
							day = (day + 1) % 7;
							if(day == 0){
								System.out.println();
								}
	}
						System.out.println("\n");
						break;
				case 4:
					case 6:
					case 9:
					case 11:
						for(int date = 1; date <= 30; date++){
							System.out.print(date +	"\t");
							day = (day + 1) % 7;
							if(day == 0){
								System.out.println();
								}
	}
						System.out.println("\n");
						break;
				case 2:
						//�ж��Ƿ�Ϊ����
						if((year % 400 == 0) || (year % 4 == 0 && year % 100 == 0)){
							for(int date = 1; date <= 29; date++){
								System.out.print(date +	"\t");
								day = (day + 1) % 7;
								if(day == 0){
									System.out.println();
									}
							}
							break;
						}else{
							for(int date = 1; date <= 28; date++){
								System.out.print(date +	"\t");
								day = (day + 1) % 7;
								if(day == 0){
									System.out.println();
									}
								}
							break;
	}
						}
				}
			}
}
		


