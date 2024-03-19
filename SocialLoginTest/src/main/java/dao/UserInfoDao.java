package dao;

import dto.UserInfo;

public interface UserInfoDao {
	UserInfo selectUserInfo(String id) throws Exception;
	void insertUserInfo(UserInfo user) throws Exception;
}
