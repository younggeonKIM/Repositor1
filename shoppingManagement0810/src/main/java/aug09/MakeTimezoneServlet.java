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
		//�ð��븦 ������ �� �ִ� JSP(selectTimezone.jsp)�� ��ȯ�Ѵ�.
		
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
