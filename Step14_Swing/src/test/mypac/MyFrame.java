package test.mypac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	//생성자
	public MyFrame() {
		this.setLayout(null);
		JButton btn=new JButton("눌러보셈");
		btn.setBounds(50, 50, 100, 40);
		this.add(btn);
		
		ActionListener listener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MyFrame.this, "눌렀냥!");
			}
		};
		btn.addActionListener(listener);
		JButton sendBtn=new JButton("전송");
		sendBtn.setBounds(200, 50, 100, 40);
		add(sendBtn);
		sendBtn.addActionListener(sendListener);
	}
	
	ActionListener sendListener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(MyFrame.this, "전송합니다.");
		}
	};
}
