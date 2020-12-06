package test.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* FileInputStream 객체를 이용해서
 * c:/myFolder/1.jpg 에서 byte 데이터를 읽어들여서
 * 
 * FileOutputStream 객체를 이용해서
 * c:/myFolder/copied.jpg 파일에 출력하기
 */
public class MainClass15 {
	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream(new File("c:/myFolder2/1.jpg"));
			fos=new FileOutputStream(new File("c:/myFolder2/copied.jpg"));
			
			while(true) {
				int data=fis.read();
				System.out.println(data);
				if(data==-1) {
					break;
				}
				fos.write(data);
				fos.flush();
			}
			System.out.println("파일을 성공적으로 복사 했습니다.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			}
			catch(Exception e) {
			
			}
		
		}
	}
}
