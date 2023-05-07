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
		//Ž���� ������ matjipResult.jsp�� �����Ѵ�.
		request.setAttribute("Matj", result);
		RequestDispatcher rd=request.getRequestDispatcher("matjipResult.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}//������ ��
class MatjipExpert {
	MatjipExpert () {}//������ ����
	//������ ã���ִ� �޼���
	String[] findMatjip(String town) {
		String[] names=new String[3];
		if (town.equals("1")) {//���α��� ����
			names[0]="���θ��"; names[1]="���α��"; names[2]="�����Ͻ�";
		}else if (town.equals("2")) {//�������� ����
			names[0]="�������"; names[1]="�������"; names[2]="�����Ͻ�";
		}else if (town.equals("3")) {//�������� ����
			names[0]="�������"; names[1]="�������"; names[2]="�����Ͻ�";
		}else {//�������� ����
			names[0]="�������"; names[1]="�������"; names[2]="�����Ͻ�";
		}
		return names;
	}
}//���� ������ ��ü ����
