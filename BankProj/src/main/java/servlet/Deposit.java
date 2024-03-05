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
 * Servlet implementation class Deposit
 */
@WebServlet("/deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		int money = Integer.parseInt(request.getParameter("money"));
		
		HttpSession session = request.getSession(); // session 생성
		Account acc = (Account) session.getAttribute(id); // session에서 key id로 계좌 정보를 찾아서 acc 변수에 넣음
		RequestDispatcher dispatcher = null;	
		
		if(acc == null) {
			request.setAttribute("err", "계좌번호가 틀립니다.");
			dispatcher = request.getRequestDispatcher("error.jsp"); // error 페이지로 보내줌
		} else {
			acc.deposit(money);
			request.setAttribute("acc", acc);
			dispatcher = request.getRequestDispatcher("accountInfo.jsp"); // accountInfo 페이지로 이동
		}
		dispatcher.forward(request, response);	// request 값을 보내준다..? 
	}

}
