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
		Human h =new Gobayashi(); //������
		System.out.println(h.money); 
		h.whoAmI(); //������ �޼���
		h.whoAreYou(); //�������̵��� �޼���
		
		Human u =new Danaka(); //������
		System.out.println(u.money);
		u.whoAmI(); //�������̵��� �޼���
		u.whoAreYou(); //������ �޼���
	}
	private static final long serialVersionUID = 1L;
       
    public Page4() {
        super();
        
    }
class Human {
	int money =10000;
	void whoAmI () {System.out.println("���� �ΰ��̴�.");}
	void whoAreYou () {System.out.println("�ʴ� ������?");}
}
class Danaka extends Human {
	int money =5000; int dollar =100;
	void doIt() {System.out.println("���� ���� �մϴ�.");}
	void whoAmI() {System.out.println("���� �ٳ����.");}
}
class Gobayashi extends Human {
	int money =6000; int euro=100;
	void doIt() {System.out.println("���� ���� �ؿ�.");}
	void whoAreYou() {System.out.println("����� ��������?");}	
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
