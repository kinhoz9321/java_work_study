package test.frame02;
/*
 * JFrame 상속 받고
 * ActionListener 구현.
 * 강제 오버라이드 된 actionPerformed 메소드에서
 * getActionCommand()를 사용해 객체의 문자열을 참조한다. 
 * 
 * ActionListener 사용 7 (6과 비교해보기)
 * 
 * 6과 다른 점.
 * implements 를 했기 때문에 new ActionListener()를 하지 않았다.
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame7 extends JFrame implements ActionListener{
	
	public MainFrame7(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		JButton sendBtn=new JButton("전송");
		JButton updateBtn=new JButton("수정");
		JButton deleteBtn=new JButton("삭제");
		
		add(sendBtn);
		add(updateBtn);
		add(deleteBtn);
		
		//버튼에 리스너 등록하기
		sendBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		//버튼에 setActionCommand 지정
		sendBtn.setActionCommand("send");
		updateBtn.setActionCommand("update");
		deleteBtn.setActionCommand("delete");
	}
	
	public static void main(String[] args) {
		MainFrame7 f=new MainFrame7("메인 프레임7");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	/*
	 * 필드 ActionListener를 implements 해서 
	 * 강제 오버라이드 된 actionPerformed 메소드 재정의
	 * getActionCommand()메소드 사용 
	 * if문 사용
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command=e.getActionCommand();
		
		if(command.equals("send")) {
			JOptionPane.showMessageDialog(this, "전송 버튼을 눌렀습니다.");
		}else if(command.equals("update")){
			JOptionPane.showMessageDialog(this, "수정 버튼을 눌렀습니다.");
		}else if(command.equals("delete")){
			JOptionPane.showMessageDialog(this, "삭제 버튼을 눌렀습니다.");
		}
	}
	
}
/*
 * 안드로이드도 이것과 다르지 않다.
 * 클래스명과 인터페이스 명이 다를 뿐, 비슷하다고 보면 된다.
 * main 클래스를 제외한 것들은 mainFrame7 객체의 설계도이다.
 * main 클래스는 run 했을 때의 도입점.
 */
