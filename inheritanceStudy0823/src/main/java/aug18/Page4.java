package aug18;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Page4")
public class Page4 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Human h =new Gobayashi(); //다형성
		System.out.println(h.money); 
		h.whoAmI(); //조상의 메서드
		h.whoAreYou(); //오버라이드한 메서드
		
		Human u =new Danaka(); //다형성
		System.out.println(u.money);
		u.whoAmI(); //오버라이드한 메서드
		u.whoAreYou(); //조상의 메서드
	}
	private static final long serialVersionUID = 1L;
       
    public Page4() {
        super();
        
    }
class Human {
	int money =10000;
	void whoAmI () {System.out.println("나는 인간이다.");}
	void whoAreYou () {System.out.println("너는 누구냐?");}
}
class Danaka extends Human {
	int money =5000; int dollar =100;
	void doIt() {System.out.println("나는 일을 합니다.");}
	void whoAmI() {System.out.println("나는 다나까다.");}
}
class Gobayashi extends Human {
	int money =6000; int euro=100;
	void doIt() {System.out.println("나는 일을 해요.");}
	void whoAreYou() {System.out.println("당신은 누구세요?");}	
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
