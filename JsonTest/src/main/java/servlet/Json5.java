package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class Json3
 */
@WebServlet("/json5")
public class Json5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Json5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String persJson = request.getParameter("param");
		System.out.println(persJson);
		
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonObj = (JSONObject) parser.parse(persJson);
			JSONArray persons = (JSONArray)jsonObj.get("persons");
			
			for (int i =0; i<persons.size(); i++) {
				JSONObject per = (JSONObject)persons.get(i);
				String name = (String)per.get("name"); // key
				System.out.println(name);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
