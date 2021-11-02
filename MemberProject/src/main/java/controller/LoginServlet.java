package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import vo.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	// 1. ��û�ؼ� ���޵� ��Ű��ü���� ����
    	Cookie[] cookieArray = request.getCookies();
    	
    	// 2. ���޵� ��Ű �߿� idCookie�� passwordCookie�� ã�´�.
    	String memberId = "";
    	String memberPassword = "";
    	
    	if(cookieArray != null) {
    		//�ּ��� ��Ű������ �ϳ��� �Ѿ������...
    	for (int i=0; i < cookieArray.length; i++) {
    		//cookieName = cookieValue;...........
    		if(cookieArray[i].getName().equals("memberId")) {
    			memberId = cookieArray[i].getValue();
    		}
    		else if(cookieArray[i].getName().equals("memberPassword")) {
    			memberPassword = cookieArray[i].getValue();
    		}
    	}
    	}
    	//�����Ͻ� ������ ��Ʈ�ѷ��� �����ϸ� �ȵ�
    			//�����Ͻ� ������ �𵨿������� ����
    			LoginService loginService = new LoginService();
    			
    			//�α��ο� �����ϸ� ȭ�鿡 �α��ο� ������ ȸ���� ������ ���
    			
    			//�α��ο� �����ϸ� �α��ε� ȸ������ �ϳ��� ��ȯ�ϰ�, �α��ο� �����ϸ� null ��ȯ
    			MemberVO loginMember = loginService.getLoginMember(memberId, memberPassword);
    			
    			if(loginMember != null) {
    				//�������� ����� �����ϴ� ���
    				//1.�Ӽ� ��� ���
    				//1-1. �Ӽ�����
    				//������ü.setAttribute(String attrName, Object attrValue)
    				//����(Scope)
    				//page : ���������������� ����
    				//request : ���� ��û�� ó���ϴ� ��� ���������� ����
    				//session : �ϳ��� �����(������)�� �Ҵ�Ǵ� ����
    				//application : ���� ���ø����̼� ������ ��� ����
    				
    				request.setAttribute("loginMember", loginMember);
    				
    				//2.�ʱ�ȭ �Ķ���� ��� ���
    				
    				//�� �������� ������
    				//�������� ������ ���
    				//1. ����ġ
    				//������ ��ȯ�� �����󿡼� �̷����
    				//�ּ� ǥ���ٻ��� ��û URL�� ������� ���� ��, /login ���� �Ǿ�����
    				//����, ��û(request)�� ������� �ʴ´�.
    				RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
    				dispatcher.forward(request, response);
    			}
    			else {
    				//���������� ������ �ϴ� ���
    				//2. �����̷�Ʈ ����� ������
    				//������ ��ȯ�� Ŭ���̾�Ʈ���� �����
    				//��, �ּ�ǥ������ �ּҰ� ���������� �������Ǵ� URL�� ����
    				//request�� �������� �ʴ´�.
    				
    				response.sendRedirect("loginForm.html");
    			}
    	
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = request.getParameter("memberId");
		String memberPassword = request.getParameter("memberPassword");
		String cookieUse = request.getParameter("cookieUse");
		
		/*
		if(cookieUse != null) {
			Cookie idCookie = new Cookie("memberId", memberId);
			
			//Cookie ��ü�� �����ϸ� �⺻ ���� �Ⱓ�� -1�� ������
			//��, �������� ����Ǿ� �������� ��Ű�� ���������� �������� �����ϸ� ��� �Ҹ��
			//����, �����Ⱓ�� ��������� �����ؾ���
			idCookie.setMaxAge(24 * 60 *60);//������ ��
			response.addCookie(idCookie);
			
			Cookie passwordCookie = new Cookie("memberPassword", memberPassword);
			
			//Cookie ��ü�� �����ϸ� �⺻ ���� �Ⱓ�� -1�� ������
			//��, �������� ����Ǿ� �������� ��Ű�� ���������� �������� �����ϸ� ��� �Ҹ��
			//����, �����Ⱓ�� ��������� �����ؾ���
			passwordCookie.setMaxAge(24 * 60 *60);//������ ��
			response.addCookie(passwordCookie);
		}
		*/
		
		
		//�����Ͻ� ������ ��Ʈ�ѷ��� �����ϸ� �ȵ�
		//�����Ͻ� ������ �𵨿������� ����
		LoginService loginService = new LoginService();
		
		//�α��ο� �����ϸ� ȭ�鿡 �α��ο� ������ ȸ���� ������ ���
		
		//�α��ο� �����ϸ� �α��ε� ȸ������ �ϳ��� ��ȯ�ϰ�, �α��ο� �����ϸ� null ��ȯ
		MemberVO loginMember = loginService.getLoginMember(memberId, memberPassword);
		
		if(loginMember != null) {
			//�������� ����� �����ϴ� ���
			//1.�Ӽ� ��� ���
			//1-1. �Ӽ�����
			//������ü.setAttribute(String attrName, Object attrValue)
			//����(Scope)
			//page : ���������������� ����
			//request : ���� ��û�� ó���ϴ� ��� ���������� ����
			//session : �ϳ��� �����(������)�� �Ҵ�Ǵ� ����
			//application : ���� ���ø����̼� ������ ��� ����
			
			//request.setAttribute("loginMember", loginMember);
			
			//2.�ʱ�ȭ �Ķ���� ��� ���
			
			//�� �������� ������
			//�������� ������ ���
			//1. ����ġ
			//������ ��ȯ�� �����󿡼� �̷����
			//�ּ� ǥ���ٻ��� ��û URL�� ������� ���� ��, /login ���� �Ǿ�����
			//����, ��û(request)�� ������� �ʴ´�.
//			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
//			dispatcher.forward(request, response);
			
			//������ �̿��� �α��� ó��
			HttpSession session = request.getSession();
			session.setAttribute("memberId", memberId);
			response.sendRedirect("index.jsp");
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginFail.jsp");
			dispatcher.forward(request, response);
		}
	}

}
