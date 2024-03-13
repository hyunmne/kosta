package service;import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public interface MemberService {
	void join(HttpServletRequest request) throws Exception;
	void selectList(HttpServletRequest request) throws Exception;
}
