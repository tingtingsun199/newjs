/**
 * 
 * @author lenovo
 *
 */

public class TestMath {
	public static void main(String[] args) {
		//�����ĸ�����
		java.util.Scanner sc=new java.util.Scanner(System.in);
		String number=sc.next();
		//ת������
		char[] ch=number.toCharArray();
		//����
		java.util.Arrays.sort(ch);
		//��ʼ��while
		while(true){
			//ת������
			char[] ch=number.toCharArray();
			//����
			java.util.Arrays.sort(ch);
			
			String max="";
			String min="";
			for (int i = 0; i < ch.length; i++) {
				max=max+ch [i];
				min=ch[i]+min;	
			}
			
			System.out.println(max);
			System.out.println(min);
			
			
		}
			
	}

}
