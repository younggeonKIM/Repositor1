package june15;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jun15/medalServlet.do")
public class MedalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MedalServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nations=request.getParameter("Coun");
		MedalNum be=new MedalNum();
		int[] Medals=be.findMeN(nations);
		request.setAttribute("MEDAL", Medals);
		String natName=""; //�����̸��� ���� ���� ����
		switch (nations) {
		case "1": natName="���ѹα�"; break;
		case "2": natName="�Ϻ�"; break;
		case "3": natName="�߱�"; break;
		}
		request.setAttribute("Nation",natName);
		RequestDispatcher rd=request.getRequestDispatcher("medalResult.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}//������ ��
class MedalNum {
	MedalNum() {} 
	int[] medas=new int[3];
	int []findMeN(String count) {
		if (count.equals("1")) {
			medas[0]=10; medas[1]=9; medas[2]=8;		
		} else if (count.equals("2")) {
			medas[0]=8; medas[1]=7; medas[2]=6;
		} else if (count.equals("3")){
			medas[0]=6; medas[1]=5; medas[2]=4;
		}
		return medas;
	}
}//Ŭ������ ��
class Korea {
	Korea () {}
	String name = "���ѹα�";
	int gold=10; int silver=9; int bronze=8;
}
class Japan {
	Japan () {}
	String name = "�Ϻ�";
	int gold=8; int silver=7; int bronze=6;
}
class China {
	China () {}
	String name = "�߱�";
	int gold=6; int silver=5; int bronze=4;
}