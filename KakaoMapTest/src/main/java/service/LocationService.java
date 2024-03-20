package service;

import java.util.List;

import vo.Location;

public interface LocationService {
//	void insertLoc(Location loc) throws Exception;
	List<Location> getLocList(Integer page) throws Exception;
	Integer getLocMaxPage() throws Exception;
}
