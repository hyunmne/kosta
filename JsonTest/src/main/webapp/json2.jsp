<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function(){
		$("#checkJson").click(function(){
			let obj = {name:['홍길동', '이순신', '임꺽정']};
			console.log(obj)
			
			let jsonArr = JSON.stringify(obj);
			console.log(jsonArr);
			
			let nameArr = JSON.parse(jsonArr);
			let output="회원이름<br>===========<br>"
			nameArr.name.forEach(function(item){
				output += item+"<br>"
			})
			$('#output').html(output);
		})
	})
</script>
</head>
<body>
	<a id="checkJson">출력</a><br><br>
	<div id='output'></div>
</body>
</html>