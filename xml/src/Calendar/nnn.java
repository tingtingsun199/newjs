package Calendar;

	import java.util.Scanner;
public class nnn {
	

	
	public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			System.out.print("姓名：");
			String name = input.next();
			
	System.out.print("学号：");
			String number = input.next();
			
			System.out.println("请输入年份：");
			int year = input.nextInt();
			
	System.out.println("请输入第一天是星期几：");
			int day = input.nextInt();
	System.out.println("\t\t\t"+year+ "年历");
					
			for(int month= 1; month <= 12; month++){
				
	switch(month){
				case 1:
					System.out.println("\n"+"\t\t\t"+"一月");
					break;
				case 2:
					System.out.println("\n"+"\t\t\t"+"二月");
					break;
				case 3:
					System.out.println("\n"+"\t\t\t"+"三月");
					break;
				case 4:
					System.out.println("\n"+"\t\t\t"+"四月");
					break;
				case 5:
					System.out.println("\n"+"\t\t\t"+"五月");
					break;
				case 6:
					System.out.println("\n"+"\t\t\t"+"六月");
					break;
				case 7:
					System.out.println("\n"+"\t\t\t"+"七月");
					break;
				case 8:
					System.out.println("\n"+"\t\t\t"+"八月");
					break;
				case 9:
					System.out.println("\n"+"\t\t\t"+"九月");
					break;			
				case 10:
						System.out.println("\n"+"\t\t\t"+"十月");
						break;			
				case 11:
						System.out.println("\n"+"\t\t\t"+"十一月");
						break;			
				case 12:
						System.out.println("\n"+"\t\t\t"+"十二月");
						break;
	}
				System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
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
						//判断是否为闰年
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
		


