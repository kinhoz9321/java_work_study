package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MainClass04 {
	public static void main(String[] args) {
		PrintStream ps=System.out;
		
		OutputStream os=ps;
		
		try {
			
			os.write(65);
			os.write(66);
			os.write(67);
			os.flush();//방출 .flush() 하는 시점에 출력된다.
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
}
