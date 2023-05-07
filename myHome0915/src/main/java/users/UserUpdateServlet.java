package users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.DBExpert;

@WebServlet("/userUpdate.do")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserUpdateServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		String id=request.getParameter("ID");
		String tel=request.getParameter("TEL");
		String addr=request.getParameter("ADDR");
		String email=request.getParameter("EMAIL");
		String job=request.getParameter("JOB");
		
		User user=new User();
		user.setId(id);
		user.setTel(tel); user.setAddr(addr);
		user.setEmail(email); user.setJob(job);
		DBExpert dbe=new DBExpert();
		String result=dbe.updateUser(user);

		//���� ���� --> ������ �������� ��ȸ (����) --> ��ȸ ��� ���
		response.sendRedirect("readMember?USID="+user.getId()+"&R="+result);
	}

}
