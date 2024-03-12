package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;
import service.BoardServiceImpl;

/**
 * Servlet implementation class BoardModify
 */
@WebServlet("/boardModify")
public class BoardModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Integer num = Integer.parseInt(request.getParameter("num"));
		
		try {
			BoardService brdService = new BoardServiceImpl();
			Board board = brdService.brdDetail(num);
			request.setAttribute("board", board);
			request.getRequestDispatcher("modifyForm.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("err", "게시글 조회 실패");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			BoardService brdService = new BoardServiceImpl();
			brdService.boardModify(request);
			response.sendRedirect("boardList");
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "게시글 수정 실패");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
