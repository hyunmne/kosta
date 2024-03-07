package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Account;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public void insertAccount(Account acc) throws Exception {
		String sql = "insert into account values(?,?,?,?,?)";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getId());
			pstmt.setString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			pstmt.setString(4, acc.getType());
			pstmt.setString(5, acc.getGrade());
			pstmt.executeUpdate();
			JdbcUtil.commit(conn);
		} catch(Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}

	@Override
	public Account selectAccount(String id) throws Exception {
		String sql = "select * from account";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account acc = null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				String sid = rs.getString("id");
				String sname = rs.getString("name");
				int sbalance = rs.getInt("balance");
				String stype = rs.getString("type");
				String sgrade = rs.getString("grade");
				acc = new Account(sid, sname, sbalance, stype, sgrade);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return acc;
	}

}
