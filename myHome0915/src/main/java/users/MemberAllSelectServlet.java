package users;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.DBExpert;

@WebServlet("/MemberAllSelect")
public class MemberAllSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MemberAllSelectServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("PAGENO");
		DBExpert dbe=new DBExpert();
		ArrayList<User> al=dbe.getUserAll(page);
		
		int totalCount=dbe.MemberTotalCount();
		int MemberCount=totalCount/5;
		if(MemberCount%5 !=0) {
			MemberCount++;
		}
		
		request.setAttribute("PAGE", MemberCount);
		request.setAttribute("AL", al);
		RequestDispatcher r=request.getRequestDispatcher("template.jsp?BODY=MemberAll.jsp");
		r.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
