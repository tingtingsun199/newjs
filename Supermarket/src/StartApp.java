import javax.swing.UIManager;

import com.sxt.supermarket.view.LoginFrame;

/**
 * ������
 * @author lenovo
 *
 */
public class StartApp {
	public static void main(String[] args) {
		//Ӧ�ó���ĳ�ʼ������
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		//��ʼ����
		new LoginFrame();
	}
 
	
	
}
