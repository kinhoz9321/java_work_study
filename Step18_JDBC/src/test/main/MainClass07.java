package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import test.member.dto.MemberDto;
import test.util.DBConnect;

/* 
 * Scanner 객체를 이용해서 검색할 회원의 정보를 입력 받아서 
 * 입력 받은 숫자를 이용해서 SELECT 문을 수행하고
 * 결과값을 MemberDto 객체를 생성해서 담아보세요.
 * 
 * 결과가 없다면 MemberDto 객체를 생성하지 마세요. ( null 인 상태로 두기 )
 */
public class MainClass07 {
	public static void main(String[] args) {
		//1. Scanner 객체를 이용해서 검색할 회원의 정보를 입력 받기
		Scanner scan=new Scanner(System.in);
		System.out.println("검색할 회원번호 입력 : ");
		//2. 입력받은 '숫자'를 이용
		int num=scan.nextInt();
		
		//3. SELECT 문을 수행하기. 우선, DB연동, 기본값을 담은 객체 생성 필요. 
		MemberDto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT name, addr FROM member WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				dto=new MemberDto(num, name, addr);
			}else {
				dto=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} 
		}
		
		
	}
}
