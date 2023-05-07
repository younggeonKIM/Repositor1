package jul20;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Study1Servlet")
public class Study1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Study1Servlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int data1=100, data2=0;
		int result=0;
		try {
			result=data1/data2;
			System.out.print(data1+"을 "+data2+"로 나누면");
			System.out.print(result+"입니다.");
		} catch(ArithmeticException d) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch(NumberFormatException e) {
			System.out.println("숫자만 입력할 수 있습니다.");
		} catch(Exception e) {
			System.out.println("문제가 발생했습니다.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
