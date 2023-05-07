package jun14;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeerSelectServlet
 */
@WebServlet("/jun14/beerselect.do")
public class BeerSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� ������ ���� ã�´�.
		String color=request.getParameter("COLOR");
		//������ ã�� ���� �˸��� ���� �̸��� ã�´�.
		String brand=""; //��õ�� ���� �̸��� ���� ���� ����
		if (color.equals("DARK")) {
			brand="GUINESS";
		} else if (color.equals("LIGHT")) {
			brand="Budwiser"; 
		} else if (color.equals("YELLOW")) {
			brand="Corona";
		} else {
			brand="Tsingtao";
		}
		//ã�� ���� �̸��� JSP(beerResult.jsp)�� �����Ѵ�.
			//response.sendRedirect("beerResult.jsp?BEER="+brand);
			request.setAttribute("BRAND", brand);
			RequestDispatcher rd=request.getRequestDispatcher("beerResult.jsp");
			rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
