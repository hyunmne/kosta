package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class MemberDouble
 */
@WebServlet("/memberDoubleId")
public class MemberDoubleId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDoubleId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id"); // 입력받은 id를 받아온다
		try {
			MemberService memService = new MemberServiceImpl();
			boolean doubleId = memService.checkDoubleId(id);  // 중복이면 false 아니면 true
			response.getWriter().write(String.valueOf(doubleId)); // 받아온 값을 다시 ajax로 보낸다
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
