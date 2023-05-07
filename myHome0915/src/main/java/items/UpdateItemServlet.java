package items;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.DBExpert;

@WebServlet("/updateItem.do")
public class UpdateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateItemServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		String id=request.getParameter("ID");
		String name=request.getParameter("NAME");
		String price=request.getParameter("PRIC");
		String spec=request.getParameter("SPEC");
		String origin =request.getParameter("ORIG");
		
		Item it=new Item();
		it.setId(id); it.setName(name);	
		it.setPric(Integer.parseInt(price));
		it.setSpec(spec); it.setOrig(origin);
		
		DBExpert dbe=new DBExpert();
		String result=dbe.updateItem(it);
		
		response.sendRedirect("getItem?ID="+it.getId()+"&R="+result);
	}
}