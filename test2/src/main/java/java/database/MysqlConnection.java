package java.database; // 패키지명 수정

import java.sql.*;
import java.io.*;

public class MysqlConnection{
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	MysqlConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // JDBC 드라이버 로드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_tutorial?characterEncoding=UTF-8&serverTimezone=UT\n", "root", "1234"); // []부분 ([table name], [pwd]) 수정
			System.out.println("연결 완");
		}catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ // 연결 해제(한정돼 있으므로)
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(stmt!=null){stmt.close();}
				if(conn!=null){conn.close();}
			}catch(SQLException se2){
				se2.printStackTrace();
			}
		}
	}
}