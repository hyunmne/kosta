import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Database 처리 과정
// 1. Database 연결
// 2. SQL문 실행을 위해 statement 얻어오기 : Statement, PreparedStatement : conn.createStatement()
// 3. 쿼리문 작성 :  
// 4. 쿼리문 실행 : executeUpdate(insert,delete,update), executeQuery(Select) : stmt.executeUpdate()

public class DBConnect {
	// ** Database 연결
	//1. Driver 설정
	//2. url 설정
	//3. username 설정
	//4. password 설정
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");  //Driver 설정
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/testdb", "root", "7564");
			System.out.println("DB 연결 성공");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}

	public static void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertUser(String id, String name) {
		// getConnection 메서드에서 conn을 받아옴
		Connection conn = getConnection();
		Statement stmt = null;
		String sql = String.format("insert into user(id,name) values ('%s','%s')", id,name);
		try {
			stmt = conn.createStatement();
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt+"개 데이터 삽입");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(stmt !=null) stmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			close(conn);
		}
	}
	
	public static void userInfo(String id) {
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		String sql = String.format("select id, name from user where id='%s'", id);
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			if(rset != null && rset.next()) {
				String rid = rset.getString("id");
				String rname = rset.getString("name");
				System.out.println(rid+", "+rname);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset!=null) rset.close();
				if(stmt!=null) rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
//		insertUser("song", "송송송");
		userInfo("song");
	}
}

