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
 * Servlet implementation class Transfer
 */
@WebServlet("/transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sendAcc = request.getParameter("sendAcc");
		String recAcc = request.getParameter("recAcc");
		int money = Integer.parseInt(request.getParameter("money"));
		
		HttpSession session = request.getSession(); // session 생성
		Account sAcc = (Account) session.getAttribute(sendAcc); // session에서 key id로 계좌 정보를 찾아서 acc 변수에 넣음
		Account rAcc = (Account) session.getAttribute(recAcc);
		
		RequestDispatcher dispatcher = null;	
		
		if(sAcc == null) {
			request.setAttribute("err", "보내는 계좌번호가 틀립니다.");
			dispatcher = request.getRequestDispatcher("error.jsp"); // error 페이지로 보내줌
		} else if (rAcc == null) {
			request.setAttribute("err", "받는 계좌번호가 틀립니다.");
			dispatcher = request.getRequestDispatcher("error.jsp"); // error 페이지로 보내줌
		} else {
			sAcc.withdraw(money);
			rAcc.deposit(money);
			request.setAttribute("sAcc", sAcc);
			request.setAttribute("rAcc", rAcc);
			dispatcher = request.getRequestDispatcher("allAccountInfo.jsp"); // accountInfo 페이지로 이동
		}
		dispatcher.forward(request, response);	// request 값을 보내준다..? 
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("transfer.jsp").forward(req, resp);
	}
	

}
