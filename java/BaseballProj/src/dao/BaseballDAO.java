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

import dto.Player;
import dto.Team;

public class BaseballDAO {
	public static Connection getConnection() {
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

	public static void close(Connection conn) {
		try {
			if(conn!=null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean insertTeam(Team team) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into team(name,loc) values (?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, team.getName());
			pstmt.setString(2, team.getLoc());
			pstmt.executeUpdate();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			close(conn);
		}
	}

	public static Team selectTeam(String name) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Team team = null;

		String sql = "select * from team where name like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			rset = pstmt.executeQuery();
			
			if(rset != null && rset.next()) {
				int num = rset.getInt(1);
				String tName = rset.getString(2);
				String loc = rset.getString(3);
				team = new Team(num, tName, loc);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			close(conn);
		}
		return team;
	}

	public static List<Team> selectTeamList() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Team> teamList = new ArrayList<>();
		
		String sql = "select * from team";
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset!=null) {
				while(rset.next()) {
					int num = rset.getInt(1);
					String tName = rset.getString(2);
					String loc = rset.getString(3);
					Team team = new Team(num, tName, loc);
					teamList.add(team);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			close(conn);
		}
		return teamList;
	}

	public static boolean insertPlayer(Player player) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into player(name,backnum,tnum) values (?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player.getName());
			pstmt.setInt(2, player.getBacknum());
			pstmt.setInt(3, player.getTnum());
			pstmt.executeUpdate();
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			close(conn);
		}
	}

	public static List<Player> selectPlayer(String name) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Player> player = new ArrayList<>();
		String sql = "SELECT p.*, t.NAME"
					+ "FROM player p JOIN team t"
					+ "ON p.tnum = t.num"
					+ "WHERE p.NAME = '?'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rset = pstmt.executeQuery();
			
			if(rset!=null) {
				while(rset.next()) {
					int num = rset.getInt(1);
					String pname = rset.getString(2);
					int backnum = rset.getInt(3);
					int tnum = rset.getInt(4);
					String tname = rset.getString(5);
					player.add(new Player(num,pname,backnum,tnum,tname));
				}
			}
			
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
		return player;
	}

	public static List<Player> selectPlayerList(){
	      Connection conn = getConnection();
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      List<Player> playerList = new ArrayList<>();
	      
	      String sql = "select p.*, t.name "
	               + " from player p join team t "
	               + " on p.tnum = t.num ";
	      try {
	         pstmt = conn.prepareStatement(sql);
	         rset = pstmt.executeQuery();
	         if(rset != null) {
	            while (rset.next()) {
	               int num = rset.getInt(1);
	               String playerName = rset.getString(2);
	               int backnum = rset.getInt(3);
	               int tnum = rset.getInt(4);
	               String tname = rset.getString(5);
	               Player player = new Player(num, playerName, backnum, tnum, tname);
	               playerList.add(player);
	            }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(pstmt != null) pstmt.close();
	            if(rset != null) rset.close();
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	         close(conn);
	      }
	      return playerList;
	   }

	
}
