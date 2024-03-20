package service;

import java.util.List;

import dao.LocationDao;
import dao.LocationDaoImpl;
import vo.Location;

public class LocationServiceImpl implements LocationService {
	private LocationDao locDao = new LocationDaoImpl();
	
//	@Override
//	public void insertLoc(Location loc) throws Exception {
//		Location locs = new Location();
//		String addr = locs.getAddress();
//		String title = locs.getTitle();
//		
//		locDao.insertLocation(loc);
//	}

	@Override
	public List<Location> getLocList(Integer page) throws Exception {
		if(page > getLocMaxPage()) return null;
		int row = (page-1)*6;
		return locDao.selectLocList(row);
	}

	@Override
	public Integer getLocMaxPage() throws Exception {
		int maxLoc = locDao.selectLocCnt();
		return (int)Math.ceil((double)maxLoc/6);
	}

}
