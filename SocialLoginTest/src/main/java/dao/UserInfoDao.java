package dao;

import dto.UserInfo;

public interface UserInfoDao {
	UserInfo selectUserInfo(Long id) throws Exception;
	void insertUserInfo(UserInfo user) throws Exception;
}
