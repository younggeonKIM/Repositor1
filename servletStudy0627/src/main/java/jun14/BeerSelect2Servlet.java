package jun14;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeerSelect2Servlet
 */
@WebServlet("/jun14/beerselect2.do")
public class BeerSelect2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerSelect2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� ������ ���� ã�´�.
		String color=request.getParameter("COLOR");
		String[] brands=new String[3]; //���� 3�� �迭�� ���
		if (color.equals("DARK")) {
			brands[0]="GUINESS"; brands[1]="FUINESS"; brands[2]="HUINESS";
		} else if (color.equals("LIGHT")) {
			brands[0]="Budwiser"; brands[1]="Ducwiser"; brands[2]="Cudwiser";
		} else if (color.equals("YELLOW")) {
			brands[0]="Corona"; brands[1]="Dorona"; brands[2]="Gorona";
		} else {
			brands[0]="Tsingtao"; brands[1]="Ssingtao"; brands[2]="Usingtao";
		}
		//response.sendRedirect("beerResult2.jsp?BR1="+brands[0]+
		//						"&BR2="+brands[1]+"&BR3="+brands[2]);
		request.setAttribute("BRS", brands);
		RequestDispatcher rd=request.getRequestDispatcher("beerResult2.jsp");
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
