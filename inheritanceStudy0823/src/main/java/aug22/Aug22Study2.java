package aug22;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface Animal{
	int AGE=10;//���
	void shout();//�߻� �޼���
}
class Tiger implements Animal{
	@Override
	public void shout() {
		System.out.println("����");
	}
}
abstract class Unit {
	int price=1000;
	void doIt() {System.out.println("doIt");}
	abstract void doDo();
}
class Marine extends Unit{
	Marine () {}

	@Override
	void doDo() {
		
		
	}
	
}
@WebServlet("/Aug22Study2")
public class Aug22Study2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Aug22Study2() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double a =Math.PI;
		System.out.println(a);
		Tiger t=new Tiger();
		t.shout();
		System.out.println(t.AGE);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
