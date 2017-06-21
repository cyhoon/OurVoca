<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%

	String error = request.getParameter("error");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title> login </title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="./assets/css/login.css">
</head>
<body>
	
	<div class="container logo">
		<img src="./assets/logo/logo.png" style="width: 100%;">
	</div>

	<div class="container wrap">
	
		<form action="UserLoginServlet" method="POST">
			
			<div class="form-group">
		    	<label for="user_id" class="font-color">이메일 주소</label>
		    	<input type="email" class="form-control" id="user_id" name="user_id" placeholder="이메일을 입력하세요">
		  	</div>
		  	<div class="form-group">
		    	<label for="user_pw" class=font-color>암호</label>
		    	<input type="password" class="form-control" id="user_pw" name="user_pw" placeholder="비밀번호를 입력하세요">
		  	</div>
			
			<button type="submit" class="btn btn-default loginBtn">로그인</button>
			
		</form>
		
	</div>
	<div class="middle">
		<a href="signup.jsp">회원가입 하러가기</a>
	</div>
	
	<%
		if (error != null) {
	%>
		<script> alert("아이디 또는 비밀번호가 일치하지 않습니다."); </script>
	<%
		}
	%>
	
</body>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</html>