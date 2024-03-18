package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FacilityBiz;
import service.TeamBiz;

@WebServlet(urlPatterns = { "/facility/list" })
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			FacilityBiz facBiz = new FacilityBiz();
			TeamBiz teamBiz = new TeamBiz();
			req.setAttribute("facList", facBiz.getFacilityList());
			req.setAttribute("teamBudget", teamBiz.selectTeamBudget());
			req.getRequestDispatcher("/list.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("err", "시설목록 조회 오류");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
	}
}