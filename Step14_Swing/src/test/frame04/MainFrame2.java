package test.frame04;
/*
 * 텍스트필드에 문자를 입력하고
 * "엔터키"를 누르면
 * 입력한 문자가 프레임 레이블에 나타나게 만들기
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame2 extends JFrame implements ActionListener, KeyListener{
	
	//필드
	JTextField inputText;
	JLabel label;
	
	//생성자
	public MainFrame2(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		JPanel panel=new JPanel();
		inputText=new JTextField(10);
		JButton sendBtn=new JButton("전송");
		label=new JLabel();
		
		panel.setBackground(Color.YELLOW);
		
		panel.add(inputText);
		panel.add(sendBtn);
		panel.add(label);
		
		add(panel, BorderLayout.NORTH);
		
		/*
		 * 버튼에 ActionListener 등록하기 
		 * 텍스트 필드에 KeyListener 등록하기 
		 */
		sendBtn.addActionListener(MainFrame2.this);
		inputText.addKeyListener(MainFrame2.this);
	}
	
	//메인 메소드
	public static void main(String[] args) {
		MainFrame2 f=new MainFrame2("메인 메소드");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	//KeyListener 인터페이스 메소드 재정의
	//키를 눌렀을 때 호출되는 메소드
	@Override
	public void keyPressed(KeyEvent e) {
		//눌러진 키의 코드값 읽어오기
		int code=e.getKeyCode();
		//만일 엔터키를 누른다면
		if(code==KeyEvent.VK_ENTER){
			//1.JTextField에 입력한 문자열을 읽어와서
			String msg=MainFrame2.this.inputText.getText();
			//2. 레이블에 출력한다
			label.setText(msg);
			//3. 입력창 빈공간 만들기
			inputText.setText("");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	//ActionListener 인터페이스 메소드 재정의
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String msg=inputText.getText();
		label.setText(msg);
		inputText.setText("");
	}
	
	
}
