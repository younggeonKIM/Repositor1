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
		case "1": genr="공포"; break;
		case "2": genr="전쟁"; break;
		case "3": genr="코미디"; break;
		case "4": genr="스릴러"; break;
		case "5": genr="드라마"; break;
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
				{"해부학교실", "해피데스데이"},
				{"적벽대전", "최종병기 활", "스노우앤화이트", "라이언일병구하기"},
				{"세 얼간이", "과속스캔들", "7급공무원", "7번방의행복"},
				{"추적자", "추격자", "악마를보았다", "다이하드", "존윅", "킹스맨"},
				{"Riverdale", "패왕별희", "로미오와줄리엣", "마션"}		
		};
		String [] recom=null;
		for (int i=0;i<genres.length;i++) {
			if (name.equals(genres[i])) {
				recom=new String[movies[i].length];
				for (int cnt=0; cnt<movies[i].length; cnt++) {
					recom[cnt]=movies[i][cnt];
				} //for의 끝
				break; //반복을 중단한다.
			} //if의 끝
			
		} //for의 끝
		return recom;
	} //메서드의 끝
	
	String [] mov=new String[3];
	String[] FindCinemaName (String gen) {
		if (gen.equals("1")) { //공포
			mov[0]="컨저링"; mov[1]="인간지네"; mov[2]="고사2";
		} else if (gen.equals("2")) { //전쟁
			mov[0]="Alexander"; mov[1]="신기전"; mov[2]="고지전";
		} else if (gen.equals("3")) { //코미디
			mov[0]="세 얼간이"; mov[1]="과속스캔들"; mov[2]="미녀는괴로워";
		} else if (gen.equals("4")) { //스릴러
			mov[0]="추격자"; mov[1]= "Whiplash"; mov[2]="분노의질주";
		} else if (gen.equals("5")) { //드라마
			mov[0]="Five feet"; mov[1]="Cleopatra"; mov[2]="인턴";
		}
		return mov;
	}
}