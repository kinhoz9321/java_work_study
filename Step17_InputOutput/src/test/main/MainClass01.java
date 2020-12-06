package test.main;

import java.io.IOException;
import java.io.InputStream;

public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		
		InputStream kbd=System.in;
		
		try {
			
		System.out.print("문자 1개 입력:");
		int code=kbd.read();
		System.out.println("code:"+code);
		
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
