package service;

import dto.UserInfo;

public interface KakaoLoginService {
	UserInfo kakaoLogin(String code) throws Exception;
}
