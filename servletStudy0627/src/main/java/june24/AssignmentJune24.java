package june24;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssignmentJune24")
public class AssignmentJune24 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AssignmentJune24() {
        super();
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HiMart hi=new HiMart();
		CPU cp5000=new CPU(5000);
		
		
		
		HongGilDong hong=new HongGilDong (500000);
//		BigDecimal n1=new BigDecimal((cp1.get(cp1)+hi.lapto.main.get(hi.lapto.main)+
//				hi.lapto.main.ram.get(hi.lapto.main.ram)+
//				hi.lapto.main.gra.get(hi.lapto.main.gra)));
//		BigDecimal n2=new BigDecimal(1.1);
//		BigDecimal n3=n2.multiply(n1);
		hong.excha(hi.lapto.pri);
		
		
		System.out.println("CPU�� ���� : "+hi.lapto.cp5000.get(cp5000)+
				" ���κ��常�� ���� : "+hi.lapto.main.pric+
				" ���κ����� ���� : "+hi.lapto.main.pri+
				" �Ｚ ���� ���� : "+hi.lapto.main.ram.pri+
				" �׷���ī���� ���� : "+hi.lapto.main.gra.pri+
				" ��Ʈ���� ���� : "+hi.lapto.pri);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
class HiMart {
	HiMart () {}
	Laptop lapto=new Laptop();
}
class Laptop {
	CPU cpu= new CPU (); MainBoard main=new MainBoard();
	CPU cp5000=new CPU (5000);
	double pri=0;
	Laptop () {
		pri=1.1*(cp5000.get(cp5000)+main.getMainBoard(main.pric)
				);
	}
	
}
class CPU {
	CPU () {}
	private int pri=(int)((Math.random()*10000)+15000);
	CPU (int a) {pri=a;}
	int get (CPU cpu) {
		return pri;
	}
}
class MainBoard {
	SamsungRAM ram=new SamsungRAM ();
	GraphicCard gra=new GraphicCard ();
	
	int pric;
	private int a=(int)((Math.random()*5000)+10000);
	MainBoard () {
		pric=a;
	}
	
	int pri=0;
	int getMainBoard (int a) {
		pri=a+ram.pri+gra.pri;
		return pri;
	}
}
class SamsungRAM {
	int pri;
	private int a=(int)((Math.random()*2000)+8000);
	SamsungRAM () {pri=a;}
	
}
class GraphicCard {
	int pri;
	private int a=(int)((Math.random()*100000)+40000);
	GraphicCard () {pri=a;}
	
}
class HongGilDong {
	HongGilDong () {}
	private int pocket=0;
	HongGilDong (int a) {
		pocket=a;
	}
	void excha (double pric) {
		System.out.println("��Ʈ�� ���� �� ���� �� : "+(pocket-pric));
	}
}