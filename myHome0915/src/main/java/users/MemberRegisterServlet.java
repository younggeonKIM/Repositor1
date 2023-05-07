package users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.DBExpert;

@WebServlet("/memberRegister.do")
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MemberRegisterServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id=request.getParameter("IDD"); //����
		String pwd=request.getParameter("PASSWORD"); //��ȣ
		String name=request.getParameter("NAME"); //�̸�
		String tel=request.getParameter("TEL"); //��ȭ��ȣ
		String addr=request.getParameter("ADDR"); //�ּ�
		String gender=request.getParameter("GENDER"); //����
		String email=request.getParameter("EMAIL"); //�̸���
		String job=request.getParameter("JOB"); //����
		
		User user=new User();
		user.setId(id); user.setPwd(pwd); user.setName(name);
		user.setTel(tel); user.setAddr(addr); 
		user.setGender(gender.charAt(0)); 
		user.setEmail(email); user.setJob(job);
		
		DBExpert dbe=new DBExpert();
		String result=dbe.putUser(user);
		
		//������ ��ȯ(������ ��� ���� ���� JSP:entryResult.jsp)
		//Redirect ?, Forward ? --> Redirect
		response.sendRedirect(
				"template.jsp?BODY=entryResult.jsp?R="+result);
	}

}
