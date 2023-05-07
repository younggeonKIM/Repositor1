package june22;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssignmentJune22")
public class AssignmentJune22 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AssignmentJune22() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JavaMotors moto=new JavaMotors ();
		moto.se.pric=moto.carPric(moto.se.pric);
		moto.tru.pric=moto.carPric(moto.tru.pric);
		moto.rv.pric=moto.carPric(moto.rv.pric);
		moto.hong.MotorsSum(moto.se.pric, moto.tru.pric, moto.rv.pric);
		moto.own.VATsum(moto.se.pric, moto.tru.pric, moto.rv.pric);
		moto.hong.MotorsSum2(moto);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
class JavaMotors {
	JavaMotors () {}
	Sedan se=new Sedan();
	Truck tru=new Truck();
	RV rv=new RV();
	int carPric (int price) {
		price = (int)((Math.random()*4000)+2000);
		return price;
	}
	Salesman hong=new Salesman();
	Salesman oh=new Salesman();	
	Owner own=new Owner();
}
class Sedan {
	Sedan () {}
	int pric;
}
class Truck {
	Truck () {}
	int pric;
}
class RV {
	RV () {}
	int pric;
} 
class Salesman {
	Salesman () {}
	void MotorsSum (int a, int b, int c) {
		System.out.println("�ڵ��� ������ �� : "+(a+b+c)+" ������ ���� : "
							+a+" Ʈ���� ���� : "+b+" RV�� ���� : "+c);
	}
	void MotorsSum2 (JavaMotors java) {
		System.out.println("�ڵ��� ������ �� : "+(java.carPric(java.se.pric)+
				java.carPric(java.tru.pric)+java.carPric(java.rv.pric))+
				" ������ ���� : "+java.carPric(java.se.pric)+" Ʈ���� ���� : "+
				java.carPric(java.tru.pric)+" RV�� ���� : "+
				java.carPric(java.rv.pric));
	}
}
class Owner {
	Owner () {} 
	void VATsum (double a, double b, double c) {
		System.out.println("�ΰ��� ���Ե� ������ �� : "+1.1*(a+b+c)+
							" ������ ���� : "+1.1*a+" Ʈ���� ���� : "+1.1*b+
							" RV�� ���� : "+1.1*c);
	}
}