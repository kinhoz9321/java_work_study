package test.main;

import java.util.HashMap;
import java.util.Map;

public class MainClass02_2 {

	public static void main(String[] args) {

		int num=1;
		String name="김구라";
		String addr="노량진";
		boolean isMan=true;
		
		//new HashMap<String, Object>(); -> String, Ojbect 생략 가능. 
		//제너릭은 타입을 받아줄 때만 잘 받으면 된다.
		Map<String, Object> map1=new HashMap<String, Object>();
		//HashMap 객체를 생성해서 Map 인터페이스로 받은 모습
		
		map1.put("num", num);
		map1.put("name", name);
		map1.put("addr", addr);
		map1.put("isMan", isMan);
		
		int a=(int)map1.get("num");
		String b=(String)map1.get("name");
		String c=(String)map1.get("addr");
		boolean d=(boolean)map1.get("isMan");
		
		int size=map1.size(); 
		
		map1.remove("addr");
		
		map1.clear();
	}

}
