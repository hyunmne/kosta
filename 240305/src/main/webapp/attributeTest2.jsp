<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String name = (String) session.getAttribute("name"); // attribute는 object 타입이라 원래의 타입으로 다운캐스팅 해줘야 함.
String id = (String) session.getAttribute("id");
String email = request.getParameter("email");
String address = request.getParameter("address");
String tel = request.getParameter("tel");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%=name%>님 환영합니다.
	</h3>
	<table border="1">
		<tr>
			<th>이름</th>
			<td><%=name %></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%=id %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=email %></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=address %></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%=tel %></td>
		</tr>
	</table>
</body>
</html>