package june20;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssignmentJune20")
public class AssignmentJune20 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AssignmentJune20() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Suzuki su= new Suzuki ();
		Saito sai= new Saito ();
		su.Lift();
		sai.Lift();
		Gwan gwa=new Gwan();
		Genzo ge=new Genzo();
		gwa.jud(su.a, sai.a);
		ge.jud(su.a, sai.a);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
class Suzuki {
	Suzuki () {}
	double a=0;
	void Lift () {
		a=(int) ((Math.random()*1201)+800);
		a=a/10;
	}
}
class Saito {
	Saito () {}
	double a=0;
	void Lift () {
		a=(int) ((Math.random()*1201)+800);
		a=a/10;
	}
}
class Gwan {
	Gwan () {}
	int result=0;
	void jud(double Suz, double Sait) {
		if (Suz==Sait) {
			System.out.println("무승부입니다. 스즈키 : "+Suz+", 사이토 : "+Sait);
			result=0;
		} else if (Suz>Sait) {
			System.out.println("스즈키의 승리. 스즈키 : "+Suz+", 사이토 : "+Sait);
			result=1;
		} else {
			System.out.println("사이토의 승리. 스즈키 : "+Suz+", 사이토 : "+Sait);
			result=2;
		}
	}
}
class Genzo {
	Genzo () {}
	int result=0;
	void jud(double Suz, double Sait) {
		if (Suz==Sait) {
			System.out.println("무승부입니다. 스즈키 : "+Suz+", 사이토 : "+Sait);
			result=0;
		} else if (Suz>Sait) {
			System.out.println("스즈키의 승리. 스즈키 : "+Suz+", 사이토 : "+Sait);
			result=1;
		} else {
			System.out.println("사이토의 승리. 스즈키 : "+Suz+", 사이토 : "+Sait);
			result=2;
		}
	}
}
