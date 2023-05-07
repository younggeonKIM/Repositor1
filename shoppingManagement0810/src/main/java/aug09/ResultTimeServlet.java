package aug09;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resultTime.do")
public class ResultTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ResultTimeServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String zone=request.getParameter("ZONE");
		Date date=new Date();
		request.setAttribute("ZONE", zone);
		request.setAttribute("TODAY", date);
		RequestDispatcher r=request.getRequestDispatcher("resultTime.jsp");
		r.forward(request, response);
	}

}
