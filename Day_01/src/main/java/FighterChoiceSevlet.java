

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FighterChoiceSevlet
 */
@WebServlet("/fighterChoice")
public class FighterChoiceSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FighterChoiceSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] fighterArray = request.getParameterValues("fighter");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<body bgColor = 'black'>");
		out.println("<table align = 'center'>");
		out.println("<tr>");
		for (int i = 0; i < fighterArray.length; i++) {
			out.println("<td><img src = '" + fighterArray[i] + "'width = 150 height = 150/></td>");
		}
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
	
	}

}
