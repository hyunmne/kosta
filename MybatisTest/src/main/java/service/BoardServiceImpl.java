package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.BoardDao;
import dao.BoardDaoImpl;
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

}
