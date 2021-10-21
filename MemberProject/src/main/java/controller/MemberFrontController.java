package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.MemberLoginAction;
import vo.ActionForward;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.me")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. ��û�ľ�
		String requestURI = request.getRequestURI();
		//��û URL : http://localhost : 8088/MemberProject/login.me
		//requestURI : /MemberProject/login.me
		
		String contextPath = request.getContextPath();
		//���ø����̼� ���
		//contextPath : /MemberProject
		
		String command = requestURI.substring(contextPath.length());
		System.out.println("command = " + command);
		
		//2. �� ��û�� ��ûó��
		//�������� ����ؼ� 
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/login.me")) {
			action = new MemberLoginAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		//3.forward ��ü�� ������ ����ؼ� ������
		if(forward != null) {
			//��ûó���� ����� ������...
			if(forward.isRedirect()) {
				response.sendRedirect(command);
			}
			else {
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(forward.getUrl());
				dispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		doGet(request, response);
	}

}