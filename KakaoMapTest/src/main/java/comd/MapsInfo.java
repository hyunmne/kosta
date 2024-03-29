package comd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.LocationService;
import service.LocationServiceImpl;
import vo.Location;

/**
 * Servlet implementation class MapsInfo
 */
@WebServlet("/maps")
public class MapsInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapsInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		String pageStr = request.getParameter("page");
		if (pageStr != null) {
			page = Integer.parseInt(pageStr);
		}
		
		try {
			LocationService service = new LocationServiceImpl();
			List<Location> locs = service.getLocList(page);
			if (locs == null) throw new Exception("위치 데이터 없음");
			
			Gson gson = new Gson();
			String jsonArrayString = gson.toJson(locs);
			request.setAttribute("locs", jsonArrayString);

			Integer maxPage = service.getLocMaxPage();
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("page", page);
//			System.out.println(jsonArrayString);
			request.getRequestDispatcher("AddressSearchMapAPI.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "지도 전체 조회 실패");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
}
