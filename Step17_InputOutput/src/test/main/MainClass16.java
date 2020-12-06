package test.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass16 {
	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		try {
			
			fis=new FileInputStream(new File("c:/myFolder2/1.jpg"));
			fos=new FileOutputStream(new File("c:/myFolder2/copied.jpg"));
			
			byte[] buffer=new byte[1024];
			
			while(true) {
				int readedcount=fis.read(buffer);
				if(readedcount==-1) {
					break;
				}
				fos.write(buffer, 0, readedcount);
			}
			System.out.println("파일을 성공적으로 복사했습니다.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			}catch(Exception e){
				
			}
		}
		
		
	}
}
