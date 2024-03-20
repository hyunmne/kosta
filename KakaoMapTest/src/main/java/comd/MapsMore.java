package comd;

import java.io.IOException;
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
 * Servlet implementation class MapsMore
 */
@WebServlet("/moreLocation")
public class MapsMore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapsMore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer page = Integer.valueOf(request.getParameter("page"));
		System.out.println(page);
		response.setCharacterEncoding("utf-8");
		try {
			LocationService service = new LocationServiceImpl();
			List<Location> locs = service.getLocList(page);
			
			Gson gson = new Gson();
			String jsonArrayString = gson.toJson(locs);
			response.getWriter().write(jsonArrayString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
