package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDao memDao = new MemberDaoImpl();

	@Override
	public void join(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		Member sMem = memDao.selectMember(id);
		if(sMem != null) throw new Exception("아이디 중복 오류");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		Member mem = new Member(id,name,password,email,address);
		memDao.insertMember(mem);
	}

	@Override
	public void login(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Member mem = memDao.selectMember(id);
		
		if(mem == null) throw new Exception("아이디 오류");
		if(!mem.getPassword().equals(password)) throw new Exception("비밀번호 오류");
		// 로그인 정상
		HttpSession session = request.getSession();
		mem.setPassword("");
		session.setAttribute("user", mem);
	}

	@Override
	public boolean memberIdCheck(String id) throws Exception {
		Member mem = memDao.selectMember(id);
		if (mem==null) return false;
		return true;
	}


}
