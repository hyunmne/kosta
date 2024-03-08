package service;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO = new MemberDAOImpl();
	
	@Override
	public void join(Member mem) throws Exception {
		Member smem = memberDAO.selectMember(mem.getId());
		if(smem != null) throw new Exception("존재하는 회원입니다.");
		memberDAO.insertMember(mem);
		
	}

	@Override
	public Member login(String id, String password) throws Exception {
		Member mem = memberDAO.selectMember(id); // id로 db에서 member테이블에서 찾은 값을 mem에 넣어준다.
		if (mem == null) throw new Exception("아이디가 틀립니다."); // mem이 비어있으면 회원정보 존재 ㄴㄴ 
		if (!mem.getPassword().equals(password)) throw new Exception("비밀번호가 틀렸습니다.");
		
		return mem;
	}

	@Override
	public boolean checkDoubleId(String id) throws Exception {
		Member mem = memberDAO.selectMember(id);
		if(mem==null) return false;
		
		return true;
	}

}
