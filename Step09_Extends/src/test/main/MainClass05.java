package test.main;

import test.mypac.Phone;
import test.mypac.SmartPhone;

/*
 *   여러분이 키우는 자녀가 있다고 가정하자
 *   자녀가 현재 사용하는 핸드폰이 인터넷이 안되는 구형 폰이다.
 *   여러분의 자녀가 인터넷을 하고 싶어서 스마트폰이 갖고 싶다고 조른다. 
 *   여러분은 어떻게 할것인가?
 *   
 *   1. 스마트폰을 새로 사준다(만들어서 준다)
 *   
 *   2. 스마트폰의 사용설명서만 가지고 와서 현재 폰의 설명서라고 우기고 
 *      그냥 그폰을 쓰라고 한다.
 *   
 */

public class MainClass05 {

	public static void main(String[] args) {
		Phone p1=new Phone();
		
		/*
		 runtime 시에 ClassCastException이 발생한다.
		 위의 설명에서 2번과 같은 경우이다.
		 */
		SmartPhone p2=(SmartPhone)p1;
		
		p2.doInternet();
	}
//Phone p1=new SmartPhone(); 만약 p1을 스마트폰으로 생성했더라면 저 코딩은 가능했을 것이다. 
}
