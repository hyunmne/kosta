<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>application Test</h2>
<table border="1">
	<tr>
		<td>JSP 버전</td>
		<td><%=application.getMajorVersion() %>.<%=application.getMajorVersion() %></td>
	</tr>
	<tr>
		<td>컨테이너 정보</td>
		<td><%=application.getServerInfo() %></td>
	</tr>
	<tr>
		<td>컨테이너 웹 어플리케이션 실제 파일 시스템 경로</td>
		<td><%=application.getRealPath("/") %></td>
	</tr>
</table>
</body>
</html>