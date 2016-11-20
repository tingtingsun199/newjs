import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestRegex1 {
	private void man() {
		String phone="123-4567891";
		
		String regexText="[0-9]{3}-[0-9]{8}";
		//通过正则表达式创建一个模板
		Pattern pattern=Pattern.compile(regexText);
		//匹配这个电话是否符合这个模板的格式
		Matcher m=pattern.matcher(phone);
		boolean ok=m.matches();
		System.out.println(ok);
		
	
	
	
	
	
	}

}
