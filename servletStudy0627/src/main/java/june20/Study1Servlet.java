package june20;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Study1Servlet")
public class Study1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Study1Servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HunterMap hunter=new HunterMap();
		System.out.println(hunter.h1.mana); //공격받기 전 첫번째 히드라의 마나
		hunter.m1.attack(hunter.h1);
		//전쟁터(hunter)에 있는 첫번째 마린이 첫번째 히드라 공격
		System.out.println(hunter.h1.mana); //공격받은 후 첫번째 히드라의 마나
		System.out.println(hunter.h2.mana); //두번째 히드라의 마나
		hunter.h1.attackMarine(hunter.m1); 
		hunter.h1.attackMarine(hunter.m2); 
		System.out.println(hunter.m1.mana+", "+hunter.m2.mana);
		hunter.m.recoveryMarine(hunter.m1);
		hunter.m.recoveryMarine(hunter.m2);
		System.out.println(hunter.m1.mana+", "+hunter.m2.mana);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
class HunterMap {
	HunterMap () {}
	Medic m=new Medic();
	Marine m1=new Marine(); Marine m2=new Marine(); 
	Hydra h1=new Hydra(); Hydra h2=new Hydra(); 
}
class Medic {
	Medic () {}
	void recoveryMarine (Marine m) {
		//마린의 마나를 100으로 바꾼다.
		m.mana=100;
	}
}
class Marine {
	Marine () {}
	int mana=100;
	
	void attack (Hydra a) { //히드라를 공격하는 메서드
		//상대방 히드라의 마나를 10 줄인다.
		a.mana=a.mana-10;
	}
	void attack (Zealot z) { //질럿을 공격하는 메서드
		//상대방 질럿의 마나를 10 줄인다.
		z.mana=z.mana-10;
	}
	void attack (Marine m) { //마린을 공격하는 메서드
		//상대방 마린의 마나를 10 줄인다.
		m.mana=m.mana-10;
	}
}
class Zealot {
	Zealot () {} 
	int mana=100;
}
class Hydra {
	Hydra () {}
	int mana=100;
	void attackMarine (Marine m) { //마린을 공격하는 메서드
		//상대방 마린의 마나를 10 줄인다.
		m.mana=m.mana-10;
	}
}