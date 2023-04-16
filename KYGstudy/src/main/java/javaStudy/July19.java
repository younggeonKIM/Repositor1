package javaStudy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/July19")
public class July19 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public July19() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperatorEx4.main(null);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
class OperatorEx3 {
	public static void main(String args[]) {
		int i=5, j=5;
		System.out.println(i++);
		System.out.println(++j);
		System.out.println("i = " + i + ", j = " +j);
		
		int x=5;
		x= x++ - ++x;
		System.out.println(x);
	}
}
class OperatorEx4 {
	public static void main(String[] args) {
		int i = -10;
		i = +i;
		System.out.println(i);
		
		i= -10;
		i= -i;
		System.out.println(i);
	}
}