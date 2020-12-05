package test.frame06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/* 
 * 랜덤하게 숫자를 얻어낼 수 있는 버튼을 만들어서
 * 버튼을 누르면 정해진 숫자 범위 안에서
 * 알림창에 랜덤한 숫자가 나오는 프레임 만들어보기
 */
public class MainFrame extends JFrame implements ActionListener{
	
	//생성자
	public MainFrame(String title) {
		super(title);
		setLayout(new FlowLayout());
		JButton getBtn=new JButton("0~9 랜덤 정수 얻어내기");
		add(getBtn);
		getBtn.addActionListener(this);
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame f=new MainFrame("랜덤 프레임");
		f.setBounds(100, 100, 300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	//ActionListener 재정의
	@Override
	public void actionPerformed(ActionEvent e) {
		//랜덤한 값을 얻어내기 위한 객체 생성
		Random ran=new Random();
		//0~9사이의 랜덤한 정수
		int ranNum=ran.nextInt(10);
		JOptionPane.showMessageDialog(this, "발생된 랜덤 정수:"+ranNum);
	}
}
