package test.frame01;
/*
 * 프레임에 버튼 만들기2
 * 눌러봐 버튼을 누르면 알림창과 콘솔창에 눌렀다! 메세지 띄우기.
 * 메롱 버튼을 누르면 알림창에 약올리지마! 메세지 띄우기.
 * 
 * main 메소드 안에서 객체를 모두 생성하고 ActionListener로 생성.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainClass2 {
	public static void main(String[] args) {
		//프레임(창) 생성
		JFrame f=new JFrame();
		
		//제목
		f.setTitle("나의 프레임");
		
		//크기
		f.setSize(500, 300);
		
		//위치
		f.setLocation(100, 100);
		
		/*
		 * 창닫기(X)를 누르면 자동으로 프로세스가 종료되도록 설정
		 * 이걸 설정하지 않으면 창을 닫아도 프로세스가 종료되지 않는다.
		 */
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//배치 매니저를 사용하지 않겠다 (절대 좌표에 절대 크기로 배치)
		f.setLayout(null);
		
		//버튼 객체 생성
		JButton btn=new JButton("눌러봐");
		
		//버튼의 위치와 크기 지정 (x, y, width, height)
		btn.setBounds(10, 10, 100, 40);
		
		//프레임에 버튼 추가하기
		f.add(btn);
		
		//프레임을 보이게 할지 결정 (true-보이게 한다, false-안보이게 한다))
		f.setVisible(true);
		
		//ActionListener 인터페이스 type의 참조값 얻어내기
		ActionListener listener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("눌렀다!");
				/*
				 * JOptionPane 클래스에 static 메소드를 이용해서 알림창 띄우기
				 * .showMessageDialog (프레임의 참조값, 띄울 문자열)
				 */
				JOptionPane.showMessageDialog(f, "눌렀다!");
			}
		};
		
		//버튼에 액션 리스너 등록하기
		btn.addActionListener(listener);
		
		//"메롱!" 버튼 추가하기
		JButton btn2=new JButton("메롱!");
		btn2.setBounds(160, 10, 100, 40);
		f.add(btn2);
		
		ActionListener joke=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "약올리지마!");
			}
		};
		
		//버튼에 액션 리스너 등록하기
		btn2.addActionListener(joke);
		
		//람다식 (애로우 표현식) 사용법
//		btn2.addActionListener((e)->{
//			JOptionPane.showMessageDialog(f, "약올리지마!");
//		});
	}
}