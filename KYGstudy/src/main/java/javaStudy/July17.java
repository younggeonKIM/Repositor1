package javaStudy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/July17")
public class July17 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public July17() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OperatorEx2.main(null);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
class OperatorEx1 {
	public static void main(String args[]) {
		int i =5;
		i++;				// i=i+1;�� ���� �ǹ��̴�. ++i;�� �ٲ� �ᵵ ����� ����.
		System.out.println(i);
		
		i=5;				//����� ���ϱ� ���� i���� �ٽ� 5�� ����.
		++i;
		System.out.println(i);
	}
}
class OperatorEx2 {
	public static void main(String args[]) {
		int i =5; int j=0;
		
		j=i++;
		System.out.println("j=i++; ���� ��, i=" + i +", j="+ j);
		
		i=5;				//����� ���ϱ� ����, i�� j�� ���� �ٽ� 5�� 0���� ����
		j=0;
		
		j= ++i;
		System.out.println("j=++i; ���� ��, i=" + i +", j="+ j);
	}
}