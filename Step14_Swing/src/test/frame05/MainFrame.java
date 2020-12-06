package test.frame05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/* 계산기 1
 * 
 * 사칙연산이 가능한 계산기를 만들어보세요.
 * TextField (10) 2개
 * 사칙연산 버튼 4개
 * =,result 레이블 2개
 * 
 * 사칙연산의 버튼을 누르면 result 레이블에 결과값 출력되게 만들기
 * 
 * hint double num1=Double.parseDouble(inputNum1.getText());
 * 
 * 필드에 ActionListener 객체 생성
 */
public class MainFrame extends JFrame{
	//필드
	JTextField inputNum1;
	JTextField inputNum2;
	JLabel result;
	
	//생성자
	public MainFrame(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		inputNum1=new JTextField(10);
		inputNum2=new JTextField(10);
		
		JButton plusBtn=new JButton("+");
		JButton minusBtn=new JButton("-");
		JButton multipleBtn=new JButton("*");
		JButton divisionBtn=new JButton("/");
		
		JLabel label_eq=new JLabel("=");
		result=new JLabel();
		
		add(inputNum1);
		add(plusBtn);
		add(minusBtn);
		add(multipleBtn);
		add(divisionBtn);
		add(inputNum2);
		add(label_eq);
		add(result);
		
		plusBtn.addActionListener(plus);
		minusBtn.addActionListener(minus);
		multipleBtn.addActionListener(multiple);
		divisionBtn.addActionListener(division);
	}
	
	//main 메소드
	public static void main(String[] args) {
		MainFrame f=new MainFrame("계산기 프레임");
		f.setBounds(100, 100, 800, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	ActionListener plus=new ActionListener() {
		//plus 버튼을 누르면 inputNum1+inputNum2=result
		@Override
		public void actionPerformed(ActionEvent e) {
			double num1=Double.parseDouble(inputNum1.getText());
			double num2=Double.parseDouble(inputNum2.getText());
			Double r=num1+num2;
			result.setText(r.toString());
		}
	};
	
	ActionListener minus=new ActionListener() {
		//plus 버튼을 누르면 inputNum1+inputNum2=result
		@Override
		public void actionPerformed(ActionEvent e) {
			double num1=Double.parseDouble(inputNum1.getText());
			double num2=Double.parseDouble(inputNum2.getText());
			Double r=num1-num2;
			result.setText(r.toString());
		}
	};
	
	ActionListener multiple=new ActionListener() {
		//plus 버튼을 누르면 inputNum1+inputNum2=result
		@Override
		public void actionPerformed(ActionEvent e) {
			double num1=Double.parseDouble(inputNum1.getText());
			double num2=Double.parseDouble(inputNum2.getText());
			Double r=num1*num2;
			result.setText(r.toString());
		}
	};
	
	ActionListener division=new ActionListener() {
		//plus 버튼을 누르면 inputNum1+inputNum2=result
		@Override
		public void actionPerformed(ActionEvent e) {
			double num1=Double.parseDouble(inputNum1.getText());
			double num2=Double.parseDouble(inputNum2.getText());
			Double r=num1/num2;
			result.setText(r.toString());
		}
	};
}
