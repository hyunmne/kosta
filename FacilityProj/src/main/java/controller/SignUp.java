package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Employee;
import service.EmpService;
import service.EmpServiceImpl;

/**
 * Servlet implementation class SineUp
 */
@WebServlet("/member/signUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/signUp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String empNo= request.getParameter("empNo");
		String empPw = request.getParameter("empPw");
		String empNm = request.getParameter("empNm");
		
		Employee emp = new Employee(empNo, empPw, empNm);
		
		try {
			EmpService empService = new EmpServiceImpl();
			empService.singUp(emp);
			response.sendRedirect("/");
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("err", e.getMessage());
		}
	}

}
