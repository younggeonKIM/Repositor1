package june15;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jun15/matjipFind.do")
public class MatjipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MatjipServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("TOWN");
		MatjipExpert me=new MatjipExpert();
		String[] result=me.findMatjip(name);
		//탐색된 맛집을 matjipResult.jsp로 전달한다.
		request.setAttribute("Matj", result);
		RequestDispatcher rd=request.getRequestDispatcher("matjipResult.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}//서블릿의 끝
class MatjipExpert {
	MatjipExpert () {}//생성자 선언
	//맛집을 찾아주는 메서드
	String[] findMatjip(String town) {
		String[] names=new String[3];
		if (town.equals("1")) {//종로구를 선택
			names[0]="종로면옥"; names[1]="종로김밥"; names[2]="종로일식";
		}else if (town.equals("2")) {//강서구를 선택
			names[0]="강서면옥"; names[1]="강서김밥"; names[2]="강서일식";
		}else if (town.equals("3")) {//강남구를 선택
			names[0]="강남면옥"; names[1]="강남김밥"; names[2]="강남일식";
		}else {//마포구를 선택
			names[0]="마포면옥"; names[1]="마포김밥"; names[2]="마포일식";
		}
		return names;
	}
}//맛집 전문가 객체 선언
