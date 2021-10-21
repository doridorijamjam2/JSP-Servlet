package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;
import vo.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = request.getParameter("memberId");
		String memberPassword = request.getParameter("memberPassword");
		
		//비지니스 로직은 컴트롤러에 구현하면 안됨
		//비즈니스 로직은 모델영역에서 구현
		LoginService loginService = new LoginService();
		
		//로그인에 성공하면 화면에 로그인에 성공한 회원의 정보를 출력
		
		//로그인에 성공하면 로그인된 회원정보 하나를 반환하고, 로그인에 실패하면 null을 반환
		MemberVO loginMember = loginService.getLoginMember(memberId,memberPassword); 
		
		if(loginMember != null) {
			//서블릿에서 데이터 공유하는 방법
			//1. 속성 사용 방법
			//1-1. 속성 공유
			//영역객체.setAttribute(String attrName, Object attrValue)
			//영역(Scope)
			//page : 동일페이지에서만 공유
			//request : 동일 요청을 처리하는 모든 페이지에서 공유
			//session : 하나의 사용자(브라우저)당 할당되는 영역
			//application : 동일 애플리케이션에서는 모두 공유
			
			request.setAttribute("loginMember", loginMember);
			
			
			//2. 초기화 파라미터 사용 방법
			
			//뷰페이지로 포워딩
			//서블릿에서 포워딩 방식
			//1. 디스패치
			//페이지 전환이 서버상에서 이루어짐
			//주소 표시줄상의 요청 URL이 변겅되지 않음 즉, /login 으로 되어있음
			//따라서, 요청(request)가 변경되지 않는다.
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginFail.jsp");
			dispatcher.forward(request, response);
		}
	}
}