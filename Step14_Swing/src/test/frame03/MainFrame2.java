package test.frame03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame2 extends JFrame implements ActionListener{
	//필드
	JTextField inputText;
	
	//생성자
	public MainFrame2(String title) {
		super(title);
		
		//레이아웃 매니저 설정
		setLayout(new BorderLayout());
		
		//텍스트 필드와 버튼 객체 만들기
		this.inputText=new JTextField(10);
		JButton sendBtn=new JButton("전송");
		
		//패널 객체 생성하기
		JPanel topPanel=new JPanel();
		
		//패널에 텍스트 필드와 버튼을 추가하기
		topPanel.add(inputText);
		topPanel.add(sendBtn);
		
		//패널에 배경색 지정하기
		topPanel.setBackground(Color.YELLOW);
		
		//패널 째로 프레임의 북쪽에 배치하기
		add(topPanel, BorderLayout.NORTH);
		
		//버튼에 리스너 등록하기
		sendBtn.addActionListener(this);
	}
	
	//run 했을 때 실행순서가 시작되는 main 메소드
	public static void main(String[] args) {
		MainFrame2 f=new MainFrame2("메인 프레임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	//ActionListener - actionPerformed(버튼클릭 시에 발동 되는 메소드)
	@Override
	public void actionPerformed(ActionEvent e) {
		//1. JTextField 에 입력한 문자열을 읽어와서
		String msg=this.inputText.getText();
		//2. 알림창에 출력한다 
		JOptionPane.showMessageDialog(this, msg);
	}
	
}
