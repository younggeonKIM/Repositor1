package june27;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/June27FirstServlet")
public class June27FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public June27FirstServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tiger t1= new Tiger(); t1.name="호돌이"; t1.age=1;
		Tiger t2= new Tiger ("호순이", 2);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
class Tiger {
	Tiger () {}
	String name; int age;
	
	Tiger (String name, int age) {
		//name=name; 가까운 지역 변수를 우선으로 지정함
		//age=age; 
		this.name=name; //현재 인스턴스 변수를 대상으로 지정함
		this.age=age;
	}
}
