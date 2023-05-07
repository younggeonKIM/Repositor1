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
		go.jump(); //고바야시가 넓이 뛰기를 함
		
		Danaka da=new Danaka();
		da.jump(); //다나까가 넓이 뛰기를 함
		
		Refere re=new Refere();	
		re.pandan(go.record,da.record);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
//객체 설계 문제 1.
//고바야시와 다나까가 있습니다.
//고바야시가 넓이 뛰기를 아직 안 했습니다. 기록이 0m입니다.
//고바야시가 넓이 뛰기를 했습니다. 기록이 1.15m입니다.
//다나까가 넓이 뛰기를 했습니다. 기록이 1.21m입니다.
//심판이 고바야시와 다나까의 중 더 많이 뛴 사람이 누구인지 판단합니다.

//문제 2. 기록을 난수로 한다.
//난수의 범위 : 100~200
//고바야시 115/100 -> 1.15
//다나까 121/100 ->1.21
class Gobayashi {
	Gobayashi () {} 
	double record=0; //인스턴스 (instance) 변수
	void jump () {
		int a=200; //지역 (local) 변수 (variable)
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
		//고바야시와 다나까의 기록을 비교해서 승패를 출력한다.
		if (gobayashi==danaka) {
			System.out.println("무승부, 고바야시 : "+gobayashi+
									", 다나까 : "+danaka); 
		} else if (gobayashi>danaka) {
			System.out.println("고바야시 승, 고바야시 : "+gobayashi+
										", 다나까 : "+danaka);
		} else {
			System.out.println("다나까 승, 고바야시 : "+gobayashi+
										", 다나까 : "+danaka);
		}
	}
}