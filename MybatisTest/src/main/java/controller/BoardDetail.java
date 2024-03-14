package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.Member;
import service.BoardLikeService;
import service.BoardLikeServiceImpl;
import service.BoardService;
import service.BoardServiceImpl;

/**
 * Servlet implementation class BoardDetail
 */
@WebServlet("/boardDetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer num = Integer.parseInt(request.getParameter("num"));
		
		// 서비스에서 Board를 받아서 request에 담아 boardDetail.jsp로 포워드한다.
		try {
			BoardService brdService = new BoardServiceImpl();
			Board board = brdService.brdDetail(num);
			request.setAttribute("brd", board);

			// 로그인 상태일 경우 좋아요 여부 확인하여 전송
			Member member = (Member)request.getSession().getAttribute("user");
			if(member!=null) {
				BoardLikeService brdLikeService = new BoardLikeServiceImpl();
				boolean brdLike = brdLikeService.boardLike(member.getId(), num);
				request.setAttribute("like", String.valueOf(brdLike));
			}
			request.getRequestDispatcher("boardDetail.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "게시글 조회 실패");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}


}
