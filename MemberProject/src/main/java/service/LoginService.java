package service;

import vo.MemberVO;
import static db.jdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class LoginService {

	public MemberVO getloginMember(String id, String passwd) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		MemberVO loginMember = memberDAO.selectLoginMember(id, passwd);
		close(con);
		return loginMember;
	}

}