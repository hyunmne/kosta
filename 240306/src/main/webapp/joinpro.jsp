<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="bean.User" scope="page" />
<jsp:setProperty name="user" property="*" /> <!-- 전체 가져올 때... -->
<!-- User  객체의 id값(property)을 param(id)로 할당한다. -->
<%--
<jsp:setProperty name="user" property="id" param="id" />
<jsp:setProperty name="user" property="name" param="name" />
<jsp:setProperty name="user" property="password" param="password" />
<jsp:setProperty name="user" property="email" param="email" />
<jsp:setProperty name="user" property="address" param="addresss" />
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinPro.jsp</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><jsp:getProperty name="user" property="id" /></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><jsp:getProperty name="user" property="name" /></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><jsp:getProperty name="user" property="password" /></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><jsp:getProperty name="user" property="email" /></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><jsp:getProperty name="user" property="address" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="회원가입"></td>
		</tr>
	</table>
</body>
</html>