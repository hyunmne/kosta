package dao;

import java.util.List;

import vo.Location;

public interface LocationDao {
	void insertLocation (Location loc) throws Exception;
	List<Location> selectLocList(Integer row) throws Exception;
	Integer selectLocCnt() throws Exception;
}
