package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/* 
 * member 테이블에서
 * num이 804번인 회원의 
 * addr을 노량진으로 수정하는 코드를 작성해 보세요.
 */
public class MainClass04 {
	public static void main(String[] args) {
		int num=804;
		String addr="노량진";
		
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@14.63.164.99:1521:xe";
			conn=DriverManager.getConnection(url, "acorn01", "tiger01");
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			//미완성의 update 문
			String sql="UPDATE member SET addr=? WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, addr);//첫번째 물음표 바인딩 값은 필드에
			pstmt.setInt(2, num);//두번째 물음표 바인딩 값은 필드에
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보를 수정했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(pstmt!=null)conn.close();
			}catch(Exception e) {
				
			}
		}
		if(flag>0) {
			System.out.println("작업(UPDATE) 성공");
		}else {
			System.out.println("작업(UPDATE) 실패");
		}
	}
}
