<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//쿠키를 사요해서 로그인 처리를 했는데 로그아웃을 한다는 의미는 로그인 정보를 저장한 쿠키를 제거한다는 것임
	Cookie[] cookieArray = request.getCookies();
	if(cookieArray != null){
		for(int i = 0; i < cookieArray.length; i++){
			if(cookieArray[i].getName().equals("login")){
				//쿠키를 제거한다는 의미는 해당 쿠키의 생존기간을 0으로 준다는 의미
				cookieArray[i].setMaxAge(0);
				response.addCookie(cookieArray[i]);
				response.sendRedirect("cookieLoginCheck.jsp");
			}
		}
	}
	%>
	

</body>
</html>