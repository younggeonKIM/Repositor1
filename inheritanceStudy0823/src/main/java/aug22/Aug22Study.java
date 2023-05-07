package aug22;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Aug22Study")
public class Aug22Study extends HttpServlet {
	private static final long serialVersionUID = 1L;
    final int a =200; //���, ���� �ٲ� �� ����.
    int b=200;
    public Aug22Study() {
        super();
        
    }
    
	//�ڹ� ��ȭ���� �ֽ��ϴ�. �� ��ȭ���� ��������� ���ϸ����� �ֽ��ϴ�.
    class JavaDepartmentStore {
    	JavaDepartmentStore() {
    		em=new ElectroMart();
    		fm=new FruitMart();
    	}
    	Mart em;
    	Mart fm;
    }//�ڹ� ��ȭ��
    abstract class Mart {
    	Product item1; Product item2;
    }
    class ElectroMart extends Mart{
    	ElectroMart () {
    		item1 =new TV(200000);
    		item2 =new Ref(300000);
    	}
    	
    }//��������
    class FruitMart extends Mart{
    	FruitMart () {
    		item1 =new Strawberry(9000);
    		item2 =new Banana(4000);
    	}
    }//���ϸ���
    
	//�������忡 TV�� ����� �ֽ��ϴ�. ������ �ֽ��ϴ�.
    class TV extends Product{
    	TV(int a) { price =a; }
    }
    class Ref extends Product{
    	Ref(int a) {price =a;}
    }
    
	//���ϸ��忡 ����� �ٳ����� �ֽ��ϴ�. ������ �ֽ��ϴ�.
    class Strawberry extends Product{
    	Strawberry (int a) {price=a;}
    }
    class Banana extends Product{
    	Banana (int a) {price=a;}
    }
    abstract class Product {
    	int price;
    }
	//������� �ֽ��ϴ�. �鸸���� ������ �ֽ��ϴ�.
    class Suzuki {
    	Suzuki (int a) {pocketMoney=a;}
    	int pocketMoney;
    	void buy(Product p) {
    		pocketMoney=pocketMoney-p.price;
    	}
//    	void buy(TV t) {pocketMoney=pocketMoney-t.price;}
//    	void buy(Ref r) {pocketMoney=pocketMoney-r.price;}
//    	void buy(Strawberry sb) {pocketMoney=pocketMoney-sb.price;}
//    	void buy(Banana bnn) {pocketMoney=pocketMoney-bnn.price;}
    }
    
	//������� �ڹ� ��ȭ������ TV�� ������ ����� �ٳ����� ����ϴ�.
    // -->������� TV�� ����ϴ�.
    // -->������� ����� ����ϴ�.
    // -->������� ���⸦ ����ϴ�.
    // -->������� �ٳ����� ����ϴ�.
	//������� ���� �뵷�� ����մϴ�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		b=300;
		JavaDepartmentStore jds=new JavaDepartmentStore(); // 7���� �ν��Ͻ�
		Suzuki suz=new Suzuki(1000000);
		System.out.println("���� �� ����Ű�� �뵷 : "+suz.pocketMoney);
		suz.buy(jds.em.item1); //TV ����
		suz.buy(jds.em.item2); //����� ����
		suz.buy(jds.fm.item1); //���� ����
		suz.buy(jds.fm.item2); //�ٳ��� ����
		System.out.println("���� �� ����Ű�� �뵷 : "+suz.pocketMoney);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}