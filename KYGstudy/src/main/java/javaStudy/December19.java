package javaStudy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class December19
 */
@WebServlet("/December19")
public class December19 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public December19() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{ThreadEx7.main(null);}
		catch(Exception e) {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class ThreadEx6 {
	public static void main(String[] args) throws Exception {
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 "+input+"입니다.");
		
		for(int i =10; i>0 ; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); //1초간 시간을 지연한다.
			}catch(Exception e) {}
		}
	}
}
class ThreadEx7 {
	public static void main(String[] args) throws Exception {
		ThreadEx7_1 th1 = new ThreadEx7_1();
		th1.start();
		
		String input= JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 "+input+"입니다.");
	}
}
class ThreadEx7_1 extends Thread {
	public void run() {
		for (int i =10; i>0 ; i--) {
			System.out.println(i);
			try {sleep(1000);}
			catch(Exception e) {}
		}
	}
}
