<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vo.Account"%>
<%
	Account acc = (Account)request.getAttribute("acc"); // makeAccount에서 넘겨준 값을 받아옴 
%>
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
    </style>
</head>
<body>
	<%@ include file="header.jsp" %>
    <div class="header"><h3>계좌조회</h3></div>
	<%if(acc != null) { %>
    <div class="container">
        <div class="row">
            <div class="title">계좌번호</div>
            <div class="input"><input type="text" disabled value=<%=acc.getId() %>></div>
        </div>
        <div class="row">
            <div class="title">이름</div>
            <div class="input"><input type="text" disabled value=<%=acc.getName() %>></div>
        </div>
        <div class="row">
            <div class="title">입금액</div>
            <div class="input"><input type="text" disabled value=<%=acc.getBalance() %>></div>
        </div>
        <div class="row">
            <div class="title">종류</div>
            <div class="input"><input type="text" disabled value=<%=acc.getType() %>></div>
        </div> 
        <div class="row">
            <div class="title">등급</div>
            <div class="input"><input type="text" disabled value=<%=acc.getGrade() %>></div>
        </div>
    </div>
        <% } %>
</body>
</html>