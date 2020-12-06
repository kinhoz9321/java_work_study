package test.main;

import java.util.Scanner;

public class MainClass01_2 {
	public static void main(String[] args) {
		
		//키보드로 입력받는 코드
		Scanner scan=new Scanner(System.in);
		System.out.println("숫자 입력 : ");
		
		//숫자를 문자열 형식으로 입력받는다. "10", "20" 등...
		String inputNum=scan.nextLine();
		
		//1. try 블럭을 실행하다가
		try {
		//입력한 숫자를 실제 숫자로 바꾸기 (산술연산을 가능하게 해주는 메소드)
		double num=Double.parseDouble(inputNum);
		double result=num+100;
		System.out.println("입력한 숫자+100 :"+result);
		
		//nfe type의 예외가 발생하면 여기가 실행된다.
		}catch(NumberFormatException nfe) {// NumberFormatException type의 예외가 발생하면 여기가 실행된다.
			
			System.out.println("숫자 형식에 맞게 입력 하세요!");
			
			//예외 객체의 메소드를 이용해서 stack에 일어난 일을 콘솔에 출력하기.
			nfe.printStackTrace();
		}
		System.out.println("main 메소드가 종료됩니다.");
	}
}
/*
 * exception 예외
 * ex)숫자를 문자열로 입력을 받을 때 천, 백으로 치면 NumberFormatException이 발생한다.
 * 
 * JVM(Java Virtual Machine) - 자바 가상 머신
 * 예외가 생기면 자바 가상 머신이 실행순서를 다른 곳으로 건너뛰어버린다.
 * 우리가 예외를 처리하면 실행순서가 다른 곳으로 건너뛰어버리는 것을 방지할 수 있다.
 * 우리가 원하는 곳으로 실행순서를 보낼 수 있다. (컨트롤 가능)
 * 
 * try{}catch(exception){} 문법
 * 예외를 잡아낼 곳이 많기 때문에 자주쓰인다. 반드시 알아둘 것.
 */