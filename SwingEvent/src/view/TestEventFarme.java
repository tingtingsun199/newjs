package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TestEventFarme extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestEventFarme frame = new TestEventFarme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestEventFarme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("1");
		
		//
		
		
		btn1.setActionCommand("btn1");
		btn1.addActionListener(this);
		btn1.setBounds(137, 53, 93, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("New button");
		btn2.setActionCommand("btn2");
		btn2.addActionListener(this);
		
		
		btn2.setBounds(137, 138, 93, 23);
		contentPane.add(btn2);
	}
	

public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("btn1")){
		System.out.println("ƒ„∫√Àß");
	}else if(e.getActionCommand().equals("btn2")){
		System.out.println("ƒ„∫√√¿");
	}
}
}
	
	
	
	
