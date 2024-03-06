<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward Test2</title>
</head>
<body>
<h2>forward page(forwardTest2.jsp)</h2>
<table>
	<tr>
		<td>이름</td>
		<td><%=request.getParameter("name") %></td>
	</tr>
	<tr>
		<td>나이</td>
		<td><%=request.getParameter("age") %></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><%=request.getParameter("address") %></td>
	</tr>
</table>
<jsp:include page='<%= request.getParameter("includePage") %>'></jsp:include>
<%-- <%pageContext.include(request.getParameter("includePage")); %> --%>
</body>
</html>