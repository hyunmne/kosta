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
 * Servlet implementation class MakeAccountProc
 */
@WebServlet("/makeaccount")
public class MakeAccountProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAccountProc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id"); // makeAccount.jsp에서 보낸 값들을 변수에 넣어줌.
		String name = request.getParameter("name");
		int balance = Integer.parseInt(request.getParameter("balance"));
		String type = request.getParameter("type");
		String grade = request.getParameter("grade");
		
		Account acc = new Account (id, name, balance, type,grade); // acc 객체 생성
		HttpSession session = request.getSession(); // 세션 생성 
		session.setAttribute(id, acc); // session에 id를 키 값으로 acc 객체를 보내준다 > 여러 acc를 넣을 수 있다.
		request.setAttribute("acc", acc); // 
		
		// servlet 사용할 때.. allAcountInfo에 데이터를 보내줌.
		RequestDispatcher dispatcher = request.getRequestDispatcher("accountInfo.jsp");
		dispatcher.forward(request, response);
	};

}
