package jul20;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jul20/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("NAME");
		String id=request.getParameter("ID");
		String addr=request.getParameter("ADDR");
		String phone=request.getParameter("TEL");
		String pwd=request.getParameter("PWD");
		String gender=request.getParameter("GENDER");
		String email=request.getParameter("EMAIL");
		String job=request.getParameter("JOB");
		System.out.println(name+", "+id+", "+addr+", "+phone+", "+pwd+", "+gender+
				", "+email+", "+job);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String name=request.getParameter("NAME");
		String id=request.getParameter("ID");
		String addr=request.getParameter("ADDR");
		String phone=request.getParameter("TEL");
		String pwd=request.getParameter("PWD");
		String gender=request.getParameter("GENDER");
		String email=request.getParameter("EMAIL");
		String job=request.getParameter("JOB");
		//���������̺�(customer_info)
		//����(id:VARCHAR2(20)), �̸�(name:VARCHAR2(30)), �ּ�(address:VARCHAR2(50)), 
		//����ó(phone:VARCHAR2(30)),
		//��ȣ(password:VARCHAR2(20)), ����(gender:VARCHAR2(2)), �̸���(email:VARCHAR2(30)),
		//����(job:VARCHAR2(20))
		
		String insert = "insert into customer_info values(";
		insert=insert+"'"+id+"','"+name+"','"+addr+"',";
		insert=insert+"'"+phone+"','"+pwd+"','"+gender+"',";
		insert=insert+"'"+email+"','"+job+"')";
		System.out.println(insert);
	}
}