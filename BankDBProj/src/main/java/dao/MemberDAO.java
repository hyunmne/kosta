package dao;

import dto.Member;

public interface MemberDAO {
	void insertMember(Member mem) throws Exception;  // 멤버 생성
	Member selectMember(String id) throws Exception; // 멤버 조회
	
}