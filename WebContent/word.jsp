<%@page import="domin.Word"%>
<%@page import="java.util.List"%>
<%@page import="service.UserService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	int voca_fk = Integer.parseInt(request.getParameter("voca_pk"));

	UserService userService = UserService.getInstance();
	List<Word> list = userService.wordList(voca_fk);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> word list </title>
<style>
	table { width: 1920px; margin: 0 auto; }
	*{ text-align: center; }
</style>
</head>
<body>
	<%
		if ( list.size() == 0 ) {
	%>
		<p> 단어가 없습니다. </p>
	<%
		} else {
	%>
		
		<table>
			<tr>
				<th>영단어</th>
				<th>단어 뜻</th>
			</tr>
		<%
			for(Word item: list) {
		%>
			<tr>
				<td><%= item.getWord() %></td>
				<td><%= item.getMean() %></td>
			</tr>
		<%
			}
		%>
		</table>
		
	<%
		}
	%>
</body>
</html>