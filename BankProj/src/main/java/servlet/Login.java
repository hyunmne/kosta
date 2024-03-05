package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Member;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		
		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute(id);
		String pw2 = (String)session.getAttribute(pw);
		
		RequestDispatcher dispatcher = null;
		
		if (mem==null) {
			request.setAttribute("err", "계정이 존재하지 않습니다.");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} else {
			
			if (request.getParameter("password") != pw2) {
				request.setAttribute("err", "비밀번호가 틀립니다! 다시 입력해주십시오.");
				dispatcher = request.getRequestDispatcher("error.jsp");
			}
			
			request.setAttribute("mem", mem);
			dispatcher = request.getRequestDispatcher("login.jsp");
		}
		dispatcher.forward(request, response);
		
	}

}
