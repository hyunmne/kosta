package dao;

import java.util.List;

import dto.Member;

public interface MemberDao {
	void insertMember(Member mem) throws Exception;
	Member selectMember(String id) throws Exception;
}
