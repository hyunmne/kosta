<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward Test</title>
</head>
<body>
<h2>forward action test</h2>
<form action="forwardTest1.jsp" method="post">
<!-- 	forwardTest2로 값은 넘기지만 보여주지는 않는다. (hidden) -->
	<input type="hidden" name="forwardPage" value="forwardTest2.jsp">
	<input type="hidden" name="includePage" value="includeTest2.jsp">
	<table border="1">
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" ></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" ></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="address" ></td>
		</tr>
	</table>

		<table border="1">
			<tr>
				<td>기타 등등</td>
				<td><input type="text" name="etc"></td>
			</tr>
		</table>
		<table border="1">
			<tr>
				<td colspan="2"><input type="submit" value="전송"></td>
			</tr>
		</table>
	</form>
</body>
</html>