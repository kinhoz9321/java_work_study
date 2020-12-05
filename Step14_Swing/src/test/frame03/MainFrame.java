package test.frame03;
/* 
 * 텍스트 필드에 입력한 텍스트를 알림창으로 출력하기
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener{
	//필드 - 텍스트필드의 참조값을 필드에 저장
	JTextField inputText;
	
	//생성자
	public MainFrame(String title) {
		super(title);
		/*
		 * BorderLayout()
		 * - 컨테이너를 North, South, East, West, Center 
		 * 모두 5개의 영역으로 나누고, 
		 * 각 영역에 하나의 컴포넌트만을 배치할 수 있도록 한다.
		 * 
		 * BorderLayout()을 하지 않으면 프레임에 배경색이 꽉 차지 않는다.
		 */
		setLayout(new BorderLayout());
		
		//this는 생략 가능
		this.inputText=new JTextField(10);
		JButton sendBtn=new JButton("전송");
		
		JPanel panel=new JPanel();
		
		panel.add(inputText);
		panel.add(sendBtn);
		
		panel.setBackground(Color.YELLOW);
		
		add(panel, BorderLayout.NORTH);
		
		//버튼에 리스너 등록하기
		sendBtn.addActionListener(MainFrame.this);//this가능
	}
	
	//main 프레임
	public static void main(String[] args) {
		MainFrame f=new MainFrame("메인 프레임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	//ActionListener 재정의 /*MainFrame.this.*/ = 생략가능
	@Override
	public void actionPerformed(ActionEvent e) {
		//1. JTextField 에 입력한 문자열을 읽어와서
		String msg=/*MainFrame.this.*/inputText.getText();
		
		//2. 알림창에 출력한다.
		JOptionPane.showMessageDialog(MainFrame.this, msg);//this 가능
	}
}
/*
 * UI로 사용하는 것들의 부모에는 모두 Component 가 있다.
 * ex) JFrame, JTextField, JButton, JPanel ...
 *
 * [중요했던 과정 정리!]
 * 
 * 1. 필드 생성
 * JTextField inputText;
 * 
 * 2. 버튼에 리스너 등록하기
 * sendBtn.addActionListener(this);
 * 
 * 3. 오버라이드 채워넣기
 * @Override
	public void actionPerformed(ActionEvent e) {
		//1. JTextField 에 입력한 문자열을 읽어와서
		String msg=this.inputText.getText();
		
		//2. 알림창에 출력한다
		JOptionPane.showMessageDialog(this, msg);
	}
 */
