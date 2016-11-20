import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 窗口类
 * @author wenber
 *
 */
public class Frame extends JFrame{
	
	public Frame() {
		
		//设置大小
		this.setSize(400, 300);
		//设置位置
		this.setLocationRelativeTo(null);
		
		//设置布局[xy 绝对布局]
		this.setLayout(null);
		//添加一个按钮
		JButton btn=new JButton("这是一个神奇的按钮");
		//设置按钮的位置和大小
		btn.setBounds(10, 10, 180, 50);
		//将按钮添加到窗口面板中
		this.getContentPane().add(btn);
		
		//可见
		this.setVisible(true);
	}

}
