package test.mypac;

public class MyUtil {
	private String owner="김구라";
	
	private void test() {
		System.out.println("MyUtil 테스트 중입니다.");
	}
	
	public class User{
		public void doSomething() {
			System.out.println(MyUtil.this.owner);
			MyUtil.this.test();
			
			System.out.println(owner);
			test();
			
			MyUtil a=MyUtil.this;
			User b=this;
		}
	}
}
