package bbs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getBBS.do")
public class GetBbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GetBbsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("NO");
		CRUD crud = new CRUD();
		BBS bbs = crud.getBBS(Integer.parseInt(no));
		
		request.setAttribute("BBS", bbs);
		RequestDispatcher r=
			request.getRequestDispatcher(
					"template.jsp?BODY=bbsRead.jsp");
		r.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
