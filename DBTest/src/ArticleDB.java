import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ArticleDB {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties db = new Properties();
			db.load(new FileInputStream("props.properties"));
			Class.forName(db.getProperty("driver"));  //Driver 설정
			conn = DriverManager.getConnection(db.getProperty("url"),
											   db.getProperty("user"),
											   db.getProperty("password"));
			System.out.println("DB 연결 성공");
		} catch(Exception e) {
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
	
	public static void insertArticle(Article article) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into article (title,content,writer) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getTitle()); // 첫번째 ?에 데이터 넣어준다.
			pstmt.setString(2, article.getTitle());
			pstmt.setString(3, article.getWriter());
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt+"개 데이터 삽입");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			close(conn);
		}
	}
	
	public static void selectArticleByWriter(String writer) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from article where writer=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer); // 첫번째 ?에 데이터 넣어준다.
			rset = pstmt.executeQuery();
			if(rset!=null) {
				while(rset.next()) {
					int num = rset.getInt(1);
					String title = rset.getString(2);
					String content = rset.getString(3);
					String writerr = rset.getString(4);
					Article article = new Article(num, title, content, writerr);
					System.out.println(article);
				}
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			close(conn);
		}
	}
	
	public static void updateArticle(int num, String title, String content) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update article set title=?, content=? where num =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, num); // 첫번째 ?에 데이터 넣어준다.
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt+"개 데이터 수정");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			close(conn);
		}
	}
	
	public static void deleteArticle(int num) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from article where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num); // 첫번째 ?에 데이터 넣어준다.
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt+"개 데이터 삭제");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			close(conn);
		}
	}
	
	
	public static void main(String[] args) {
//		insertArticle(new Article("제목1","내용3","lee"));
		selectArticleByWriter("song");
//		updateArticle(1, "헤드라인뉴스", "아무거나");
//		deleteArticle(1);
	}
}	
