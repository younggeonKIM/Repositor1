package aug18;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TV, ��ǻ��, ����� �ֽ��ϴ�. ����(10��, 30��, 20��)�� �ֽ��ϴ�.
//����� �뵷�� �鸸 �� ������ �ֽ��ϴ�.
//����� �뵷���� TV, ��ǻ��, ����� �����߽��ϴ�.
//����(�޼���):����� �뵷-TV�� ����
//����(�޼���):����� �뵷-��ǻ���� ����
//����(�޼���):����� �뵷-������� ����
//����� �뵷 �ܾ��� ����մϴ�.

@WebServlet("/Aug18Study2")
public class Aug18Study2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TV tv=new TV();
		Computer com=new Computer();
		Ref rf=new Ref();
		Suzuki su=new Suzuki();
		System.out.println("����� �뵷 : "+su.pocketMoney);
		su.buy(tv);//TV�� ������
		su.buy(com);//��ǻ�͸� ������
		su.buy(rf);//����� ������
		System.out.println("����� �뵷 : "+su.pocketMoney);
	}
	private static final long serialVersionUID = 1L;

    public Aug18Study2() {
        super();
    }
    class Suzuki {
    	Suzuki(){}
    	int pocketMoney=1000000;
    	void buy (Item a) {
    		pocketMoney=pocketMoney-a.price;
    	}    	
//    	void buy (TV a) {
//    		pocketMoney=pocketMoney-a.price;
//    	} //TV�� �����ϴ� �޼���
//    	void buy (Computer b) {
//    		pocketMoney=pocketMoney-b.price;
//    	} //��ǻ�͸� �����ϴ� �޼���
//    	void buy (Ref c) {
//    		pocketMoney=pocketMoney-c.price;
//    	} //����� �����ϴ� �޼���
    }
    class Item {
    	int price;
    	Item(){}
    }//����
    class TV extends Item{
    	TV(){price=100000;}//������
    }
	class Ref extends Item {
		Ref(){price=200000;}//������
	}
	class Computer extends Item{
		Computer(){price=300000;}//������
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}