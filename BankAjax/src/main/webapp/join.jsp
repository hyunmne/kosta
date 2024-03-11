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
        width: 320px;
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
    #submit {
        font-weight: bold;
        width: 120px;
        background-color: lightgray;
        display: block;
        margin: 0 auto;
    }
</style>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function(){
		$('#doubleId').click(function(e){
			e.preventDefault();
			$.ajax({
				url:'memberDoubleId', // 보내는 url
				type:'post', // doPost 방식
				async:true,
				dataType:'text',
				data:{id:$('#id').val()}, // 사용자가 입력한 값(id)를 받아옴
				success:function(result){
					if(result=='true'){
						alert("아이디가 중복됩니다.");
					} else {
						alert("사용 가능한 아이디입니다.")
					}
				},
				error:function(result){
					
				}
			})
		})
		
		$("#submit").click(function(e){
			var mem = {};
			mem.id = $('#id').val();
			mem.name = $('#name').val();
			mem.password = $('#password').val();
			mem.email = $('#email').val();
			mem.address = $('#address').val();
			console.log(mem);
			
			$.ajax({
				url:'login',
				type:'post',
				async:true,
				data:{mem:JSON.stringify(mem)},
				success:function(result){
					alert(result);
					if(result==true){
						location.href="main"
					} else {
						alert(result)
					}
				},
				error:function(err){
					alert("회원가입에 실패하셨습니다.");
				}
			})
		})
	})
</script>
</head>
<body>
<%@ include file="header.jsp" %>
   <div class="header"><h3>회원가입</h3></div>
   <div class="container">
      <div class="row">
         <div class="title">아이디</div>
         <div class="input"><input type="text" name="id" id="id"/></div>&nbsp;
         <button id="doubleId">중복</button>
      </div>
      <div class="row">
         <div class="title">이름</div>
         <div class="input"><input type="text" name="name" id="name"/></div>
      </div>
      <div class="row">
         <div class="title">비밀번호</div>
         <div class="input"><input type="password" name="password" id="password"/></div>
      </div>
      <div class="row">
         <div class="title">이메일</div>
         <div class="input"><input type="text" name="email" id="email"/></div>
      </div>
      <div class="row">
         <div class="title">주소</div>
         <div class="input"><input type="text" name="address" id="address"/></div>
      </div>
      <div class="button">
         <button id="submit">회원가입</button>
      </div>
   </div>
</body>

</html>