package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import acc.Account;
import acc.SpecialAccount;

public class AccountDAO {
	public Connection getConnection() {
		Connection conn = null;
		try {
			Properties db = new Properties();
			db.load(new FileInputStream("db.properties"));
			Class.forName(db.getProperty("driver"));
			conn = DriverManager.getConnection(db.getProperty("url"),
					db.getProperty("user"),
					db.getProperty("password"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public boolean insertAccount(Account acc) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "";
		if (acc instanceof SpecialAccount) {
			sql = "insert into account (id,name,balance,grade) values(?,?,?,?)";
		} else {
			sql = "insert into account (id, name, balance) values (?,?,?)";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getId());
			pstmt.setString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			if (acc instanceof SpecialAccount) {
				pstmt.setString(4, ((SpecialAccount)acc).getGrade());
			}			
			pstmt.executeUpdate();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			close(conn);
		}
	}

	public void updateAccount(Account acc) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update account set balance=? where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acc.getBalance());
			pstmt.setString(2, acc.getId());
			pstmt.executeQuery();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			close(conn);
		}
		
	}
	
	public List<Account> selectAccountList() {
		List<Account> accList = new ArrayList<>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from account";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs!=null) {
				while (rs.next()) {
					String rid = rs.getString("id");
					String rname = rs.getString("name");
					int rbalance = rs.getInt("balance");
					String rgrade = rs.getString("grade");
					if (rgrade == null) {
						accList.add(new Account(rid, rname, rbalance));
					} else {
						accList.add(new SpecialAccount(rid, rname, rbalance, rgrade));
					}					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return accList;
	}
	
	public Account selectAccount(String id) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account acc = null;
		String sql = "select * from account where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				String rid = rs.getString("id");
				String rname = rs.getString("name");
				int rbalance = rs.getInt("balance");
				String rgrade = rs.getString("grade");
				if (rgrade==null) {
					acc = new Account(rid, rname, rbalance);
				} else {
					acc = new SpecialAccount(rid, rname, rbalance, rgrade);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return acc;
	}
	
	public void transferAccount(String sid, String red) {
		
	}

	
}
