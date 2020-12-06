package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		String[] names= {"김구라", "해골", "원숭이", "주뎅이", "덩어리"};
		//names에 저장된 문자열을 순서대로 콘솔창에 출력하기
		for(int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
		
		//강사님 풀이
		for(int i=0; i<names.length; i++) {
			String tmp=names[i];
			System.out.println(tmp);
		}
	}
}
/*
 * <강사님 풀이 분해해보기!>
 * for(int i=0; i<names.length; i++) {
 * 
 * 			//names.length의 크기를 리턴해준다.
			이게 뭐지 왜 적었지?
			String tmp=names[i];
			"Temporary(일시적인, 임시적인)"
			
			//syso을 적어주지 않으면 숫자만 쌓이다가 사라진다.
			 디버그에도 아무 일이 일어나지 않음.
			System.out.println(tmp);
		}
 */
