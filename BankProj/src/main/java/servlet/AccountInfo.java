package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Account;

/**
 * Servlet implementation class AccountInfo
 */
@WebServlet("/accountInfo")
public class AccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		// 2. 파라미터 가져오기
		String id = request.getParameter("id");
		
		// 3. 세션 얻어오기
		HttpSession session = request.getSession();
		// 4. 세션에서 id를 키값으로 속한 계좌 가져오기
		Account acc = (Account) session.getAttribute(id);
		// 5. dispatcher 선언하기
		RequestDispatcher dispatcher = null;
		// 6. 계좌가 없으면 err.jsp로 포워드
		if (acc == null) {
			request.setAttribute("err", "계좌번호가 틀립니다.");
			dispatcher = request.getRequestDispatcher("error.jsp");
		// 7. 계좌가 있으면 accountInfo.jsp 페이지로 포워드
		} else { 
			request.setAttribute("acc", acc);
			dispatcher = request.getRequestDispatcher("accountInfo.jsp");
		}
		dispatcher.forward(request, response);
	}

}
