package june16;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/jun16/findCinema.do")
public class CinemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CinemaServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cine=request.getParameter("GENRE");
		CinemaExpert BE=new CinemaExpert();
		
		String[] movies=BE.SelectMovies(cine);
		request.setAttribute("MOV", movies);
		
		String[] cinema=BE.FindCinemaName(cine);
		request.setAttribute("CIN", cinema);
		String genr="";
		switch (cine) {
		case "1": genr="����"; break;
		case "2": genr="����"; break;
		case "3": genr="�ڹ̵�"; break;
		case "4": genr="������"; break;
		case "5": genr="���"; break;
		}
		request.setAttribute("GEN", genr);
		RequestDispatcher rd=
				request.getRequestDispatcher("cinemaResult2.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
class CinemaExpert {
	CinemaExpert () {}
	
	String[] SelectMovies(String name) {
		String[] genres= {"1", "2", "3", "4", "5"};
		String[][] movies= {
				{"�غ��б���", "���ǵ�������"},
				{"��������", "�������� Ȱ", "������ȭ��Ʈ", "���̾��Ϻ����ϱ�"},
				{"�� ����", "���ӽ�ĵ��", "7�ް�����", "7�������ູ"},
				{"������", "�߰���", "�Ǹ������Ҵ�", "�����ϵ�", "����", "ŷ����"},
				{"Riverdale", "�пպ���", "�ι̿����ٸ���", "����"}		
		};
		String [] recom=null;
		for (int i=0;i<genres.length;i++) {
			if (name.equals(genres[i])) {
				recom=new String[movies[i].length];
				for (int cnt=0; cnt<movies[i].length; cnt++) {
					recom[cnt]=movies[i][cnt];
				} //for�� ��
				break; //�ݺ��� �ߴ��Ѵ�.
			} //if�� ��
			
		} //for�� ��
		return recom;
	} //�޼����� ��
	
	String [] mov=new String[3];
	String[] FindCinemaName (String gen) {
		if (gen.equals("1")) { //����
			mov[0]="������"; mov[1]="�ΰ�����"; mov[2]="���2";
		} else if (gen.equals("2")) { //����
			mov[0]="Alexander"; mov[1]="�ű���"; mov[2]="������";
		} else if (gen.equals("3")) { //�ڹ̵�
			mov[0]="�� ����"; mov[1]="���ӽ�ĵ��"; mov[2]="�̳�±��ο�";
		} else if (gen.equals("4")) { //������
			mov[0]="�߰���"; mov[1]= "Whiplash"; mov[2]="�г�������";
		} else if (gen.equals("5")) { //���
			mov[0]="Five feet"; mov[1]="Cleopatra"; mov[2]="����";
		}
		return mov;
	}
}