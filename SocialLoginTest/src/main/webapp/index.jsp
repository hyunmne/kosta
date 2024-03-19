<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${userInfo ne Empty}">
<b>${userInfo.nickname }</b>&nbsp;&nbsp;&nbsp;
<img src="${userInfo.thumbnailImg }" width="50px" height="50px" /><br>
<img src="${userInfo.profileImg }" /> 
</c:when>
<c:otherwise>
	<a style="margin-left:50px;" href="https://kauth.kakao.com/oauth/authorize?client_id=4543b941cf5a7b6dcf3fab42a1dc3c1e
	&redirect_uri=http://localhost:8080/test/kakao&response_type=code">
		<img src='<c:url value="/image/kakao_login_medium_narrow.png"/>' />
	</a>
</c:otherwise>
</c:choose>
</body>
</html>