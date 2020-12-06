package test.main;

import test.mypac.MyUtil;

public class MainClass08 {
	public static void main(String[] args) {
		MyUtil.draw();
		
		try {
			MyUtil.send();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * send를 MyUtil에서 묶지 않았기 때문에. 
		 * 결국 이곳에서 묶게 되었다. 
		 * throw하게 되면 결국 어디에선가 묶게 된다.
		 */
	}
}
