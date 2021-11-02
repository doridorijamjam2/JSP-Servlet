<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 아이디와 비밀번호가 같으면 로그인 되었다고 처리할것임 -->
	<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");

	if (id.equals(passwd)) {
		//쿠키로 로그인 처리한다는 의미는 로그인이 성공했을때 쿠키에 로그인 정보를 저장하겠다는 의미
		Cookie loginCookie = new Cookie("login", "OK");
		response.addCookie(loginCookie);
		response.sendRedirect("cookieLoginCheck.jsp");
	} else {
	%>
	<script>
		alert('로그인 실패');
		history.back();
	</script>
	<%
	}
	%>

</body>
</html>