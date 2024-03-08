package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.Account;
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
		request.getRequestDispatcher("makeAccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String accJson = request.getParameter("acc"); // 입력 받은 것들을 string 객체로 받아온다.
		System.out.println(accJson);
		Gson gson = new Gson(); // account 객체로 만들기 위해 사용했다.
		Account acc= gson.fromJson(accJson, Account.class);
		
		try {
			AccountService accService = new AccountServiceImpl();
			accService.makeAccount(acc);
			response.getWriter().write("계좌가 개설되었습니다."); // success의 result로 꽂아줌
		} catch(Exception e) {
			e.printStackTrace();
			response.sendError(500);
		}
		
		
	}

}
