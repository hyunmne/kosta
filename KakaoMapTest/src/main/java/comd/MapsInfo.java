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
		List<Location> locs = new ArrayList<>();
		locs.add(new Location("서울 금천구 가산디지털1로 70", "호서대벤처타워"));
		locs.add(new Location("전북특별자치도 남원시 숲정이3길 13", "청화대"));
		locs.add(new Location("서울 영등포구 국회대로 지하 758", "국회의사당"));
		
		Gson gson = new Gson();
		String jsonArrayString = gson.toJson(locs);
		request.setAttribute("locs", jsonArrayString);
		
		System.out.println(jsonArrayString);
		
		request.getRequestDispatcher("AddressSearchMapAPI.jsp").forward(request, response);
	}

}
