<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.Member" %>
<%
	Member mem = (Member) request.getAttribute("mem");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
    <style>
        .header {
            text-align: center;
        }
        .container {
            width: 280px;
            border: 1px solid black;
            padding: 10px;
            margin: 0 auto;
        }
        .row {
            height: 30px;
        }
        .title {
            float: left;
            width: 70px;
            text-align: center;
            font-weight: bold;
        }
        .input {
            float: left;
        }
        input[type='submit'] {
            font-weight: bold;
            width: 120px;
            background-color: lightgray;
            display: block;
            margin: 0 auto;
        }
    </style>
</head>
<body>

<%@ include file="header.jsp" %>
<form action="join" method="post">
<h1>회원가입</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" id="id"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" id="name" name="name"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="password" id="password"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" id="email"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="address" id="address"></td>
		</tr>
		<tr>
			<td><input type="submit" value="가입"></td>
		</tr>
	</table>
</form>
</body>
</html>