package image;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/imageForm.do")
public class ImageFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ImageFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession();
		String id=(String)ss.getAttribute("LOGINID");
		if(id==null) { //로그인 안 한 경우
			
		}else { //로그인 한 경우
			RequestDispatcher r=
					request.getRequestDispatcher(
							"template.jsp?BODY=imageWriteForm.jsp");
			r.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
