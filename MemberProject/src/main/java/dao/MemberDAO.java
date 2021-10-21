package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.MemberVO;


public class MemberDAO {
   private Connection con;
   //singleton ����
   
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
	String sql = "SELECT * FROM member WHERE memberId = ? AND memberPassword = ?";
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberId);
		pstmt.setString(2, memberPassword);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			memberVO = new MemberVO();
			memberVO.setMemberAddr1(rs.getString("memberAddr1"));
			memberVO.setMemberAddr2(rs.getString("memberAddr2"));
			memberVO.setMemberAge(rs.getInt("memberAge"));
			memberVO.setMemberCountry(rs.getString("memberCountry"));
			memberVO.setMemberEmail(rs.getString("memberEmail"));
			memberVO.setMemberGender(rs.getString("memberGender"));
			memberVO.setMemberId(rs.getString("memberId"));
			memberVO.setMemberName(rs.getString("memberName"));
			memberVO.setMemberPassword(rs.getString("memberPassword"));
			memberVO.setMemberTel(rs.getString("memberTel"));
			memberVO.setZipCode(rs.getString("zipCode"));
		}
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	finally {
		try {
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	return memberVO;
	}
}


