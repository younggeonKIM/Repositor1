package june17;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Jun17Servlet")
public class Jun17Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Jun17Servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tiger t1=new Tiger(); 
		t1.name="ȣ����"; t1.age=3;
		Tiger t2=getTiger();
		System.out.println(t2.name+", "+t2.age);
	}
	Tiger getTiger() {
		Tiger a =new Tiger();
		a.name="ȣ����"; a.age=1;
		return a;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
} //������ ��
class Tiger {
	Tiger () {}
	String name=null; int age=0;
	
}
class Lion {
	Lion () {}
	String name=null; int age=0;
}