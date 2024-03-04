<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
/* 클래스 내에 선언된다. = 선언문 */
	int age = 20;
	String name = "hong";
	String info() {
		return String.format("name:%s, age:%d", name, age);
	}
%>
<%
/* 함수에 선언된다. */
	int lage = 30;
	String lname = "gildong";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>