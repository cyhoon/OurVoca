<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> sign up </title>
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

	회원가입

	<form method="POST" action="UserSignupServlet">
		email <input type="text" name="email"><br>
		pass <input type="password" name="pass"><br>
		name <input type="text" name="name"><br>
		age	<input type="text" name="age"><br>
		<input type="submit" value="가입하기">
	</form>
	
</body>
</html>