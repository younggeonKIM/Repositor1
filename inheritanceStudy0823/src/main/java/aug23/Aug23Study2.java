package aug23;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�䰡���� ��ü���� (������ �ִ� �� : ���� Ư¡, ���� Ư¡ ��� ����)
//���� Ư¡�� ���� Ư¡�� ���� �������̽��� ����
interface Birdd {
	void fly();//���� ���ٴ� �޼���(�߻� �޼���)
}//���� Ư¡�� ���� �������̽�
class Eagle implements Birdd {
	public void fly() {
		System.out.println("õõ�� ���ְ� ����.");
	}
}
class Sparrow implements Birdd {
	public void fly() {
		System.out.println("������ ������ �����̸� ����.");
	}
}
interface Horse {
	void run();//���� �پ�ٴϴ� �޼���(�߻� �޼���)
}//���� Ư¡�� ���� �������̽�
@WebServlet("/Aug23Study2")
public class Aug23Study2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Aug23Study2() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
