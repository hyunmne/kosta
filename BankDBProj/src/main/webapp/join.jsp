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
            width: 260px;
            padding: 10px;
        }
</style>
</head>
<body>
<% pageContext.include("header.jsp"); %>
<div class="header"><h3>회원가입</h3></div>
<form action="join" method="post" class="container">
	<table border="1">
		<tr><th>아이디</th><td> <input type="text" name="id"> </td></tr>
		<tr><th>이름</th><td> <input type="text" name="name"> </td></tr>
		<tr><th>비밀번호</th><td> <input type="password" name="password"> </td></tr>
		<tr><th>이메일</th><td> <input type="text" name="email"> </td></tr>
		<tr><th>주소</th><td> <input type="text" name="address"> </td></tr>
		<tr><td colspan="2"><input type="submit" value="회원가입"></td></tr>
	</table>
</form>
</body>
</html>