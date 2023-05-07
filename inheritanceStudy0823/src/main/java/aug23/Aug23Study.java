package aug23;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class Tiger {
	Tiger() {}
	int age=10;
	void doIt() {
		System.out.println("Tiger");
	}
}
class Lion {
	Lion () {}
	static int age=10;
	static void doIt() {
		System.out.println("Lion");
	}
}
interface Bird {
	int SPEED=100; //���
	public abstract void fly(); //�߻� �޼���
}
interface Fish {
	int SPEED =50; //��� (static final)
	void swim(); //�߻� �޼��� (public abstract)
}
interface Animal extends Bird,Fish{
	
}
class Somebody implements Bird,Fish{
	@Override
	public void swim() {	
		
	}
	@Override
	public void fly() {		
		
	}
}
class Cat {
	static final int SPEED =100;
}
@WebServlet("/Aug23Study")
public class Aug23Study extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tiger t=new Tiger(); //�ν��Ͻ� ���� (ȫ�浿)
		int a=t.age;
		int c=Cat.SPEED;
		t.doIt();
		Tiger t2=new Tiger(); //�ν��Ͻ� ���� (�ڱ浿)
		t2.doIt();
		Tiger t3=new Tiger(); //�ν��Ͻ� ���� (�ֱ浿)
		t3.doIt();
		int b=Lion.age;
		Lion.doIt(); 
	}
	private static final long serialVersionUID = 1L;
       
    public Aug23Study() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
