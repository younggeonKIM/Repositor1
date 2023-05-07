package june24;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/June24SecondServlet")
public class June24SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public June24SecondServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tiger t1=new Tiger(); t1.name="ȣ����"; t1.age=1;
		Tiger t2=new Tiger(); t2.name="ȣ����"; t2.age=2;
		Tiger t3=new Tiger("������"); t3.age=1;
		Tiger t4=new Tiger(3); t4.name="������";
		Tiger t5=new Tiger("������", 2);
		Tiger t6=new Tiger(4, "������");
		
		//�� ���� ��� (�̸�, ����, �ּ�, ����ó, ������, ����)
		Customer c1=new Customer();
		c1.name="ȫ�浿"; c1.age=23; c1.address="����"; 
		c1.phone="01012342311"; c1.weight=77.8; c1.height=165.3;
		
		Customer c2=new Customer ("��浿", 32, "���", "01099882342",
									80.5, 172.8);
		Customer c3=new Customer ("���浿");
		Customer c4=new Customer ("���浿", 45);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
class Customer {
	Customer () {} //�⺻ ������
	
	Customer (String a) {name=a;} //�̸������� ���� ����ϴ� ������
	
	Customer (String a, int b) {name=a; age=b;} 
	//�̸�, ���̷� ���� ����ϴ� ������
	
	Customer (String a, int b, String c, String d, double e, double f) {
		name=a; age=b; address=c; phone=d; weight=e; height=f;
	} //��� ������ ���� ������
	
	String name; int age; String address; String phone; 
	double weight; double height;
}
class Tiger {
	Tiger () {} //������ (constructor) : ��ü�� ����� �� ����ϴ� �޼���
	//�޼����� �����ε� (overloading)
	Tiger (String a) {name=a;}
	Tiger (int a) {age=a;}
	Tiger (String a, int b) {name=a; age=b;}
	Tiger (int a, String b) {age=a; name=b;}
	String name;
	int age;
}