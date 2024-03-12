<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style type="text/css">
h3 {
	text-align: center;
}

table {
	margin: auto;
	width: 800px;
}

#tr_top {
	background: orange;
	text-align: center;
}

#emptyArea {
	margin: auto;
	width: 800px;
	text-align: center;
}

#emptyArea a {
	display: inline-block;
	width: 20px;
	height: 20px;
	text-decoration: none;
}
#emptyArea .btn {background:lightgray;}
#emptyArea .select {background:lightblue;}
</style>
</head>
<body>
	<h3>글 목록</h3>
	<table>
		<tr id="tr_top">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
			<c:forEach items="${boardList }" var="board">
				<tr style="text-align:center;">
					<td>${board.num }</td>
					<td><a href="boardDetail?num=${board.num }">${board.subject }</a></td>
					<td>${board.writer}</td>
					<td>${board.writedate }</td>
					<td>${board.viewcount }</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<div id="emptyArea">
		<a>&lt;</a>
		<c:forEach begin="${pageInfo.startPage }" end="${pageInfo.endPage }" var="i">
			<c:choose>
				<c:when test="${i==pageInfo.curPage }">
					<a href="boardList?page=${i}" class="select">${i }</a>
				</c:when>
				<c:otherwise>
					<a href="boardList?page=${i}" class="btn">${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<a>&gt;</a>
	</div>
</body>
</html>