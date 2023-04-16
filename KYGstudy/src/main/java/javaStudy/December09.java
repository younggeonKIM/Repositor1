package javaStudy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class December09
 */
@WebServlet("/December09")
public class December09 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public December09() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { ThreadEx3.main(); }
		catch(Exception e) {
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
class ThreadEx2 {
	public static void main () throws Exception {
		ThreadEx2_1 t1 = new ThreadEx2_1();
		t1.start();
		
	}
}

class ThreadEx2_1 extends Thread {
	public void run() {
		throwException();
	}
	
	public void throwException () {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ThreadEx3 {
	public static void main () throws Exception {
		ThreadEx3_1 t1 = new ThreadEx3_1();
		t1.run();
	}
}

class ThreadEx3_1 extends Thread {
	public void run() {
		throwException();
	}
	
	public void throwException() {
		try {
			throw new Exception ();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}