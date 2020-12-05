package test.frame01;
/*
 * MyFrame import.
 * 생성자에 모든 준비를 끝내놓았기 때문에 
 * new MyFrame()호출. 형태만 만들기.
 */
import test.mypac.MyFrame;

public class MainClass3 {
	public static void main(String[] args) {
		MyFrame mf=new MyFrame();
		
		mf.setTitle("나의 프레임");
		mf.setSize(500, 300);
		mf.setLocation(100, 100);
		mf.setVisible(true);
	}
}
