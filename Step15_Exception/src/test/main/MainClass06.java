package test.main;
/* 
 * 스레드를 이용해서 1초마다 숫자가 출력되게 만들기
 */
public class MainClass06 {
	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			System.out.println(i);
			try {
//				System.out.println(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
