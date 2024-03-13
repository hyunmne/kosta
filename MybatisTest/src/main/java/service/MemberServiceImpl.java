package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDao memDao = new MemberDaoImpl();

	@Override
	public void join(HttpServletRequest request) throws Exception {
		Member mem = new Member();
		
		mem.setId(request.getParameter("id"));
		mem.setName(request.getParameter("name"));
		mem.setPassword(request.getParameter("password"));
		mem.setEmail(request.getParameter("email"));
		mem.setAddress(request.getParameter("address"));
		
		memDao.insertMember(mem);
	}

	@Override
	public void selectList(HttpServletRequest request) throws Exception {
		List<Member> memList = memDao.selectMemList();
		request.setAttribute("memList", memList);
	}

}
