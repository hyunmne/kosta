<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "";
	String value = "";
	String cookieHeader = request.getHeader("Cookie"); // 클라이언트가 전송한 cookie 정보 저장
	if(cookieHeader != null){ 
		Cookie[] cookies = request.getCookies(); // 받은 cookie 정보 모두 저장
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("myproduct")) {
				name = cookie.getName();
				value = cookie.getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie Test</title>
</head>
<body>
<h3>쿠키 이름 = <%=name %></h3>
<h3>쿠키 값 = <%=value %></h3>
</body>
</html>