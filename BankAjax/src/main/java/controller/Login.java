package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
		response.setCharacterEncoding("utf-8");
		
		String loginJson = request.getParameter("login");
		System.out.println(loginJson);
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject jobj = (JSONObject) parser.parse(loginJson);
			String id = (String) jobj.get("id");
			String pw = (String) jobj.get("password");
			Boolean autoLogin = (Boolean) jobj.get("autologin");
			
			MemberService memberService = new MemberServiceImpl();
			memberService.login(id, pw); // memberInfo에서 id를 키값으로 
			
			// 로그인 성공시 cookie check 저저장
			Cookie autoLoginCookie = null;
			Cookie idCookie = null;
			Cookie pwCookie = null;
			autoLoginCookie = new Cookie("autoLogin", String.valueOf(autoLogin));
			
			if(autoLogin!=null) {
				idCookie = new Cookie("id", id);
				pwCookie = new Cookie("password", pw);
			} else {
				idCookie = new Cookie("id", "");
				pwCookie = new Cookie("password", "");
			}
			response.addCookie(autoLoginCookie);
			response.addCookie(idCookie);
			response.addCookie(pwCookie);
			
			// session 저장 
			request.getSession().setAttribute("user", id);
			response.getWriter().write("true");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
		}
		
		
	}

}
