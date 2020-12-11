package test.main;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MainClass10 {
	public static void main(String[] args) {
		/*
		 * 추가할 회원의 정보가 아래와 같을 때 아래 회원의 정보를 
		 * member 테이블에 추가하려면?
		 */
		String name="섯거라";
		String addr="남구";
		
		MemberDao dao=new MemberDao();
		MemberDto dto=new MemberDto();
		
		dto.setName(name);
		dto.setAddr(addr);
		
		boolean isSuccess=dao.insert(dto);
		
		if(isSuccess) {
			System.out.println("성공!");
		}else {
			System.out.println("실패!");
		}
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
