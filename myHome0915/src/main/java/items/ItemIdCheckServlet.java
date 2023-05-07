package items;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.DBExpert;

@WebServlet("/itemIdCheck.do")
public class ItemIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ItemIdCheckServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("ID");
		DBExpert dbe=new DBExpert();
		String result=dbe.getId(id); 
		//result�� null�� ���, �Է��� ��ǰ��ȣ�� ��밡��
		//result�� null�� �ƴ� ���, �Է��� ��ǰ��ȣ�� �̹� ��� ��
		request.setAttribute("ID", id);
		request.setAttribute("DUP", result);
		RequestDispatcher r=request.getRequestDispatcher("itemIdCheck.jsp");
		r.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
