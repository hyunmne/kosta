<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.User" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<User> users = new ArrayList<>();
	users.add(new User("hong", "홍길동", "1234", "hong@kosta.com", "seoul"));
	users.add(new User("gong", "공길동", "1234", "gong@kosta.com", "daejeon"));
	users.add(new User("pong", "퐁길동", "1234", "pong@kosta.com", "busan"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core 2</title>
</head>
<body>
<!-- 1(begin)부터 10(end)까지 1(step)씩 증가  -->
<c:forEach var="test" begin="1" end="10" step="2"> 
	<b>${test}</b>&nbsp;
</c:forEach>
<br>
	<table border="1">
		<tr>
			<th>순번</th>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>주소</th>
		</tr>
		<c:forEach var="user" items="<%=users %>" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.password }</td>
				<td>${user.email }</td>
				<td>${user.address }</td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- 글자를 delims 기준으로 자르기  -->
<br>
<c:forTokens items="홍길동#김길동#하길동#송길동#고길동" delims="#" var="name">
	<b>${name }</b>&nbsp;
</c:forTokens>

<br>
<c:set var="fruitList" value="apple,banana,orange,strawberry"/>
<c:forTokens items="${fruitList }" delims="," var="fruit">
	<b>${fruit }</b>&nbsp;
</c:forTokens>

</body>
</html>