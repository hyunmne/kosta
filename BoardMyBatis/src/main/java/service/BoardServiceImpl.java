package service;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dao.BoardDAO;
import dao.BoardDAOImpl;
import dto.Board;
import dto.File;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;

	public BoardServiceImpl() {
		boardDAO = new BoardDAOImpl();
	}

	@Override
	public void boardWrite(HttpServletRequest request) throws Exception {
		Board board = new Board();

		// 파일 업로드 시작
		String uploadPath = request.getServletContext().getRealPath("upload");
		int size = 10*1024*1024;  // 업로드할 파일의 크기 지정 : 10MB
		MultipartRequest multi = new MultipartRequest(request,uploadPath,size,"utf-8", 
				new FileRenamePolicy() { // 파일명 바꿔주는 클래스,,, 
			@Override
			public java.io.File rename(java.io.File file) {
				File uploadFile = new File();
				try {
					uploadFile.setName(file.getName());
					uploadFile.setDirectory(uploadPath);
					uploadFile.setSize(file.length());
					boardDAO.insertFile(uploadFile);
					board.setFilenum(uploadFile.getNum());
				} catch(Exception e) {
					e.printStackTrace();
				}
				return new java.io.File(file.getParent(), uploadFile.getNum()+"");
			}
		});
		// 파일 업로드 끝

		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		String writer = multi.getParameter("writer");

		board.setSubject(subject);
		board.setContent(content);
		board.setWriter(writer);
		boardDAO.insertDAO(board);
	}
}
