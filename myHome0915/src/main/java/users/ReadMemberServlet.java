package users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.DBExpert;

@WebServlet("/readMember")
public class ReadMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ReadMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("USID");
		String result=request.getParameter("R");
		DBExpert dbe=new DBExpert();
		User user=dbe.USERS(id);
		
		String url="template.jsp?BODY=readMember.jsp";
		if(result!=null) {
			url=url+"&R="+result;
		}
		request.setAttribute("USER", user);
		RequestDispatcher r=
				request.getRequestDispatcher(
						url);
		r.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
