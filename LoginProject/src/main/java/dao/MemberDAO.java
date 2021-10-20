package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.MemberVO;

//DAO(Data Access Object) : DBMS로 SQL 구문을 전송하는 클래스
//VO(Value Object): 데이터베이스에서 조회한 데이터를 애플리케이션에서 사용할 수 있도록 객체로 변한할 때 사용
//DTO(Data Transfer Object): 클라이언트에서 전송된 데이터를 저장해서 Service 클래스로 전달할 때 사용
public class MemberDAO {
   private Connection con;
   //singleton 패턴
   
   private static MemberDAO instance;
   
   
   private MemberDAO()
   {
      
   }
   
   public static MemberDAO getInstance()
   {
      if(instance == null)
      {
         instance = new MemberDAO();
      }
      return instance;
   }
   
   public void setConnection(Connection con)
   {
      this.con = con;
   }

public MemberVO selectLoginMember(String memberId, String memberPassword) {
	// TODO Auto-generated method stub
	MemberVO memberVO = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "SELECT FROM member WHERE memberId = ? AND memberPassword = ?";
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberId);
		pstmt.setString(2, memberPassword);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			memberVO = new MemberVO();
			memberVO.setMemberAddr1(rs.getString("memberAddr1"));
			memberVO.setMemberAddr2(rs.getString("memberAddr2"));
			memberVO.setMemberAge(rs.getString("memberAge"));
			memberVO.setMemberCountry(rs.getString("memberCountry"));
			memberVO.setMemberEmail(rs.getString("memberEmail"));
			memberVO.setMemberGender(rs.getString("memberGender"));
			memberVO.setMemberId(rs.getString("memberId"));
			memberVO.setMemberName(rs.getString("memberName"));
			memberVO.setMemberPassword(rs.getString("memberPassword"));
			memberVO.setMemberTel(rs.getString("memberTel"));
			memberVO.setZipCode(rs.getString("zipCode"));
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	return memberVO;
}
}
   
