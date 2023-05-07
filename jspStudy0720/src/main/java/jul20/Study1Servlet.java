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
			System.out.print(data1+"�� "+data2+"�� ������");
			System.out.print(result+"�Դϴ�.");
		} catch(ArithmeticException d) {
			System.out.println("0���� ���� �� �����ϴ�.");
		} catch(NumberFormatException e) {
			System.out.println("���ڸ� �Է��� �� �ֽ��ϴ�.");
		} catch(Exception e) {
			System.out.println("������ �߻��߽��ϴ�.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
