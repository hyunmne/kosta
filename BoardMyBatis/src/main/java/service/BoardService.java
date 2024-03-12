package service;


import javax.servlet.http.HttpServletRequest;

import dto.Board;


public interface BoardService {
	void boardWrite(HttpServletRequest request) throws Exception;
	void brdListByPage(HttpServletRequest request) throws Exception;
	Board brdDetail(Integer num) throws Exception;
	void boardModify(HttpServletRequest request) throws Exception;
}
