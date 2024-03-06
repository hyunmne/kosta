<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
        .header {
            text-align: center;
        }
        .container {
            margin: 0 auto;
            border: 1px solid;
            width: 280px;
            padding: 10px;
        }</style>
</head>
<body>
<% pageContext.include("header.jsp"); %>
<div class="header"><h3>로그인</h3></div>
<form action="login" method="post">
	<table border="1" class="container">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="로그인"/></td>
		</tr>
	</table>
</form>
</body>
</html>