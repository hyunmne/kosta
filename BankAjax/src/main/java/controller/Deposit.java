package controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dto.Account;
import service.AccountService;
import service.AccountServiceImpl;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("deposit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String jsonStr = request.getParameter("deposit"); // 입력받은 값들을 jsonStr에 넣어줌
		System.out.println(jsonStr);
		
		// JSON을 Map<String, String>으로 변환
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String,String>>(){}.getType();
		Map<String, String> depositData = gson.fromJson(jsonStr, type);
		
		System.out.println(depositData.get("id"));
		System.out.println(depositData.get("money"));
		
		try {
			AccountService accService = new AccountServiceImpl();
			accService.deposit(depositData.get("id"),
							   Integer.parseInt(depositData.get("money")));
			Account acc = accService.accountInfo(depositData.get("id"));
			response.getWriter().write(String.format("%s 계좌 잔액은 %d원입니다.", 
														acc.getId(), acc.getBalance()));
		} catch (Exception e) {
			response.getWriter().write(e.getMessage());
		}
	}

}
