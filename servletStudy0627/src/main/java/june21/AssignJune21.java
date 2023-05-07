package june21;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssignJune21")
public class AssignJune21 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AssignJune21() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChulSu Chu= new ChulSu();
		YoungHee Youn= new YoungHee();
		MinSu Min= new MinSu();
		Chu.dice(); Youn.dice();
		Chu.Jud( Youn.Num);
		Youn.Jud(Chu.Num);
		Min.Jud(Chu.Num, Youn.Num);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
class ChulSu {
	ChulSu() {}
	int Num=0;
	void dice () {
		Num=(int)(Math.random()*6)+1;
	}
	void Jud (int Young) {
		if (Num==Young) {
			System.out.println("���º��Դϴ�. ö�� : "+Num+", ���� : "+Young);
		}
		else if (Num>Young) {
			System.out.println("ö���� �¸��Դϴ�.ö�� : "+Num+", ���� : "+Young);
		} else {
			System.out.println("������ �¸��Դϴ�.ö�� : "+Num+", ���� : "+Young);
		}
	}
}
class YoungHee {
	YoungHee () {}
	int Num=0;
	void dice () {
		Num=(int)(Math.random()*6)+1;
	}
	void Jud (int Chul) {
		if (Chul==Num) {
			System.out.println("���º��Դϴ�. ö�� : "+Chul+", ���� : "+Num);
		}
		else if (Chul>Num) {
			System.out.println("ö���� �¸��Դϴ�.ö�� : "+Chul+", ���� : "+Num);
		} else {
			System.out.println("������ �¸��Դϴ�.ö�� : "+Chul+", ���� : "+Num);
		}
	}
}
class MinSu {
	MinSu () {}
	void Jud (int Chul, int Young) {
		if (Chul==Young) {
			System.out.println("���º��Դϴ�. ö�� : "+Chul+", ���� : "+Young);
		}
		else if (Chul>Young) {
			System.out.println("ö���� �¸��Դϴ�.ö�� : "+Chul+", ���� : "+Young);
		} else {
			System.out.println("������ �¸��Դϴ�.ö�� : "+Chul+", ���� : "+Young);
		}
	}
}