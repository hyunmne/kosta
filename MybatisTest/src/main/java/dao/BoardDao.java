package dao;

import java.util.List;

import dto.Board;

public interface BoardDao {
	List<Board> selectBrdList(Integer row) throws Exception;
	Integer selectBrdCnt() throws Exception;	
}
