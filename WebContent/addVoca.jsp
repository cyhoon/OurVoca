<%@page import="domin.User"%>
<%@page import="domin.Voca"%>
<%@page import="java.util.List"%>
<%@page import="service.UserService"%>
<%
	User user = (User)session.getAttribute("user");
	
	if ( user == null ) {
		response.sendRedirect("login.jsp");
		return;
	}
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> add voca </title>
<style>
	* { text-align: center; }
</style>
</head>
<body>
	<form method="POST" action="addVocaServlet">
		
		<!--  
		
			제목, 단어장 설명, 유저 이메일 
		
		 -->
		 제목 : <input type="text" name="title" /> <br>
		 단어장 설명 : <input type="text" name="desc" /> <br>
		 유저 아이디 : <span><%= user.getEmail() %></span> <br>
		
		<input type="submit" value="입력" />
		
	</form>
</body>
</html>