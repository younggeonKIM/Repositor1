package javaStudy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/July14")
public class July14 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public July14() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CastingEx4.main(null);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
class CastingEx4 {
	public static void main (String[] args) {
		int i =91234567; // 8�ڸ��� 10����
		float f = (float)i; // int�� float�� ����ȯ
		int i2=(int)f; // float�� �ٽ� int�� ����ȯ
		
		double d = (double)i; // int�� double�� ����ȯ
		int i3 = (int)d; // double�� �ٽ� int�� ����ȯ
		
		float f2= 1.666f;
		int i4=(int)f2;
		
		System.out.printf("i=%d\n", i);
		System.out.printf("f=%f i2=%d\n", f, i2);
		System.out.printf("d=%f i3=%d\n", d, i3);
		System.out.printf("(int)%f=%d\n", f2, i4);
	}
}