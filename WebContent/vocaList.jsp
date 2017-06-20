<%@page import="domin.Voca"%>
<%@page import="java.util.List"%>
<%@page import="service.UserService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	UserService service = UserService.getInstance();
	List<Voca> list = service.vocaList("*");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title> voca list </title>
<style>
	*{ text-align: center; }
</style>
</head>
<body>
	<%
		if (list.size() == 0){
	%>
		<p>단어장이 없습니다.</p>
	<%
		}else{
	%>
		
			<table>
				<tr>
					<th>단어장 번호</th>
					<th>단어장 제목</th>
					<th>단어장  설명</th>
					<th>작성자</th>
					<th>추천</th>
					<th>조회수</th>
					<th>만든 날짜</th>
				</tr>
	<%
		for (Voca item: list){
	%>
				<tr>
					<td><a href="word.jsp?voca_pk=<%= item.getVoca_pk() %>" /><%= item.getVoca_pk() %></td>
					<td><%= item.getTitle() %></td>
					<td><%= item.getVoca_desc() %></td>
					<td><%= item.getUser_email() %></td>
					<td><%= item.getRecommend() %></td>
					<td><%= item.getViews() %></td>
					<td><%= item.getC_date() %></td>
				</tr>
	<%
		}
	%>
			</table>
	
	<%
		}
	%>
	
	<a href="addVoca.jsp"><button>단어장 추가</button></a>
	
</body>
</html>