import java.io.*;
import java.util.Scanner;
public class data {

	

	static int year, month, yearFirstDay, monthFirstDay; // 定义静态变量，以便其它类调用

		public static boolean isLeapYear(int y) {// 判断是否是闰年
			return ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0));
		}
		
		public static int getMonthDay(int m) {// 获取每个月的天数
			switch (m) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				if (isLeapYear(year))// 判断是否是闰年
					return 29;
				else
					return 28;
			default:
				return 0;
			}
		}

		public static void getYearFirstDay() {// 计算该年第一天是星期几
			long n = year * 365;
			for (int i = 1; i < year; i++)
				if (isLeapYear(i))// 判断是否是闰年
					n += 1;
			yearFirstDay = (int) n % 7;
		}

		public static void getMonthFirstDay() {// 计算该年第一天是星期几
			getYearFirstDay();
			int n = yearFirstDay;
			for (int i = 1; i < month; i++)
				n += getMonthDay(i);
			monthFirstDay = n % 7;
		}

		public static void printTitleWeek() {// 打印表头
			System.out.println("===========================");
			System.out.println("日  一  二  三   四  五   六");
		}

		public static void printMonths() {// 逐月打印该年的日历
			for (int m = 1; m <= 12; m++) // 循环月份
			{
				System.out.println(m + "月");
				printTitleWeek();
				for (int j = 1; j <= yearFirstDay; j++) {// 按每个月第一天是星期几打印相应的空格
					System.out.print("    ");
				}
				int monthDay = getMonthDay(m); // 获取每个月的天数
				for (int d = 1; d <= monthDay; d++) {
					if (d < 10)// 以下4行对输出格式化
						System.out.print(d + "   ");
					else
						System.out.print(d + "  ");
					yearFirstDay = (yearFirstDay + 1) % 7; 
					if (yearFirstDay == 0) 
						System.out.println();
				}
				System.out.println('\n');
			}
		}

		public static void printMonth() {
			System.out.println(month + "月");
			printTitleWeek();
			for (int j = 1; j <= monthFirstDay; j++) {
				System.out.print("    ");
			}
			int monthDay = getMonthDay(month);
			for (int d = 1; d <= monthDay; d++) {
				if (d < 10)
					System.out.print(d + "   ");
				else
					System.out.print(d + "  ");
				monthFirstDay = (monthFirstDay + 1) % 7; // 每打印一天后，反应第二天是星期几
				if (monthFirstDay == 0) // 如果第二天是星期天，便换行。
					System.out.println();
			}
			System.out.println('\n');
		}
		
		public static void main(String[] args) throws IOException {		
			Scanner input = new Scanner(System.in);
			System.out.print("姓名：");
			String name = input.next();
		
			System.out.print("学号：");
			String number = input.next();
		
			InputStreamReader ir; // 以下接受从控制台输入
			BufferedReader in;
			ir = new InputStreamReader(System.in);
			in = new BufferedReader(ir);
			System.out.print("请输入年份：");
			String y = in.readLine();
			year = Integer.parseInt(y);
			System.out.print("请输入月份：");
			String m = in.readLine();
			month = Integer.parseInt(m);
			//getYearFirstDay(); // 计算该年第一天是星期几
			getMonthFirstDay(); // 计算该月第一天是星期几
			System.out.println("\n          " + year + "年          ");
			//printMonths();
			printMonth();
		}
	}

