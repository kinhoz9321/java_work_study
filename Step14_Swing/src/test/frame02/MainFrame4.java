package test.frame02;
/*
 * JFrame을 상속받아서
 * * 필드에 ActionListener 생성 * 익명의 클래스로 메소드 재정의 하기.
 * 생성자에서 버튼에 ActionListener 등록하기 4
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame4 extends JFrame{
	
	//필드에 ActionListener 생성 익명의 클래스로 메소드 재정의 하기
	ActionListener sendListener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(MainFrame4.this, "전송 버튼을 눌렀습니다.");
		}
	};
	
	ActionListener updateListener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(MainFrame4.this, "수정 버튼을 눌렀습니다.");
		}
	};
	
	ActionListener deleteListener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(MainFrame4.this, "삭제 버튼을 눌렀습니다.");
		}
	};
	
	public MainFrame4(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		JButton sendBtn=new JButton("전송");
		JButton updateBtn=new JButton("수정");
		JButton deleteBtn=new JButton("삭제");
		
		add(sendBtn);
		add(updateBtn);
		add(deleteBtn);
		
		//필드에 저장된 ActionListener 버튼에 등록하기
		sendBtn.addActionListener(sendListener);
		updateBtn.addActionListener(updateListener);
		deleteBtn.addActionListener(deleteListener);
	}
	
	public static void main(String[] args) {
		MainFrame4 f=new MainFrame4("메인 프레임3");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
