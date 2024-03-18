package dao;

import java.util.List;

import dto.Facility;

public interface FacilityDao {
	List<Facility> selectFacList() throws Exception;
	Facility selectFacility(String id) throws Exception;
	void updateFacility(String id, String name, Integer price, String etc) throws Exception;
}
