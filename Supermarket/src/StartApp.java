import javax.swing.UIManager;

import com.sxt.supermarket.view.LoginFrame;

/**
 * 启动类
 * @author lenovo
 *
 */
public class StartApp {
	public static void main(String[] args) {
		//应用程序的初始化工作
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		//开始启动
		new LoginFrame();
	}
 
	
	
}
