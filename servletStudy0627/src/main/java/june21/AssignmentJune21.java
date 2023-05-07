package june21;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssignmentJune21")
public class AssignmentJune21 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AssignmentJune21() {
        super();
 
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	FlowerShop flsh=new FlowerShop();
	flsh.J.price = flsh.flowerPri(0);
	flsh.G.price= flsh.flowerPri(0);
	flsh.B.price = flsh.flowerPri(0);
	flsh.emplee.flowerSum(flsh.J.price,flsh.G.price,flsh.B.price);
	flsh.empler.flowerSum(flsh.J.price,flsh.G.price,flsh.B.price);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
class FlowerShop {
	FlowerShop () {}
	Jangmi J=new Jangmi(2500);
	Gukhwa G=new Gukhwa();
	Baekhap B=new Baekhap(); 
	int flowerPri (int price) {
		price= (int)((Math.random()*9001)+1000);
		return price;
	}
	Employee emplee=new Employee();
	Employer empler=new Employer();
}
class Jangmi {
	Jangmi () {}
	int price=(int)((Math.random()*9001)+1000);
	Jangmi (int a) {price=a;}
}
class Gukhwa {
	Gukhwa () {}
	int price=(int)((Math.random()*9001)+1000);
}
class Baekhap {
	Baekhap () {}
	int price=(int)((Math.random()*9001)+1000);
}
class Employee {
	Employee () {}
	void flowerSum (int a, int b, int c) {
		System.out.println ("합계 : "+(a+b+c)+" 장미 : "+a+
							" 국화 : "+b+" 백합 : "+c);
	}
}
class Employer {
	Employer () {}
	void flowerSum (int a, int b, int c) {
		System.out.println ("합계 : "+(a+b+c)+" 장미 : "+a+
							" 국화 : "+b+" 백합 : "+c);
	}
}