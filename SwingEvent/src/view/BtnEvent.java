package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * �¼�������
 * @author lenovo
 *
 */
public class BtnEvent implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("btn1")){
			System.out.println("���˧");
		}else if(e.getActionCommand().equals("btn2")){
			System.out.println("�����");
		}
		
		
		
		
	}

}
