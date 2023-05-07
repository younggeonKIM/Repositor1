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
		//고객정보테이블(customer_info)
		//계정(id:VARCHAR2(20)), 이름(name:VARCHAR2(30)), 주소(address:VARCHAR2(50)), 
		//연락처(phone:VARCHAR2(30)),
		//암호(password:VARCHAR2(20)), 성별(gender:VARCHAR2(2)), 이메일(email:VARCHAR2(30)),
		//직업(job:VARCHAR2(20))
		
		String insert = "insert into customer_info values(";
		insert=insert+"'"+id+"','"+name+"','"+addr+"',";
		insert=insert+"'"+phone+"','"+pwd+"','"+gender+"',";
		insert=insert+"'"+email+"','"+job+"')";
		System.out.println(insert);
	}
}