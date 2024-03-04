<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>allAccountList</title>
    <style>
        .header {
            text-align: center;
        }
        .container {
            width: 600px;
            border: 1px solid;
            margin: 0 auto;
        }
        .row{
            height: 40px;
            border-top: 1px solid;
        }
        .title {
            text-align: center;
            font-weight: bold;
            background-color: lightgray;
        }
        .column{
            width: 100px;
            height: 100%;
            float: left;
            text-align: center;
            line-height: 40px;
        }

    </style>
</head>
<body>
	<%@include file="header.jsp"%>
    <form action="">
        <div class="header"><h3>전체 계좌 조회</h3></div>
        <div class="container">
            <div class="row">
                <div class="title column">순서</div>
                <div class="title column">계좌번호</div>
                <div class="title column">이름</div>
                <div class="title column">입금액</div>
                <div class="title column">종류</div>
                <div class="title column">등급</div>
            </div>
            <div class="row">
                <div class="column">1</div>
                <div class="column">1001</div>
                <div class="column">홍길동</div>
                <div class="column">VIP</div>
                <div class="column">58000</div>
                <div class="column">일반</div>
            </div>
        </div>
    </form>
</body>
</html>