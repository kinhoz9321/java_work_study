package test.main;

import java.io.File;

public class MainClass10 {
	public static void main(String[] args) {
		for (int i=0; i<100; i++) {
			File tmp=new File("c:/myFolder2/gura"+i);
			tmp.mkdir();
		}
		System.out.println("오예~");
	}
}
