package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/* 
 * 접속 ip 주소 : 14.63.164.99
 * 아이디 : acorn01
 * 비밀번호 : tiger01
 * 
 * 위의 DB에 접속해서
 * emp 테이블의 내용중에서 사원번호(empno), 사원이름(ename), 부서번호(deptno)를 select해서 콘솔창에 출력해 보세요.
 * 
 * 단, 사원번호에 대해서 오름차순 정렬하세요.
 */
public class MainClass02 {
	public static void main(String[] args) {
		
		//DB 연동 및 접속, 객체의 참조값을 얻어오는 코딩
		
		Connection conn=null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@14.63.164.99:1524:xe";
			//DB에 접속하고 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "acorn01", "tiger01");
			System.out.println("Oracle DB 접속 성공");
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		//Member 테이블의 내용을 select 해서 console에 출력해보기
		
		//왜 try catch 문 밖에 선언 했는가?
		//sql 문을 대신 실행해주는 preparedStatement 객체 선언 및 기본값 null 넣어주기.
		PreparedStatement pstmt=null;
		//sql 문의 수행결과 row를 받아 줄 Result 객체 선언 및 기본값 null 넣어주기.
		ResultSet rs=null;
		
		try {
			//실행하고자하는 spl문 입력
			String sql="SELECT empno, ename, deptno FROM emp ORDER BY empno ASC";
			/*
			 * Connection 객체의 참조값이 담긴 conn의 prepareStatement 메소드 호출.
			 * (preparedStatement-sql 문을 대신 실행)
			 * pstmt에 참조값 대입.
			 */
			pstmt=conn.prepareStatement(sql);
			
			/* 
			 * SELECT문(sql) 수행하고 결과 row를 ResultSet(rs) 객체로 받아오기
			 * executeQuery();는 데이터의 SELECT된 결과를 담은 ResultSet을 리턴한다. 
			 * * 결과값은 테이블형식(컬럼과 로우)로 구성이 된다. *
			 */
			rs=pstmt.executeQuery();
			
			while(rs.next()) {//next() 커서가 위치한 곳에서 row 데이터를 읽어내겠다.
				
				/*
				 * 결과 row가 담긴 rs를 이용해서 
				 * TYPE 변수명=rs.getTYPE("칼럼명"); ? 질문 getActionCommand?
				 * 칼럼의 값 타입 맞춰서 얻어내기
				 */
				
				//현재 커서가 위치한 곳에서 empno 칼럼의 값을 정수로 얻어내기
				int empno=rs.getInt("empno");
				//현재 커서가 위치한 곳에서 ename 칼럼의 값을 문자열로 얻어내기
				String ename=rs.getString("ename");
				//현재 커서가 위치한 곳에서 deptno 칼럼의 값을 정수로 얻어내기
				int deptno=rs.getInt("deptno");
				//변수와 구분자를 이용해서 결과값을 콘솔창에 출력
				System.out.println(empno+" | "+ename+" | "+deptno);
			}
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				/* 설명 주석 참고 */
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			}catch(Exception e) {
				
			}
		}
		
		System.out.println("main 메소드가 종료 됩니다.");
		
	}
}
/* 
 * if문으로 null인지 아닌지 구분하고 닫는 이유.
 * 
 * if(rs!=null)rs.close();
 * if(pstmt!=null)pstmt.close();
 * if(conn!=null)conn.close();
 * 
 * rs=pstmt.executeQuery(); 수행하다가 예외가 발생.(ex. 오타발생)
 * 그러면 rs가 null인 상태. 예외가 발생하면 catch로 간다. 예외정보를 출력.
 * catch를 지나서 finally 로 이동.
 * rs의 메소드를 호출하려고 하는데 참조값이 없으면 nullpointException(예외)이 발생한다.
 * 그러면 실행순서가 다시  catch로 뛰어버림.
 * 다른 마무리 작업은 실행을 못하게 된다. 
 * (ex. if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();)
 * 
 * 그러므로 작업을 하다가 어떤 객체가 null인지 아닌지 확인을 해야하는 상황이 있을 때는
 * 꼭 if문으로 nullpointException을 방지 해준다.
 */
