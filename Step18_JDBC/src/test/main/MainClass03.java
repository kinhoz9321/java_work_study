package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass03 {
	public static void main(String[] args) {
		
		//아래의 정보를 member 테이블에 저장하고자 한다. num은 sequence로 집어넣기.
		String name="톰캣";
		String addr="건물 옥상";
		
		//이 코드가 필요한 궁극적인 목표 - connection의 참조값을 얻어오기 위함.
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@14.63.164.99:1521:xe";
			conn=DriverManager.getConnection(url, "acorn01", "tiger01");
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//INSERT 하기 위한 코드
		PreparedStatement pstmt=null;
		int flag=0;
		
		try {
			String sql="INSETR INTO member"
					+ "(num, name, addr)"
					+ "VALUES (member_seq.NEXTVAL, ?, ?)";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보를 저장 했습니다.");
		}catch(Exception e) {
			
		}
		
	}
}
