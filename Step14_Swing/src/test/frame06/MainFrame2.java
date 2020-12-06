package test.frame06;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* 
 * 랜덤 객체를 이용해서
 * 가위 바위 보 게임기 만들어보기
 * 나:컴퓨터
 * 
 * 프레임
 * 버튼 가위, 바위, 보 3개
 * 누르면 팝업창띄우기
 * 팝업창 나:내가 고른 버튼 컴퓨터:랜덤
 * 이겼으면 이겼습니다, 졌으면 졌습니다. 승패 띄우기
 * 
 * 일시정지
 */
public class MainFrame2 extends JFrame{
	
	//필드
	JButton scissor;
	JButton rock;
	JButton paper;
	
	//생성자
	public MainFrame2(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		scissor= new JButton("가위");
		rock= new JButton("바위");
		paper= new JButton("보");
		
		JPanel panel=new JPanel();
		JPanel panel2=new JPanel();
		
		JLabel label=new JLabel("컴퓨터와의 대결 승리하세요!");
		
		panel.add(label);
		
		panel2.add(scissor);
		panel2.add(rock);
		panel2.add(paper);
		
		add(panel, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
	}
	
	//main메소드
	public static void main(String[] args) {
		MainFrame2 f=new MainFrame2("가위바위보 게임");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	//가위를 눌렀을 때 호출되는 메소드
	ActionListener sendS=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//랜덤 객체 생성
			Random comRan=new Random();
			
			//컴퓨터의 패로 사용할 값 0,1,2 중에 하나의 숫자를 랜덤하게 얻어내기 
			int ran=comRan.nextInt(3);
			
			String command=e.getActionCommand();
			
			
		}
	};
}
