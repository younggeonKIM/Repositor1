package dataStudy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sep22")
public class Sep22 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Sep22() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrimeNum.main();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
class PrimeNum {
	public static void main() {
		int num, i;
		for(num = 2; num <=100; num++) {
			for(i=2; i<=num/2; i++) {
				if(num%i==0) {
					break;
				}
			}
			if (i>num/2) {
				System.out.println(num);
			}
		}
	}
}