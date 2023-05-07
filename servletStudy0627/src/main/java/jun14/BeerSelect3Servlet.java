package jun14;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jun14Servlet/beerselect3.do")
public class BeerSelect3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BeerSelect3Servlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String color=request.getParameter("COLOR");
		BeerExpert be=new BeerExpert();
		String[] names=be.recommend(color);
		request.setAttribute("BRS", names);
		RequestDispatcher rd=request.getRequestDispatcher("beerResult3.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
class BeerExpert{
	BeerExpert(){} //��ü�� ����� �� ����ϴ� �޼���:������ (constructor)
	
	String[] recommend(String color){
		String[] names= new String[3];
		//color�� ����ִ� ���� ���� ���� �̸��� �迭�� �ִ´�.
		if (color.equals("DARK")) {
			names[0]="GUINESS"; names[1]="CUINESS"; names[2]="DUINESS";
		}else if (color.equals("LIGHT")) {
			names[0]="Budwiser"; names[1]="Cudwiser"; names[2]="Dudwiser";
		}else if (color.equals("YELLOW")) {
			names[0]="Corona"; names[1]="Dorona"; names[2]="Gorona";
		}else {
			names[0]="Tsingtao"; names[1]="Ssingtao"; names[2]="Fsingtao";
		}
		return names;
	}
}
