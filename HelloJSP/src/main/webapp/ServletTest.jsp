<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@page import="java.util.Calendar" %>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%
Calendar c = Calendar.getInstance();
int hour = c.get(Calendar.HOUR_OF_DAY);
int minute = c.get(Calendar.MINUTE);
int second = c.get(Calendar.SECOND);
%>
</head>
<body>
<h1>���� �ð��� <%=hour %>�� <%=minute %>�� <%=second %>�� �Դϴ�.</h1>
</body>
</html>