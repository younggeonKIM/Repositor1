package bbs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getAllBBS.do")
public class GetAllBbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GetAllBbsServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CRUD crud = new CRUD();
		String page=request.getParameter("PAGE");
		int pageNo = 1;
		if(page != null) {
			pageNo=Integer.parseInt(page);
		}
		List<BBS> list=crud.getAllBBS(pageNo);
		
		int totalCount = crud.getBBSCount();
		
		int pageCount= totalCount / 5;
		if (totalCount % 5 != 0 ) {pageCount++;}
		
		request.setAttribute("PAGES", pageCount);
		request.setAttribute("LIST", list);
		RequestDispatcher r=
				request.getRequestDispatcher(
					"template.jsp?BODY=bbsList.jsp");
		r.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
