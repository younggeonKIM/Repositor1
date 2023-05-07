package aug11;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ ��Ȱ��ȭ�Ѵ�.
		HttpSession sess = request.getSession();
		sess.invalidate(); //��Ȱ��ȭ�Ѵ�.
		//�α׾ƿ���� JSP (logoutResult.jsp)�� ��ȯ��.
		//1.Redirect, 2.Forward, 3.�� ��  ---> Redirect
		response.sendRedirect("template.jsp?BODY=logoutResult.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
