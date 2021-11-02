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
       boolean loginOK = false;  
       Cookie[] cookieArray = request.getCookies();
       
       if(cookieArray != null){
    	   for(int i = 0; i< cookieArray.length; i++){
    		   if(cookieArray[i].getName().equals("login")){
    			   loginOK = true;
    		   }
    	   }
       }
       if(loginOK){
    	   
   %>
	<a href="s.jsp">로그아웃</a>

	<%
       }
       else{
    	   
%>
   <a href = "cookieLoginForm.jsp">로그인</a>
<%
       }
%>   

</body>
</html>