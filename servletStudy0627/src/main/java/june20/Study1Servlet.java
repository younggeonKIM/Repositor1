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
		System.out.println(hunter.h1.mana); //���ݹޱ� �� ù��° ������� ����
		hunter.m1.attack(hunter.h1);
		//������(hunter)�� �ִ� ù��° ������ ù��° ����� ����
		System.out.println(hunter.h1.mana); //���ݹ��� �� ù��° ������� ����
		System.out.println(hunter.h2.mana); //�ι�° ������� ����
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
		//������ ������ 100���� �ٲ۴�.
		m.mana=100;
	}
}
class Marine {
	Marine () {}
	int mana=100;
	
	void attack (Hydra a) { //����� �����ϴ� �޼���
		//���� ������� ������ 10 ���δ�.
		a.mana=a.mana-10;
	}
	void attack (Zealot z) { //������ �����ϴ� �޼���
		//���� ������ ������ 10 ���δ�.
		z.mana=z.mana-10;
	}
	void attack (Marine m) { //������ �����ϴ� �޼���
		//���� ������ ������ 10 ���δ�.
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
	void attackMarine (Marine m) { //������ �����ϴ� �޼���
		//���� ������ ������ 10 ���δ�.
		m.mana=m.mana-10;
	}
}