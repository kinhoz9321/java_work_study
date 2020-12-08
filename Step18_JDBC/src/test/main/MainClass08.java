package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import test.member.dto.MemberDto;
import test.util.DBConnect;

/* 
 * Scanner 객체를 이용해서 검색할 회원의 정보를 입력 받아서 
 * 입력 받은 숫자를 이용해서 SELECT 문을 수행하고
 * 결과값을 MemberDto 객체를 생성해서 담아보세요.
 * 
 * 결과가 없다면 MemberDto 객체를 생성하지 마세요. ( null 인 상태로 두기 )
 * 
 * 강사님 풀이
 */
public class MainClass08 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("검색할 번호 입력 : ");
		int num=scan.nextInt();
		
		MemberDto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT name, addr FROM member WHERE num=?";
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto=new MemberDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				
			}
	/*
	 * 위의 try~catch~finally 절이 수행된 후에 SELECT된 결과가 있는지 없는지를 
	 * 여기에서 쉽게 판별할 수 있는 방법이 있나요? 
	 * dto가 null 인지 아닌지 알면 된다. 
	 */
			if(dto==null) {
				System.out.println(num+" 번 회원은 존재하지 않습니다.");
			}else {
				System.out.println("번호 : "+dto.getName()+", 이름 : "+dto.getName()+", 주소 : "+dto.getAddr());
			}
		}
	}
}
