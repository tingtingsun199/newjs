import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestRegex1 {
	private void man() {
		String phone="123-4567891";
		
		String regexText="[0-9]{3}-[0-9]{8}";
		//ͨ��������ʽ����һ��ģ��
		Pattern pattern=Pattern.compile(regexText);
		//ƥ������绰�Ƿ�������ģ��ĸ�ʽ
		Matcher m=pattern.matcher(phone);
		boolean ok=m.matches();
		System.out.println(ok);
		
	
	
	
	
	
	}

}
