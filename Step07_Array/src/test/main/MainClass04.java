package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		
		//new int[5]가 뭐지요?
		int[] nums=new int[5];
		
		//new String[3]이 뭐지요?
		String[] names=new String[3];
		
		//미리 만들어진 배열에 item 저장하기
		nums[0]=10;
		nums[1]=20;
		nums[2]=30;
		
		names[0]="김구라";
		names[1]="해골";
		names[2]="원숭이";
	}
}
/*
 * 배열 객체를 먼저 생성하고 필요한 값을 나중에 집어넣고 싶을 때 쓰는 방법
 */