<%@page contentType = "text/html;charset=UTF-8" import = "java.util.Date" 
buffer = "10kb"%><!-- 기본은 8kb -->
<%--
    1. JSP 페이지가 클라이언트에게 컨텐츠를 서비스해주는 절차
    클라이언트가 JSP로 요청을 하면 JSP 코드가 서블릿 형태의 자바코드로 변환된 후
    자바코드가 컴파일된 후 서비스 됨.
    
    %@ : 지시자 영역
    JSP가 자바코드로 변환될 때 변환 정보를 제공하는 영역
    지시자의 종류
    page : 페이지에 관한 정보 제공
    include : 지정한 jsp 코드를 해당 위치에 삽입하라는 지시자
    taglib : JSTL(Java Standard Tag Library)를 사용할 때 접두사를 지정해 주는 지시자
--%>

<%!
   int add(int x, int y){
	   return x + y;
    }
    
    String memberVar = "선언부에 선언하는 변수는 멤버변수임";
    
    
%>

<%--
     선언부: 페이지 전체에서 사용되는 멤버변수나 멤버메소드를 선언하는 부분
 --%>
 
 <%
    String localVar = "스크립트릿에서 선언되는 변수는 로컬변수임";
    out.println("localVar = " + localVar + "<br>");
    
    //out : 내장 객체 : session, application 등과 같이 jsp 내부적으로 자동으로 생성해주는 객체
    
 %>
 <%--
     스크립트릿 영역 : 실직적인 자바 코드(제어문)가 오는 부분, 로컬변수 선언
  --%>
  
  memberVar = <%=memberVar %><br>
  add(10, 10) = <%=add(10, 10) %><br>
  
  <%--
  %= : Expression Tag : 자바 코드로 변환될 때 out.print()로 변환됨
   --%>
   
   <%--
   JSP 페이지에서 사용할수 있는 주석 종류
    --%>
    
    <!-- 
    1. HTML 주석
    자바코드로 변환될 때 일반문자로 변환되고, 클라이언트에 서비스될때 일반문자로 반환됨
    따라서, 브라우저에서 소스보기를 하면 주석이 보임
     -->
     
     <%
     //자바주석
     //자바코드로 변환될때 일반문자열로 변환되지만 컴파일이 되지 않기 때문에 클라이언트로 응답이 되지 않는다.
     %>
     
     <%--
     3.JSP 주석
     자바 코드로 변환 자체가 안됨
      --%>
      
      <%--
      상단에 소개한 요소 + 내장객체 종류들 + EL(Epression Language) + JSTL + 기타 컴포넌트들
       --%>
