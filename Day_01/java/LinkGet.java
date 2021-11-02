

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LinkGet
 */
@WebServlet(name = "LinkGetServlet", urlPatterns = { "/LinkGet" })
public class LinkGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LinkGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	

		String age = request.getParameter("age");
		String height = request.getParameter("height");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		out.println("<h1> age = " + age + "</h1>");
		out.println("<h1> height = " + height + "</h1>");
	}

}
