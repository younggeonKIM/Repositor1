package javaStudy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.text.*;

/**
 * Servlet implementation class December22_1
 */
@WebServlet("/December22_1")
public class December22_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public December22_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormatEx3.main(null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class DateFormatEx2 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2022, 9, 3); //2022�� 10�� 3�� - Month�� 0~11�� ������ ����.
		
		Date day = cal.getTime(); // Calendar�� Date�� ��ȯ
		
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("yy-MM-dd E����");
		sdf3 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		System.out.println(sdf1.format(day));
		System.out.println(sdf2.format(day));
		System.out.println(sdf3.format(day));
		System.out.println(sdf4.format(day));
	}
}

class DateFormatEx3 {
	public static void main (String[] args) {
		DateFormat df = new SimpleDateFormat ("yyyy�� MM�� dd��");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date d = df.parse("2015�� 11�� 23��");
			System.out.println(df2.format(d));
		}catch(Exception e ) {}
	}
}