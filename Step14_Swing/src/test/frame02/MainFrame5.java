package test.frame02;
/*
 * JFrame 상속받고
 * *필드에 ActionListener 람다식으로 생성*
 * 생성자에서 버튼에 ActionListener 등록 5
 * 
 * 람다식 생성이 특이하니 주의깊게 보길 바람.
 */
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainFrame5 extends JFrame{
	
	//필드 ActionListener 람다식으로 생성
	ActionListener sendListener=(e)->{
		JOptionPane.showMessageDialog(MainFrame5.this, "전송 버튼을 눌렀습니다.");
	};
	
	ActionListener updateListener=(e)->{
		JOptionPane.showMessageDialog(MainFrame5.this, "수정 버튼을 눌렀습니다.");
	};
	
	ActionListener deleteListener=(e)->{
		JOptionPane.showMessageDialog(MainFrame5.this, "삭제 버튼을 눌렀습니다.");
	};
	
	//생성자
	public MainFrame5(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		JButton sendBtn=new JButton("전송");
		JButton updateBtn=new JButton("수정");
		JButton deleteBtn=new JButton("삭제");
		
		add(sendBtn);
		add(updateBtn);
		add(deleteBtn);
		
		//버튼에 ActionListener 등록
		sendBtn.addActionListener(sendListener);//this 생략 this가 뭐지?
		updateBtn.addActionListener(updateListener);
		deleteBtn.addActionListener(deleteListener);
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame5 f=new MainFrame5("메인 프레임5");
		f.setBounds(100, 100, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
