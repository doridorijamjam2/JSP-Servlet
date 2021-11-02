<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String memberId = (String)session.getAttribute("memberId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(memberId != null) {
	%>
		<a href = "logout.me">로그아웃</a>
	<% 		
		}
		else {
	%>
		<a href = "logForm.html">로그인</a>
	<%
		}
	%>
</body>
</html>