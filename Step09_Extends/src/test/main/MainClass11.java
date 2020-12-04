package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass11 {

	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		
		/* 
		 * 콘솔창을 확인해서 부모객체가 미리 만들어지는 것을 확인하세요.
		 */
		
		Phone p1=new Phone();
		Phone p2=new HandPhone();
		Phone p3=new SmartPhone();
		
		Object p4=new SmartPhone();
		Phone p5=new SmartPhone();
		
		System.out.println("main 메소드가 종료되었습니다.");
	}

}
/* 
호출의 순서가 
Phone 
HandPhone
SmartPhone 
순서.

부모객체가 먼저 만들어진다는 소리.
 */