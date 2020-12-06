package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass05 {
	public static void main(String[] args) {
		PrintStream ps=System.out;
		
		OutputStream os=ps;
		OutputStreamWriter osw=new OutputStreamWriter(os);
		
		try {
			osw.write("안녕하세요!");
			osw.write("\r\n");//개행기호
			osw.write("어쩌구");
			osw.write("\r\n");//개행기호 둘중에 하나만 써도 되는데 어떤 곳에서는 \r\n둘다 써야하는 곳도 있다. 그래서 둘 다 붙여쓰면 더 좋음.
			osw.write("저쩌구");
			osw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
