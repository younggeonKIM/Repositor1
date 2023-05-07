package jun13;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CoffeeOrder
 */
@WebServlet("/jun13/coffeeOrder.do")
public class CoffeeOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeeOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String drin=request.getParameter("MENU");
		String drNu=request.getParameter("NUM");
		String brea=request.getParameter("BREAD");
		String brNu=request.getParameter("QUAN");
		int driNu=Integer.parseInt(drNu);
		int breNu=Integer.parseInt(brNu);
		int price=0; //음료수의 가격을 위한 변수 선언
		if (drin.equals("A")){ //아메리카노:2000
			price=2000;
		}else if(drin.equals("B")){ //카푸치노:3000
			price=3000;
		}else if(drin.equals("C")){ //카페라테:3500
			price=3500;
		}else if(drin.equals("D")){ //카페오레:3300
			price=3300;
		}else { //카페모카:3800
			price=3800;
		}
		int brPri=0;//빵의 가격을 위한 변수 선언
		if (brea.equals("A")) { //핫도그:4000
			brPri=4000;
		} else if(brea.equals("B")) { //크루아상:3000
			brPri=3000;
		} else if(brea.equals("C")) { //크림빵:3000
			brPri=3000;
		} else if(brea.equals("D")) { //호밀빵:4000
			brPri=4000;
		} else { //고로케:4500
			brPri=4500;
		}
		int total=(price*driNu)+(brPri*breNu);
		response.sendRedirect("coffeeResult.jsp?TOTAL="+total);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
