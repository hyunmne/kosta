package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountService;
import service.AccountServiceImpl;

/**
 * Servlet implementation class MakeAccount
 */
@WebServlet("/makeAccount")
public class MakeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("makeAccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AccountService accService = new AccountServiceImpl();
			accService.makeAccount(request);
			response.sendRedirect("allAccountInfo");
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "계좌 생성 실패");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
