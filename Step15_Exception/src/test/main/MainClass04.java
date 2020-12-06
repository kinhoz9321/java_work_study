package test.main;

import java.util.Scanner;

public class MainClass04 {
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("나눌 수 입력 :");
		String inputNum1=scan.nextLine();
		System.out.println("나누어지는 수 입력:");
		String inputNum2=scan.nextLine();
		
		try {
			
			//입력한 숫자형식의 문자열을 실제 정수로 바꾸기
			int num1=Integer.parseInt(inputNum1);
			int num2=Integer.parseInt(inputNum2);
			
			//정수를 정수로 나누면 소수점은 짤리고 정수만 남는다 (나눈 몫이 구해진다)
			int result=num2/num1;
			int result2=num2%num1; //나머지 연산자를 이용해서 나눈 나머지 값을 구한다.
			
			System.out.println(num2+" 를 "+num1+" 으로 나눈 몫은 "+result);
			System.out.println(num2+" 를 "+num1+" 으로 나눈 나머지는 "+result2);
			
		}catch(NumberFormatException nfe) {
			
			//nfe.printStackTrace();
			System.out.println("숫자 형식에 맞게 입력 하세요!");
			
		}catch(ArithmeticException ae) {
			
			//ae.printStackTrace();
			System.out.println("0이외의 숫자를 입력 하세요!");
			
		}catch(Exception e) { //위에 두가지를 제외한 예외가 발생하면 실행되는 블럭
			
			e.printStackTrace();
			
		}finally {
			
			System.out.println("마무리 작업을 합니다.");
			
		}
		
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
/* 
 * try catch 문법의 완성
 * Exception finally 추가
 * finally 를 쓸 때도 try 가 있어야 한다. 
 * 
 * [try]
 * 그저 처리할 예외가 발생할지도 모를 코드 블록을 정의하는 역할
 * [catch]
 * 예외가 발생할 경우 호출되는 문장 블록
 * [finally]
 * 앞서 try 블록에서 일어난 일에 관계없이 항상 실행이 보장되어야 할 뒷정리용 코드가 포함됩니다.
 */