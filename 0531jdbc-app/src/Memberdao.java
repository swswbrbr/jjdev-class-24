import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Memberdao {
	//git허브 가입하기 
	PreparedStatement pstmt = null;
	
	private String url;
	private String dbid;
	private String dbpw;
	
	private void dbPropertiesInit() throws IOException{
		FileInputStream fis = new FileInputStream("d:\\db.properties");
		Properties pro = new Properties(); //?=??
		pro.load(fis);
		this.url = pro.getProperty("url"); //jdbc:oracle:thin:@localhost:1521:XE
		this.dbid = pro.getProperty("dbid");
		this.dbpw = pro.getProperty("dbpw");
		
		System.out.println(url);
		System.out.println(dbid);
		System.out.println(dbpw);
		
	}
	
	public Member selectMemberById(String id) throws ClassNotFoundException, SQLException, IOException{
		//properties에서 db정보 가져올것
		this.dbPropertiesInit();
		
		Class.forName("oracle.jdbc.OracleDriver");
		//String url = "";//"jdbc:oracle:thin:@localhost:1521:XE";
		//String dbid = "";//"dev24id";
		//String dbpw = "";//"java0000";
		Connection conn = DriverManager.getConnection(this.url, this.dbid, this.dbpw);
		
		String query = "select * from oracle_member where ora_id=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		Member member = null;
		while(rs.next()){
			member = new Member();
			member.setOra_id(rs.getString("ora_id"));
			member.setOra_pw(rs.getString("ora_pw"));
			member.setOra_level(rs.getString("ora_level"));
			member.setOra_name(rs.getString("ora_name"));
			member.setOra_email(rs.getString("ora_email"));
		}
		return member;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException{
		Memberdao md = new Memberdao();
		Member m = md.selectMemberById("id001");
		System.out.println(m.getOra_id());
	}
	
}
