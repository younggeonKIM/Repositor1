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
    final int a =200; //상수, 값을 바꿀 수 없다.
    int b=200;
    public Aug22Study() {
        super();
        
    }
    
	//자바 백화점이 있습니다. 이 백화점에 가전매장과 과일매장이 있습니다.
    class JavaDepartmentStore {
    	JavaDepartmentStore() {
    		em=new ElectroMart();
    		fm=new FruitMart();
    	}
    	Mart em;
    	Mart fm;
    }//자바 백화점
    abstract class Mart {
    	Product item1; Product item2;
    }
    class ElectroMart extends Mart{
    	ElectroMart () {
    		item1 =new TV(200000);
    		item2 =new Ref(300000);
    	}
    	
    }//가전매장
    class FruitMart extends Mart{
    	FruitMart () {
    		item1 =new Strawberry(9000);
    		item2 =new Banana(4000);
    	}
    }//과일매장
    
	//가전매장에 TV와 냉장고가 있습니다. 가격이 있습니다.
    class TV extends Product{
    	TV(int a) { price =a; }
    }
    class Ref extends Product{
    	Ref(int a) {price =a;}
    }
    
	//과일매장에 딸기와 바나나가 있습니다. 가격이 있습니다.
    class Strawberry extends Product{
    	Strawberry (int a) {price=a;}
    }
    class Banana extends Product{
    	Banana (int a) {price=a;}
    }
    abstract class Product {
    	int price;
    }
	//스즈끼군이 있습니다. 백만원을 가지고 있습니다.
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
    
	//스즈끼군이 자바 백화점에서 TV와 냉장고와 딸기와 바나나를 샀습니다.
    // -->스즈끼군이 TV를 샀습니다.
    // -->스즈끼군이 냉장고를 샀습니다.
    // -->스즈끼군이 딸기를 샀습니다.
    // -->스즈끼군이 바나나를 샀습니다.
	//스즈끼군의 남은 용돈을 출력합니다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		b=300;
		JavaDepartmentStore jds=new JavaDepartmentStore(); // 7개의 인스턴스
		Suzuki suz=new Suzuki(1000000);
		System.out.println("구매 전 스즈키의 용돈 : "+suz.pocketMoney);
		suz.buy(jds.em.item1); //TV 구매
		suz.buy(jds.em.item2); //냉장고 구매
		suz.buy(jds.fm.item1); //딸기 구매
		suz.buy(jds.fm.item2); //바나나 구매
		System.out.println("구매 후 스즈키의 용돈 : "+suz.pocketMoney);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}