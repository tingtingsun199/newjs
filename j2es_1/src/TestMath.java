/**
 * 
 * @author lenovo
 *
 */

public class TestMath {
	public static void main(String[] args) {
		//输入四个数字
		java.util.Scanner sc=new java.util.Scanner(System.in);
		String number=sc.next();
		//转成数组
		char[] ch=number.toCharArray();
		//排序
		java.util.Arrays.sort(ch);
		//开始减while
		while(true){
			//转成数组
			char[] ch=number.toCharArray();
			//排序
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
