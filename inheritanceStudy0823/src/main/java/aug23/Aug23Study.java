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
	int SPEED=100; //상수
	public abstract void fly(); //추상 메서드
}
interface Fish {
	int SPEED =50; //상수 (static final)
	void swim(); //추상 메서드 (public abstract)
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
		Tiger t=new Tiger(); //인스턴스 생성 (홍길동)
		int a=t.age;
		int c=Cat.SPEED;
		t.doIt();
		Tiger t2=new Tiger(); //인스턴스 생성 (박길동)
		t2.doIt();
		Tiger t3=new Tiger(); //인스턴스 생성 (최길동)
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
