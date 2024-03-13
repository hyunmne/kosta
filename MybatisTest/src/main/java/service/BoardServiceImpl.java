package service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDao;
import dao.BoardDaoImpl;
import dto.BFile;
import dto.Board;
import util.PageInfo;

public class BoardServiceImpl implements BoardService {
	private BoardDao brdDao = new BoardDaoImpl();

	@Override
	public void boardListByPage(HttpServletRequest request) throws Exception {
		// 1. 페이지를 가져오고 없으면 페이지 번호를 1로 한다.
		Integer page = 1;
		String pageNo = request.getParameter("page");
		if (pageNo != null) {
			page = Integer.parseInt(pageNo);
		}

		// 2. PageInfo 계산하여 설정하기
		// 전체 글 갯수를 double 타입으로 변환 
		// 소수를 반올림해주는 함수 Ceil 사용
		// 반올림한 소수를 int로 형변환 해 소숫점 없애기 
		int maxPage = (int) Math.ceil((double)brdDao.selectBrdCnt()/10); 
		int startPage = (page-1)/10*10+1;
		int endPage = startPage+10-1;
		if (endPage > maxPage) endPage = maxPage;

		PageInfo pageInfo = new PageInfo();
		pageInfo.setAllPage(maxPage);
		pageInfo.setCurPage(page);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);

		// 3. 해당 페이지에 해당하는 게시판 글 목록 조회
		int row = (page-1)*10;
		List<Board> boardList = brdDao.selectBrdList(row);

		// 4. 응답으로 보내기 위해 request 영역에 담는다/.
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("brdList", boardList);
	}

	@Override
	public Board brdDetail(Integer num) throws Exception {
		brdDao.updateBrdViewCnt(num);
		return brdDao.selectBoard(num);
	}

	@Override
	public void boardWrite(HttpServletRequest request) throws Exception {
		Board board = new Board();

		// 1. 파일 업로드 
		// 1-1. 업로드할 경로 설정 및 파일 최대 크기 설정
		String path = request.getServletContext().getRealPath("upload");
		int size = 10*1024*1024;
		// 1-2. 설정할 경로에 파일 업로드 
		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());

		// 2. 업로드 파일이 있을 경우
		File file = multi.getFile("file");
		if(file!=null) {
			// 2-1. 파일 정보를 BFile 객체에 담아 File 테이블에 삽입
			BFile bFile = new BFile();
			bFile.setDirectory(path);
			bFile.setContenttype(multi.getContentType("file"));
			bFile.setName(multi.getFilesystemName("file"));
			bFile.setSize(file.length());
			brdDao.insertFile(bFile);

			// 2-2. 파일 테이블에서 자동 생성된 파일번호로 업로드한 파일이름 변경
			File uploadFile = new File(path,file.getName());
			uploadFile.renameTo(new File(path,bFile.getNum()+""));

			// 2-3. 파일 테이블에서 자동 생성된 파일번호로 Board의 파일 번호 셋팅
			board.setFilenum(bFile.getNum());
		}
		// 3. 파라미터에서 파일 이외의 정보 가져와 Board 객체에 담아 Board 테이블에 삽입  
		board.setSubject(multi.getParameter("subject"));
		board.setContent(multi.getParameter("content"));
		board.setWriter(multi.getParameter("writer"));
		brdDao.insertBoard(board);
	}

	@Override
	public void boardModify(HttpServletRequest request) throws Exception {
		Board board = new Board();

		// 1. 파일 업로드 
		String uploadPath = request.getServletContext().getRealPath("upload");
		int size = 10*1024*1024;
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());

		// 2. 업로드 파일이 있으면 
		File file = multi.getFile("file");
		if(file!=null) {
			// 2-1. 파일 정보 모아서 BFile 객체 생성하여 파일 테이블에 삽입
			BFile bFile = new BFile();
			bFile.setDirectory(uploadPath);
			bFile.setName(file.getName());
			bFile.setContenttype(multi.getContentType("file"));
			bFile.setSize(file.length());
			brdDao.insertFile(bFile);
			// 2-2. 저장된 파일번호로 업로드한 파일명 변경
			File uploadFile = new File(uploadPath, file.getName());
			uploadFile.renameTo(new File(uploadPath,bFile.getNum()+""));
			// 2-3. 저장된 파일번호로 Board의 파일번호 셋팅
			board.setFilenum(bFile.getNum());
		}

		// 3. 수정된 Board 정보를 파라미터에서 가져다가 Board 객체 생성하여 Board 테이블 갱신
		board.setNum(Integer.parseInt(multi.getParameter("num")));
		board.setSubject(multi.getParameter("subject"));
		board.setContent(multi.getParameter("content"));
		brdDao.updateBoard(board);
	}

}
