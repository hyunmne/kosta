<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Account Info</title>
<style>
.header {
	text-align: center;
}

.container {
	margin: 0 auto;
	border: 1px solid;
	width: 320px;
	padding: 10px;
}

.row {
	height: 30px;
}

.title {
	float: left;
	width: 80px;
	font-weight: bold;
	text-align: center;
}

.input {
	float: left;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function(){
	$('#query').click(function(){ // 조회버튼 클릭 시
		$.ajax ({
			url: 'accountInfo', // 요청할 URL
	        type: 'post',
	        async: true,
	        data: {id: $("#id").val()},
	        success: function(data) {
	            var acc = JSON.parse(data); // Stringify와 반대로 문자를 json 객체로 바꿔주는 역할
	            console.log(acc);
	            $("#name").val(acc.name);
	            $("#balance").val(acc.balance);
	            $("#type").val(acc.type);
	            $("#grade").val(acc.grade);
	        },
			error:function(err){
				alert("존재하지 않는 계좌번호 입니다.");
			}
		})
	})
})
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="header">
		<h3>계좌조회</h3>
	</div>
	<div class="container">
		<div class="row">
			<div class="title">계좌번호</div>
			<div class="input">
				<input type="text" id="id">
				<button id="query">조회</button>
			</div>
		</div>
		<div class="row">
			<div class="title" >이름</div>
			<div class="input">
				<input type="text" disabled id="name">
			</div>
		</div>
		<div class="row">
			<div class="title" >입금액</div>
			<div class="input">
				<input type="text" disabled id="balance">
			</div>
		</div>
		<div class="row">
			<div class="title" >종류</div>
			<div class="input">
				<input type="text" disabled id="type">
			</div>
		</div>
		<div class="row">
			<div class="title" >등급</div>
			<div class="input">
				<input type="text" disabled id="grade">
			</div>
		</div>
	</div>
</body>
</html>