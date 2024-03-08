package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;
import service.MemberService;
import service.MemberServiceImpl;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		
		
		try {
			MemberService memberService = new MemberServiceImpl();
			Member mem = memberService.login(id, pw); // memberInfo에서 id를 키값으로 
			
			// 로그인 성공시 cookie check 저저장
			String autoLogin = request.getParameter("autoLogin");
			Cookie autoLoginCookie = null;
			Cookie idCookie = null;
			Cookie pwCookie = null;
			if(autoLogin!=null) {
				autoLoginCookie = new Cookie("autoLogin", autoLogin);
				idCookie = new Cookie("id", id);
				pwCookie = new Cookie("password", pw);
			} else {
				autoLoginCookie = new Cookie("autoLogin", "false");
				idCookie = new Cookie("id", "");
				pwCookie = new Cookie("password", "");
			}
			response.addCookie(autoLoginCookie);
			response.addCookie(idCookie);
			response.addCookie(pwCookie);
			
			// session 저장 
			request.setAttribute("mem", mem);
			request.getRequestDispatcher("makeAccount.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
