<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<c:set var="test" value="Hello JSTL!" />
<c:out value="${test }" />
<br>

<c:remove var="test" />
<c:out value="${test }" />
<br>

<c:catch var="err">
	<%=10/0 %>
</c:catch>
<c:out value="${err }" />

<c:if test="${5<10 }" >
	<h3>5는 10보다 작다 (true면 실행된다.)</h3>
</c:if>

<c:choose>
	<c:when test="${5+10==50 }">
		<h3>5+10은 50이다. (true면 실행된다.)</h3>
	</c:when>
	<c:otherwise>
		<h3>5+10은 50이 아니다. (false면 실행된다. / else if 개념)</h3>
	</c:otherwise>
</c:choose>

</body>
</html> 