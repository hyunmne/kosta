package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie
 */
@WebServlet("/cookie")
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("myproduct", "shortdress"); // 쿠키 생성
		cookie.setMaxAge(600); // 쿠키 유지 시간 설정 
		response.addCookie(cookie); // 생성한 쿠키를 HTTP 응답 헤더에 추가하여 클라이언트로 전송
		//  요청을 cookieTest.jsp로 전달하여 쿠키를 표시
		request.getRequestDispatcher("cookieTest.jsp").forward(request, response);
	}

}
