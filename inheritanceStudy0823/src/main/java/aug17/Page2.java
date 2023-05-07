package aug17;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Page2")
public class Page2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Page2() {
        super();

    }
class IamParents {
	IamParents () {}
	int money=200;
	void callMe() {
		System.out.println("���� �ƹ�����.");
	}
}
class IamChild extends IamParents {
	IamChild () {}
	
	void callMe() {
		System.out.println("���� �ڽ��̴�.");
	}
	int money=100;
	void show() {
		System.out.println(this.money+", "+super.money);
	}
}
class Tiger {}
class Cat extends Tiger {}
class Dog extends Tiger {}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IamChild c=new IamChild();
		c.show(); c.callMe();
		
		Tiger t1=new Tiger();
		Tiger t2=new Cat(); //������
		Tiger t3=new Dog(); //������
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
