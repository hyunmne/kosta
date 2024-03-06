<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>include action test</h2>
<jsp:include page="includeTest1.jsp">
	<jsp:param value="honggildong" name="name"/>
	<jsp:param value="50" name="age"/>
</jsp:include>
<h3>서울시 금천ㄱ.. </h3>
</body>
</html>