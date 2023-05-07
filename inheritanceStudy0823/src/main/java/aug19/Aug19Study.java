package aug19;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�Ӹ�, ����, ����� �ֽ��ϴ�. ������ 100�Դϴ�.
//������ �ϸ� ������ 1�� �پ��ϴ�.
//�޵��� ��� ���� ������ ġ���մϴ�.
//ġ�Ḧ ���� ������ ������ 100�� �˴ϴ�.
class Medic {
	Medic () {}
	void recover (Unit u) {
		u.mana=100;
	}
//	void recover (Marine u) {
//		u.mana=100;
//	} //�Ӹ��� ġ���ϸ�, �Ӹ��� ������ 100
//	void recover (Hydra u) {
//		u.mana=100;
//	} //����� ġ���ϸ�, ������� ������ 100
//	void recover (Zealot u) {
//		u.mana=100;
//	} //������ ġ���ϸ�, ������ ������ 100
}
class Unit {
	int mana =100;
	void attack (Unit u) {
		u.mana=u.mana-1;
	}
//	void attack (Hydra enemy) {
//		enemy.mana=enemy.mana-1;
//	} //���� ����� �����ϴ� �޼���
//	void attack (Marine enemy) {
//		enemy.mana=enemy.mana-1;
//	} //���� �Ӹ��� �����ϴ� �޼���
//	void attack (Zealot enemy) {
//		enemy.mana=enemy.mana-1;
//	} //���� ������ �����ϴ� �޼���
}
class Marine extends Unit{
	Marine () {}
}
class Zealot extends Unit{
	Zealot () {}
}
class Hydra extends Unit{
	Hydra () {}
	//����� -> �����, ����� -> �Ӹ�, ����� -> ����
}
@WebServlet("/Aug19Study")
public class Aug19Study extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Marine m1= new Marine();
		Hydra h1= new Hydra();
		Zealot z1= new Zealot();
		m1.attack(h1); //�Ӹ��� ����� ����
		m1.attack(h1);
		z1.attack(h1); //������ ����� ����
		h1.attack(m1); //����� �Ӹ� ����
		h1.attack(z1); //����� ���� ����
		//�Ӹ��� ���� :99, ������� ���� :97, ������ ���� :99
		System.out.println("�Ӹ��� ���� : "+m1.mana);
		System.out.println("������� ���� : "+h1.mana);
		System.out.println("������ ���� : "+z1.mana);
		Medic m=new Medic();
		m.recover(h1);//����� ġ��
		m.recover(m1);//�Ӹ��� ġ��
		m.recover(z1);//������ ġ��
		System.out.println("�Ӹ��� ���� : "+m1.mana);
		System.out.println("������� ���� : "+h1.mana);
		System.out.println("������ ���� : "+z1.mana);
	}
	private static final long serialVersionUID = 1L;

    public Aug19Study() {
        super();
        
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
