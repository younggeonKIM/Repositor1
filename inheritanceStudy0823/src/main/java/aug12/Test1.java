package aug12;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test1")
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test1() {
        super();
        
    }
class Goguryo {
	Goguryo(){} //ª˝º∫¿⁄
	int gold=100;
	void goguryoPlay() {
		System.out.println("∞Ì±∏∑¡ πŒº”≥Ó¿Ã");
	}
}
class Shilla extends Goguryo{
	Shilla(){}
	int coal=100;
	void shillaPlay() {
		System.out.println("Ω≈∂Û πŒº”≥Ó¿Ã");
	}
}
class Chosun extends Shilla {
	Chosun(){}
	int silver=200;
	void chosunPlay() {
		System.out.println("¡∂º± πŒº”≥Ó¿Ã");
	}
}
class Korea extends Chosun {
	Korea(){}
}
class GrandParents {
	int money=5000;	GrandParents(){}
}
class Parents extends GrandParents{
	int money=1000;	Parents(){}
	void show() {
		System.out.println(this.money+", "+super.money);
	}
}
class Child extends Parents {
	int money=50; Child(){}
	void display() {
		System.out.println(this.money+", "+super.money);
	}
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Child c=new Child();
		
		c.display();
		c.show();
//		Korea k=new Korea();
//		System.out.println(k.gold);
//		System.out.println(k.coal);
//		System.out.println(k.silver);
//		k.goguryoPlay();
//		k.shillaPlay();
//		k.chosunPlay();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
