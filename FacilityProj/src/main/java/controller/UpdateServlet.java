package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Facility;
import service.FacilityBiz;

@WebServlet(urlPatterns = { "/facility/update" })
public class UpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		
		try {
			FacilityBiz biz = new FacilityBiz();
			Facility fac = biz.getFacility(id);
			req.setAttribute("fac", fac);
			req.getRequestDispatcher("/update.jsp").forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("err", "시설 조회 실패");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		Integer price = Integer.parseInt(req.getParameter("price"));
		String etc = req.getParameter("etc");
		
		try {
			FacilityBiz biz = new FacilityBiz();
			biz.modifyFacility(id, name, price, etc);
			resp.sendRedirect("/facility/list");
		} catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("err", "시설 수정 실패");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
	}
}