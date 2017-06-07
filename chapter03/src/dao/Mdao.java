package dao;

import java.sql.*;

import dto.Member;

public class Mdao {
	String result = null;
	PreparedStatement pstmt = null;
	
	//02 getSession 메서드 선언
	public Member mgetSession(String id) throws ClassNotFoundException, SQLException{
		Member session = new Member();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jjdev?" +
				"useUnicode=true&characterEncoding=utf8","root","java0000");
		String sql="select * from member where member_id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			session.setMember_no(rs.getInt("member_no"));
			session.setMember_id(rs.getString("member_id"));
			session.setMember_pw(rs.getString("member_pw"));
		}
		return session; 
	}
	
	//01 login메서드 선언
	public String mLogin(String id, String pw) throws ClassNotFoundException, SQLException{

	String dbid = null;
	String dbpw = null;
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jjdev?" +
			"useUnicode=true&characterEncoding=utf8","root","java0000");
	String sql="select * from member where member_id=? and member_pw=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, pw);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){
		dbid = rs.getString("member_id");
		dbpw = rs.getString("member_pw");
	}
	
	if(id.equals(dbid)){
		result = "01아이디일치";
		if(pw.equals(dbpw)){
			result = "03로그인성공";
		}else{
			result="04비번불일치";
		}
	}else{
		result = "02아이디불일치";
	}
	return result;
	}
}
