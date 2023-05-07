package items;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.DBExpert;

@WebServlet("/getNationCodes")
public class GetNationCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GetNationCodeServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBExpert dbe =new DBExpert();
		ArrayList <String> codes =dbe.getNations();
		request.setAttribute("CODES", codes);
		RequestDispatcher r=request.getRequestDispatcher("template.jsp?BODY=itemInput.jsp");
		r.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
