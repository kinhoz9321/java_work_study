package test.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.member.dto.MemberDto;
import test.util.DBConnect;

/* 
 * 회원정보 (member 테이블)의 내용을
 * select
 * insert
 * update
 * delete
 * 작업을 할 객체를 생성할 클래스 설계하기
 * DBConnect localhost로 바꾸기
 */
public class MemberDao {
	//모든 회원의 정보를 SELECT 해서 리턴하는 메소드
	public List<MemberDto> selectAll(){
		List<MemberDto> list=new ArrayList<MemberDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT num, name, addr FROM member ORDER BY num ASC";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDto dto=new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//회원 한명의 정보를 SELECT 해서 리턴하는 메소드
	public MemberDto select(int num) {
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
				dto=new MemberDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
			if(rs!=null)rs.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	
	//회원 한명의 정보를 저장하는 메소드
	public boolean insert(MemberDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		int flag=0;
		
		try {
			
			conn=new DBConnect().getConn();
			String sql="INSERT INTO member (num, name, addr) VALUES (member_seq.NEXTVAL, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			
			flag=pstmt.executeUpdate();
			
			System.out.println("회원 정보를 저장했습니다.");
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}
	
	//회원 한명의 정보를 수정하는 메소드
	public boolean update(MemberDto dto) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		int flag=0;
		
		try {
			conn=new DBConnect().getConn();
			String sql="UPDATE member SET name=?,addr=? WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보를 수정 했습니다.");
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
				try {
					
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	//회원 한명의 정보를 삭제하는 메소드
	public boolean delete(int num) {
		
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
				e.printStackTrace();
			}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}
}
