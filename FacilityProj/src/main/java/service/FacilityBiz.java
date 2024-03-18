package service;

import java.util.List;

import dao.FacilityDao;
import dao.FacilityDaoImpl;
import dto.Facility;

public class FacilityBiz {
	private FacilityDao facDao;
	
	public FacilityBiz() {
		facDao = new FacilityDaoImpl();
	}
	
	public List<Facility> getFacilityList() throws Exception {
		return facDao.selectFacList();
	}
	
	public Facility getFacility(String id) throws Exception {
		return facDao.selectFacility(id);
	}
	
	public void modifyFacility(String id, String name, Integer price, String etc) throws Exception{
		facDao.updateFacility(id, name, price, etc);
	}
}