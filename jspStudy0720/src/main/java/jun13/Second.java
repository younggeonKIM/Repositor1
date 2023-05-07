package jun13;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Second
 */
@WebServlet("/jun13/second.html")
public class Second extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Second() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//Redirect�� third.jsp�� ��ȯ
			//response.sendRedirect("third.jsp");
		//Forward�� third.jsp�� ��ȯ
			RequestDispatcher rd=request.getRequestDispatcher("third.jsp");
			rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	//Redirect�� third.jsp�� ��ȯ
		//response.sendRedirect("third.jsp");
	//Forward�� third.jsp�� ��ȯ
		RequestDispatcher rd=request.getRequestDispatcher("third.jsp");
		rd.forward(request, response);
	}

}
