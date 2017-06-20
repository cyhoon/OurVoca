<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%

	String error = request.getParameter("error");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> login </title>
</head>
<body>
	
	로그인

	<form action="UserLoginServlet" method="POST">
		아이디 <input type="text" name="user_id"><br>
		비밀번호 <input type="password" name="user_pw"><br>
		<input type="submit" value="로그인">
	</form>
	
	<%
		if (error != null) {
	%>
		<script> alert("아이디 또는 비밀번호가 일치하지 않습니다."); </script>
	<%
		}
	%>
	
</body>
</html>