<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>withdraw</title>
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
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
    	$(function() {
    		$("#submit").click(function(){
    			var withdraw = {}
    			withdraw.id = $("#id").val();
    			withdraw.money = +$("#money").val();
    			$.ajax({
    				url:"withdraw",
    				type:"post",
    				async:true,
    				data:{withdraw:JSON.stringify(withdraw)},
    				success : function(result){
    					alert(result);
    					$("#id").val("");
    					$("#money").val("");
    				},
    				error : function(err) {
    					alert("출금에 실패했습니다.")
    				}
    			})
    		})
    	})
    </script>
</head>
<body>
	<%@include file="header.jsp"%>
        <div class="header"><h3>출 금</h3></div>
        <div class="container">
            <div class="row">
                <div class="title">계좌번호</div>
                <div class="input"><input type="text" name="id" id="id"></div>
            </div>
            <div class="row">
                <div class="title">출금액</div>
                <div class="input"><input type="text" name="money" id="money"></div>
            </div>

            <div class="button" style="margin-left:120px">
                <button id="submit">출 금</button>
            </div>
        </div>
</body>
</html>