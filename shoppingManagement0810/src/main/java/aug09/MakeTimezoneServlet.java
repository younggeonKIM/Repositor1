package aug09;

import java.io.IOException;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/makeTimezone.do")
public class MakeTimezoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MakeTimezoneServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] timelist = TimeZone.getAvailableIDs();
		//시간대를 선택할 수 있는 JSP(selectTimezone.jsp)로 전환한다.
		
		request.setAttribute("TIMES", timelist);
		
		RequestDispatcher r=
				request.getRequestDispatcher("selectTimezone.jsp");
		r.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
