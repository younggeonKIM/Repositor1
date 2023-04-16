package javaStudy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class December09_1
 */
@WebServlet("/December09_1")
public class December09_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public December09_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ThreadEx5.main(null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
class ThreadEx4 {
	public static void main (String args[]) {
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i<300 ; i++) System.out.printf("%s", new String("-"));
		
		System.out.print("소요시간1:" + (System.currentTimeMillis() - startTime));
		
		for (int i=0; i<300 ; i++) System.out.printf("%s", new String("|"));
		
		System.out.print("소요시간2:" + (System.currentTimeMillis() - startTime));
	}
}

class ThreadEx5 {
	static long startTime = 0 ;
	
	public static void main(String args[]) {
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();
		startTime = System.currentTimeMillis();
		
		for(int i =0; i<300 ; i++) System.out.printf("%s",  new String("-"));
		
		System.out.print("소요시간1:" + (System.currentTimeMillis() - ThreadEx5.startTime));
	}
}

class ThreadEx5_1 extends Thread {
	public void run() {
		for (int i = 0; i<300 ; i++) System.out.printf("%s", new String("|"));
		
		System.out.print("소요시간2:" + (System.currentTimeMillis() - ThreadEx5.startTime));
	}
}