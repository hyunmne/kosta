<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <style>
        .header {
            text-align: center;
        } 
        .container {
            margin: 0 auto;
            border: 1px solid;
            width: 600px;
            /* padding: 10px; */
        }
        .row {
            height: 40px;
            border-top: 1px solid;
            border-bottom: 1px solid;
        }
        .title {
            font-weight: bold;
            background-color: lightgray;
        }
        .column {
            width: 98px;
            height: 100%;
            float: left;
            line-height: 40px;
            text-align: center;
            border: 1px solid;
        }
    </style>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
    	$(function(){
    		$.ajax ({
    			url:'allAccountInfo',
    			type:'post',
    			async:true,
    			success:function(result){
    				var accs = JSON.parse(result);
    				var i=0;
    				for(var acc of accs){
    					$("#container").append(
    							`<div class="row">
							    	<div class="column">\${++i}</div>
							    	<div class="column">\${acc.id}</div>
							    	<div class="column">\${acc.name}</div>
							    	<div class="column">\${acc.balance}</div>
							    	<div class="column">\${acc.type}</div>
							    	<div class="column">\${acc.grade}</div>
							    </div>`
							    )
    				}
    			},
    			error:function(err){
    				alert("계좌 정보를 불러올 수 없습니다.")
    			}
    		})
    	})
    </script>
</head>
<body>
<%@ include file="header.jsp" %>
		<div class="header">
			<h3>전체 계좌 조회</h3>
		</div>
		<div class="container" id="container">
			<div class="row">
				<div class="title column">순서</div>
				<div class="title column">계좌번호</div>
				<div class="title column">이름</div>
				<div class="title column">입금액</div>
				<div class="title column">종류</div>
				<div class="title column">등급</div>
			</div>
		</div>
</body>
</html>