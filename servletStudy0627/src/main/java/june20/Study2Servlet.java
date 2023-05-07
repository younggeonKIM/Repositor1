package june20;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Study2Servlet")
public class Study2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Study2Servlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gobayashi go=new Gobayashi();
		go.jump(); //��پ߽ð� ���� �ٱ⸦ ��
		
		Danaka da=new Danaka();
		da.jump(); //�ٳ�� ���� �ٱ⸦ ��
		
		Refere re=new Refere();	
		re.pandan(go.record,da.record);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
//��ü ���� ���� 1.
//��پ߽ÿ� �ٳ�� �ֽ��ϴ�.
//��پ߽ð� ���� �ٱ⸦ ���� �� �߽��ϴ�. ����� 0m�Դϴ�.
//��پ߽ð� ���� �ٱ⸦ �߽��ϴ�. ����� 1.15m�Դϴ�.
//�ٳ�� ���� �ٱ⸦ �߽��ϴ�. ����� 1.21m�Դϴ�.
//������ ��پ߽ÿ� �ٳ����� �� �� ���� �� ����� �������� �Ǵ��մϴ�.

//���� 2. ����� ������ �Ѵ�.
//������ ���� : 100~200
//��پ߽� 115/100 -> 1.15
//�ٳ��� 121/100 ->1.21
class Gobayashi {
	Gobayashi () {} 
	double record=0; //�ν��Ͻ� (instance) ����
	void jump () {
		int a=200; //���� (local) ���� (variable)
		//record = 1.15;
		record=(int) ((Math.random()*101)+100); record=record/100;
		a=1;
	}
}
class Danaka {
	Danaka () {} 
	double record=0;
	void jump () {
		//record = 1.21;
		record=(int) ((Math.random()*101)+100); record=record/100;
	}
}
class Refere {
	Refere () {}
	void pandan (double gobayashi, double danaka) {
		//��پ߽ÿ� �ٳ����� ����� ���ؼ� ���и� ����Ѵ�.
		if (gobayashi==danaka) {
			System.out.println("���º�, ��پ߽� : "+gobayashi+
									", �ٳ��� : "+danaka); 
		} else if (gobayashi>danaka) {
			System.out.println("��پ߽� ��, ��پ߽� : "+gobayashi+
										", �ٳ��� : "+danaka);
		} else {
			System.out.println("�ٳ��� ��, ��پ߽� : "+gobayashi+
										", �ٳ��� : "+danaka);
		}
	}
}