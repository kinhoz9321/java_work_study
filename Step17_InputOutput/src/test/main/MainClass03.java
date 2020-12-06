package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		
		InputStream kbd=System.in;
		InputStreamReader isr=new InputStreamReader(kbd);
		
		BufferedReader br=new BufferedReader(isr);
		
		try {
		
			System.out.print("문자열 입력(문장 가능):");
			String line=br.readLine();
			System.out.println("line:"+line);
			
		}catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		System.out.println("main 메소드가 종료됩니다.");
		
	}
}
/* 
 * BufferedReader(Reader) 리더는 인풋스트림 리더의 어미타입
 * 
 * Scanner 똑같은 효과를 내지만 트라이캐치로 묶지 않아도 됨.
 */