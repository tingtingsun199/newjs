import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * ������
 * @author wenber
 *
 */
public class Frame extends JFrame{
	
	public Frame() {
		
		//���ô�С
		this.setSize(400, 300);
		//����λ��
		this.setLocationRelativeTo(null);
		
		//���ò���[xy ���Բ���]
		this.setLayout(null);
		//���һ����ť
		JButton btn=new JButton("����һ������İ�ť");
		//���ð�ť��λ�úʹ�С
		btn.setBounds(10, 10, 180, 50);
		//����ť��ӵ����������
		this.getContentPane().add(btn);
		
		//�ɼ�
		this.setVisible(true);
	}

}
