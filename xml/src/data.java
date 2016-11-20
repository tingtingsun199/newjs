import java.io.*;
import java.util.Scanner;
public class data {

	

	static int year, month, yearFirstDay, monthFirstDay; // ���徲̬�������Ա����������

		public static boolean isLeapYear(int y) {// �ж��Ƿ�������
			return ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0));
		}
		
		public static int getMonthDay(int m) {// ��ȡÿ���µ�����
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
				if (isLeapYear(year))// �ж��Ƿ�������
					return 29;
				else
					return 28;
			default:
				return 0;
			}
		}

		public static void getYearFirstDay() {// ��������һ�������ڼ�
			long n = year * 365;
			for (int i = 1; i < year; i++)
				if (isLeapYear(i))// �ж��Ƿ�������
					n += 1;
			yearFirstDay = (int) n % 7;
		}

		public static void getMonthFirstDay() {// ��������һ�������ڼ�
			getYearFirstDay();
			int n = yearFirstDay;
			for (int i = 1; i < month; i++)
				n += getMonthDay(i);
			monthFirstDay = n % 7;
		}

		public static void printTitleWeek() {// ��ӡ��ͷ
			System.out.println("===========================");
			System.out.println("��  һ  ��  ��   ��  ��   ��");
		}

		public static void printMonths() {// ���´�ӡ���������
			for (int m = 1; m <= 12; m++) // ѭ���·�
			{
				System.out.println(m + "��");
				printTitleWeek();
				for (int j = 1; j <= yearFirstDay; j++) {// ��ÿ���µ�һ�������ڼ���ӡ��Ӧ�Ŀո�
					System.out.print("    ");
				}
				int monthDay = getMonthDay(m); // ��ȡÿ���µ�����
				for (int d = 1; d <= monthDay; d++) {
					if (d < 10)// ����4�ж������ʽ��
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
			System.out.println(month + "��");
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
				monthFirstDay = (monthFirstDay + 1) % 7; // ÿ��ӡһ��󣬷�Ӧ�ڶ��������ڼ�
				if (monthFirstDay == 0) // ����ڶ����������죬�㻻�С�
					System.out.println();
			}
			System.out.println('\n');
		}
		
		public static void main(String[] args) throws IOException {		
			Scanner input = new Scanner(System.in);
			System.out.print("������");
			String name = input.next();
		
			System.out.print("ѧ�ţ�");
			String number = input.next();
		
			InputStreamReader ir; // ���½��ܴӿ���̨����
			BufferedReader in;
			ir = new InputStreamReader(System.in);
			in = new BufferedReader(ir);
			System.out.print("��������ݣ�");
			String y = in.readLine();
			year = Integer.parseInt(y);
			System.out.print("�������·ݣ�");
			String m = in.readLine();
			month = Integer.parseInt(m);
			//getYearFirstDay(); // ��������һ�������ڼ�
			getMonthFirstDay(); // ������µ�һ�������ڼ�
			System.out.println("\n          " + year + "��          ");
			//printMonths();
			printMonth();
		}
	}

