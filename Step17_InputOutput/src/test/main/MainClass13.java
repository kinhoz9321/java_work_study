package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * c:/myFolder/memo.txt 파일에 저장된 문자열을 읽어와서
 * 콘솔창에 출력하는 코드를 작성해보세요.
 * 
 * hint) -> new FileReader() 파일의 문자열을 읽어들이는 메소드
 * hint) -> new BufferReader()
 */
public class MainClass13 {
	public static void main(String[] args) throws IOException {
		File f=new File("c:/myFolder2/memo.txt");
		try {
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			
			while(true) {
				String line=br.readLine();
				//readLine() 메소드가 null을 리턴하면 반복문 탈출하기
				if(line==null) {
					break;
				}
				//이게 밖으로 나와야 한다.
				System.out.println(line);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
