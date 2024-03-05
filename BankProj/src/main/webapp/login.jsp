<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        .header {
            text-align: center;
        }
        .container {
            margin: 0 auto;
            border: 1px solid;
            width: 280px;
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
<form action="login" method="post">
	<div class="header"><h3>로그인</h3></div>
        <div class="container">
            <div class="row">
                <div class="title">아이디</div>
                <div class="input"><input type="text" name="id"></div>
            </div>
            <div class="row">
                <div class="title">비밀번호</div>
                <div class="input"><input type="password" name="password"></div>
            </div>
            <div class="button">
                <input type="submit" name="submit" value="로그인">
            </div>
        </div>
</form>
</body>
</html>