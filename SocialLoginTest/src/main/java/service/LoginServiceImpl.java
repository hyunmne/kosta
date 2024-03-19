package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import dao.UserInfoDao;
import dao.UserInfoDaoImpl;
import dto.UserInfo;

public class LoginServiceImpl implements LoginService {
	
	private UserInfoDao userDao;
	
	public LoginServiceImpl() {
		userDao = new UserInfoDaoImpl();
	}

	@Override
	public UserInfo kakaoLogin(String code) throws Exception {
		String token = getKakaoToken(code);

		UserInfo userInfo = getKakaoUserInfo(token);
		
		//Database 
		UserInfo dbUserInfo = userDao.selectUserInfo(userInfo.getId());
		if(dbUserInfo == null) {
			userDao.insertUserInfo(dbUserInfo);
		}

		return userInfo;
	}

	String getKakaoToken(String code) throws Exception {
		String urlStr = "https://kauth.kakao.com/oauth/token";
		// 특정 URL을 가지고 오는 connection
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true); // 출력 스트림 활성화 (파라미터 body 영역에 넣기 위해)
		
		// 파라미터 생성
		StringBuilder param = new StringBuilder();
		param.append("grant_type=authorization_code");
		param.append("&client_id=4543b941cf5a7b6dcf3fab42a1dc3c1e");
		param.append("&redirect_url=http://localhost:8080/test/kakao");
		param.append("&code="+code);
		
		// bufferedwriter... ? 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		bw.write(param.toString());
		bw.flush();
		
		BufferedReader br;
		int resultCode = conn.getResponseCode();
		if(resultCode>=200 && resultCode<=300) { // 정상
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else { // error
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder resBuilder = new StringBuilder();
		String line;
		while ((line=br.readLine())!=null) {
			resBuilder.append(line);
		}
		br.close();
		conn.disconnect();
		
		System.out.println(resBuilder.toString());
		
		JSONParser parser = new JSONParser();
		JSONObject tokenObj = (JSONObject) parser.parse(resBuilder.toString());
		String token = (String) tokenObj.get("access_token");

		return token;
	}

	UserInfo getKakaoUserInfo(String token) throws Exception{
		String urlStr = "https://kapi.kakao.com/v2/user/me";
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization", "Bearer "+token);
		
		BufferedReader br;
		int resultCode = conn.getResponseCode();
		if (resultCode >= 200 && resultCode<= 300) { // 정상
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else { // error
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder resBuilder = new StringBuilder();
		String line;
		while((line=br.readLine())!=null) {
			resBuilder.append(line);
		}
		
		br.close();
		conn.disconnect();
		
		System.out.println(resBuilder.toString());
		JSONParser parser = new JSONParser();
		
		JSONObject userObj = (JSONObject) parser.parse(resBuilder.toString());
		Long id = (Long)userObj.get("id");
		JSONObject properties = (JSONObject) userObj.get("properties");
		String nickname = (String)properties.get("nickname");
		String profile_image = (String)properties.get("profile_image");
		String thumbnail_image = (String)properties.get("thumbnail_image");
		
		UserInfo userInfo = new UserInfo(id,nickname,profile_image,thumbnail_image);
		
		return userInfo;
	}

}
