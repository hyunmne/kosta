package service;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
	void boardListByPage(HttpServletRequest request) throws Exception;
	
}
