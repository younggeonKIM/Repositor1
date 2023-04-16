package javaStudy;

import java.io.IOException;
import java.text.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class December25_1
 */
@WebServlet("/December25_1")
public class December25_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public December25_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageFormatEx1.main(null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class MessageFormatEx1 {
	public static void main(String[] args) {
		String msg = "Name: {0} \nTel: {1} \nAge: {2} \nBirthday: {3}";
		
		Object[] arguments = {
				"¿Ã¿⁄πŸ", "02-123-1234", "27", "07-09"
		};
		
		String result=
				MessageFormat.format(msg, arguments);
		System.out.println(result);
	}
}