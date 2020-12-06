package test.main;

import java.io.File;

public class MainClass09 {
	public static void main(String[] args) {
		File myFile=new File("c:/myFolder2");
		
		if(!myFile.exists()) {
			
			myFile.mkdir();
			System.out.println("c:/myFolder2를 생성했습니다.");
			
		}else {
			
			System.out.println("c:/myFolder2는 이미 존재합니다.");
			
		}
		System.out.println("main 메소드가 종료됩니다.");
	}
}
