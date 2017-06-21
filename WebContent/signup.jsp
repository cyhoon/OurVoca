<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> sign up </title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="./assets/css/signup.css">
<script type="text/javascript">
	
	var message = "${message}";
	var code = "no-data";
	
	if(message.length>0){
		
		code = ${code};
		
		if ( code ) {
			alert(message);
			location.href = "home.jsp";
		} else {
			alert( message );
		}
		
	}
	
</script>
</head>
<body>
	<div class="container logo">
		<img src="./assets/logo/logo.png" style="width: 100%;">
	</div>

	<div class="container wrap">
	
		<form action="UserSignupServlet" method="POST">
			
			<div class="form-group">
		    	<label for="user_id" class="font-color">이메일 주소</label>
		    	<input type="email" class="form-control" id="user_id" name="email" placeholder="이메일을 입력하세요">
		  	</div>
		  	<div class="form-group">
		    	<label for="user_pw" class=font-color>암호</label>
		    	<input type="password" class="form-control" id="user_pw" name="pass" placeholder="비밀번호를 입력하세요">
		  	</div>
		  	<div class="form-group">
		    	<label for="user_name" class=font-color>이름</label>
		    	<input type="text" class="form-control" id="user_name" name="name" placeholder="이름을 입력하세요">
		  	</div>
		  	<div class="form-group">
		    	<label for="user_age" class=font-color>나이</label>
		    	<input type="text" class="form-control" id="user_age" name="age" placeholder="나이를 입력하세요">
		  	</div>
			
			<button type="submit" class="btn btn-default signUpBtn">회원가입</button>
			
		</form>
		
	</div>
	<div class="middle">
		<a href="login.jsp">로그인 하러가기</a>
	</div>
	
</body>
</html>