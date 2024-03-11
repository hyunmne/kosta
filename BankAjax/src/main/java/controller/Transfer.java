package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import dto.Account;
import service.AccountService;
import service.AccountServiceImpl;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("transfer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String transJson = request.getParameter("transfer");
		System.out.println(transJson);
		
		JSONParser parser = new JSONParser();
		try {
			JSONObject jobj = (JSONObject) parser.parse(transJson);
			String sId = (String) jobj.get("sId");
			String rId = (String) jobj.get("rId");
			Long money = (Long) jobj.get("money");
			
			AccountService accService = new AccountServiceImpl();
			accService.transfer(sId, rId, money.intValue());
			Account acc = accService.accountInfo(sId);
			response.getWriter().write(String.format("%s 계좌에서 %d원 이체되었습니다.", acc.getId(), acc.getBalance()));
		} catch(Exception e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());

		}
		
		
	}

}
