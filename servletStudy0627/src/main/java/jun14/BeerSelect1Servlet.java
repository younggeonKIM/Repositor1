package jun14;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeerSelect1Servlet
 */
@WebServlet("/jun14/beerselect1.do")
public class BeerSelect1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerSelect1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� ������ ���� ã�´�.
		String color=request.getParameter("COLOR");
		//���� 3���� ��õ�ϱ� ���� ���� 3���� �����Ѵ�.
		String brand1=""; String brand2=""; String brand3="";
		if (color.equals("DARK")) {
			brand1="GUINESS"; brand2="BUINESS"; brand3="CUINESS";
		} else if (color.equals("LIGHT")) {
			brand1="Budwiser"; brand2="Ducwiser"; brand3="Cudwiser";
		} else if (color.equals("YELLOW")) {
			brand1="Corona"; brand2="Dorona"; brand3="Gorona";
		} else {
			brand1="Tsingtao"; brand2="Ssingtao"; brand3="Usingtao";
		}
		//response.sendRedirect("beerResult1.jsp?B1="+brand1+"&B2="+
			//					brand2+"&B3="+brand3);
		request.setAttribute("BR1", brand1);
		request.setAttribute("BR2", brand2);
		request.setAttribute("BR3", brand3);
		RequestDispatcher rd=request.getRequestDispatcher("beerResult1.jsp");
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
