<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cookieHeader = request.getHeader("Cookie");
	boolean autoLogin = false;
	String id = "";
	String password = "";
	if(cookieHeader!=null){
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("autoLogin")) {
				if (cookie.getValue().equals("true"))
					autoLogin = true;
				else autoLogin = false;
			} else if (cookie.getName().equals("id")) {
				id = cookie.getValue();
			} else if (cookie.getName().equals("password")) {
				password = cookie.getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kosta Bank Login</title>
<style type="text/css">
    .header {
        text-align: center;
    }
    .container {
        margin: 0 auto;
        border: 1px solid;
        width: 280px;
        padding: 10px;
    }
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function(){
		$("#submit").click(function(){
			var login = {}
			login.id = $("#id").val();
			login.password = $("#password").val();
			login.autologin = $("#autologin").is(":checked");
			console.log(login);
			
			$.ajax({
				url:'login',
				type:'post',
				async:true,
				data:{login:JSON.stringify(login)},
				success:function(result){
					if(result=='true'){
						location.href="main";
					}
					else {
						alert(result);
					}
				},
				error:function(result){
					alert("로그인 실패")
				}
			})
		})
	})
</script>
</head>
<body>
<% pageContext.include("header.jsp"); %>
<div class="header"><h3>로그인</h3></div>
	<table border="1" class="container">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="<%=id%>" id="id"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" value="<%=password%>" id="password"/></td>
		</tr>
		<tr>
			<td colspan="2">
			<%if(autoLogin) { %>
				<input type="checkbox" value="true" id="autologin" name="autoLogin" checked="checked"/>자동 로그인
			<%} else { %>
				<input type="checkbox" value="false" id="autologin" name="autoLogin" />자동 로그인
			<%} %>
			</td>
		</tr>
		<tr>
			<td colspan="2"><button id="submit" style="margin-left:100px">로그인</button></td>
		</tr>
	</table>
</body>
</html>