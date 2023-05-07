package june21;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Jun21Servlet")
public class Jun21Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Jun21Servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Lemon le=new Lemon(); Kiwi ki=new Kiwi(); Grapes gr=new Grapes();
		System.out.println(le.price); //���� ����
		System.out.println(ki.price); //Ű�� ����
		System.out.println(gr.price); //���� ����
		FruitMart fm=new FruitMart(); 
		System.out.println(fm.le.price); //���ϰ��� ���� ���� ���� 
		System.out.println(fm.ki.price); //���ϰ��� ���� Ű�� ����
		System.out.println(fm.gr.price); //���ϰ��� ���� ���� ����
		if (le==fm.le) {
			System.out.println("����.");
		} else {
			System.out.println("�ٸ���.");
		}
		
		Bag mybag=new Bag();
		System.out.println(mybag.wal.pap.pric); 
			//���� ���� ���� ���� ������ �׸鰡 ���
		Paper paper1=new Paper();
		System.out.println(paper1.pric); 
			//������ �׸鰡 ���
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
//������ ������ 200���Դϴ�.
//Ű���� ������ 500���Դϴ�.
//������ ������ 800���Դϴ�.
//����� Ű���� ������ ���ϰ��� �ȿ� �ֽ��ϴ�.
//���ϰ��� �ȿ� �ִ� ����� Ű���� ������ ������ ����մϴ�.
class FruitMart {
	FruitMart () {}
	Lemon le=new Lemon(); Kiwi ki=new Kiwi(); Grapes gr=new Grapes();
} //���ϰ���
class Lemon {
	Lemon () {}
	int price=200;
}
class Kiwi {
	Kiwi () {}
	int price=500;
}
class Grapes {
	Grapes () {}
	int price=800;
}

//���� �ֽ��ϴ�. �׸鰡�� 1000���Դϴ�. 
//���� ���� �ȿ� �ֽ��ϴ�. 
//������ ���� �ȿ� �ֽ��ϴ�.
//��. ���� ���� ���� ���� ������ �׸鰡�� ����մϴ�.
class Paper {
	Paper () {}
	int pric=1000;
}
class Wallet {
	Wallet () {}
	Paper pap=new Paper ();
}
class Bag {
	Bag () {}
	Wallet wal=new Wallet();
}