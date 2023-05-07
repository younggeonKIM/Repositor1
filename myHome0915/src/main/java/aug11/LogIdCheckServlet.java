package aug11;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.DBExpert;

@WebServlet("/logIdCheck")
public class LogIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LogIdCheckServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("ID");
		DBExpert dbe=new DBExpert();
		String result=dbe.getLogId(id);
		request.setAttribute("ID", id);
		request.setAttribute("DUP", result);
		RequestDispatcher r=request.getRequestDispatcher("logIdCheck.jsp");
		r.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
