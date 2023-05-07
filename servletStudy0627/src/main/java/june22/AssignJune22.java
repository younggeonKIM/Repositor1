package june22;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssignJune22")
public class AssignJune22 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AssignJune22() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JavaDep dep=new JavaDep();
		Gobayashi goba=new Gobayashi();
		goba.Buy(dep.gwa.ap);
		goba.Buy(dep.ga.tv);
		System.out.println("수중에 남은 돈 : "+goba.Pocket+" tv의 가격 : "
							+goba.tvpri+" 사과의 가격 : "+goba.appri);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
class JavaDep {
	JavaDep () {}
	Gajeon ga=new Gajeon(); Gwail gwa=new Gwail(); Iryu ir=new Iryu();
}
class Gajeon {
	Gajeon () {}
	TV tv=new TV (); Radio radi=new Radio ();
}
class Gwail {
	Gwail () {}
	Apple ap=new Apple (); Grapes gra=new Grapes ();
}
class Iryu {
	Iryu () {}
	Jeans jea=new Jeans (); Tshirt tsrt=new Tshirt ();
}
class TV {
	TV () {}
	int price=(int)((Math.random()*20000)+30000);
}
class Radio {
	Radio () {}
	int price=(int)((Math.random()*10000)+20000);
}
class Apple {
	Apple () {}
	int price=(int)((Math.random()*2000)+1500);
}
class Grapes {
	Grapes () {}
	int price=(int)((Math.random()*3000)+4000);
}
class Jeans {
	Jeans () {}
	int price=(int)((Math.random()*15000)+25000);
}
class Tshirt {
	Tshirt () {}
	int price=(int)((Math.random()*10000)+15000);
}
class Gobayashi {
	Gobayashi () {}
	int Pocket=50000; 
	int tvpri=0;
	int appri=0;
	int radpri=0;
	void Buy (TV tv) {
		
		Pocket=Pocket-tv.price;
		tvpri=tv.price;
	}
	void Buy (Apple ap) {
		Pocket=Pocket-ap.price;
		appri=ap.price;
	}
	void Buy (Radio rad) {
		Pocket=Pocket-rad.price;
		radpri=rad.price;
	}
}