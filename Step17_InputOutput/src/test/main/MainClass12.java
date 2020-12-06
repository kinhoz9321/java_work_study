package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/*
 * 1. c:/myFolder/memo.txt 파일을 만들고
 * 2. "김구라" "해골" "원숭이" "주뎅이" "덩어리" 문자열을 파일에 출력하기
 */
public class MainClass12 {
	public static void main(String[] args) {
		File f=new File("c:/myFolder2/memo.txt");
		
		try {
			
			if(f.exists()) {
			f.createNewFile();
			System.out.println("memo.txt 파일을 생성했습니다.");
			}
			
			FileWriter fw=new FileWriter(f);
			fw.write("김구라");
			fw.write("\r\n");
			fw.write("해골");
			fw.write("\r\n");
			fw.write("원숭이");
			fw.write("\r\n");
			fw.write("주뎅이");
			fw.write("\r\n");
			fw.write("덩어리");
			fw.flush();//?
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
