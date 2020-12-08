package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

/* 
 * member 테이블에서
 * 회원번호가 801번 회원의 정보를 삭제하는 기능을 완성해보기.
 */
public class MainClass05 {
	public static void main(String[] args) {
		//삭제할 회원의 번호
		int num=801;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		int flag=0;
		
		try {
			conn=new DBConnect().getConn();
			String sql="DELETE FROM member WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보를 삭제 했습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch (Exception e) {

			}
		}
	if(flag>0) {
		System.out.println("작업(DELETE) 성공");
	}else {
		System.out.println("작업 (DELETE) 실패");
	}
	
	}
}
