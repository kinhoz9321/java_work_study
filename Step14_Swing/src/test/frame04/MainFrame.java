package test.frame04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * 텍스트필드에 문자를 입력하고
 * "전송버튼"을 누르면
 * 입력한 문자가 프레임 레이블에 나타나게 만들기
 */
public class MainFrame extends JFrame implements ActionListener{
	//필드 (ActionListener 에서 재정의 하기 편하도록 필드에 따로 빼둔다.)
	JTextField inputText;
	JLabel label;
	
	//생성자
	public MainFrame(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		inputText=new JTextField(10);
		JButton sendBtn=new JButton("전송");
		
		//JPanel 패널, JLabel 레이블 생성
		JPanel panel=new JPanel();
		label=new JLabel();
		
		panel.setBackground(Color.YELLOW);
		
		panel.add(inputText);
		panel.add(sendBtn);
		panel.add(label);
		
		add(panel, BorderLayout.NORTH);
		
		sendBtn.addActionListener(MainFrame.this);
	}
	
	//메인 메소드
	public static void main(String[] args) {
		MainFrame f=new MainFrame("메인 프레임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	//ActionListener 재정의
	@Override
	public void actionPerformed(ActionEvent e) {
		//1. JTextField에 입력한 문자열을 읽어와서
		String msg=inputText.getText();
		//2. label에 출력한다
		label.setText(msg);
	}
}
