package service;

import javax.servlet.http.HttpServletRequest;

import dto.Board;

public interface BoardService {
	void boardListByPage(HttpServletRequest request) throws Exception;
	Board brdDetail(Integer num) throws Exception;
	void boardWrite(HttpServletRequest request) throws Exception;
	void boardModify(HttpServletRequest request) throws Exception;
}
