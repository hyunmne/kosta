package dao;

import dto.Board;
import dto.File;

public interface BoardDAO {
	void insertDAO(Board board) throws Exception;
	void insertFile(File file) throws Exception;
}
