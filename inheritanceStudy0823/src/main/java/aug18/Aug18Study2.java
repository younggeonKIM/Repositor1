package aug18;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TV, 컴퓨터, 냉장고가 있습니다. 가격(10만, 30만, 20만)이 있습니다.
//스즈끼가 용돈을 백만 원 가지고 있습니다.
//스즈끼가 용돈으로 TV, 컴퓨터, 냉장고를 구매했습니다.
//구매(메서드):스즈끼의 용돈-TV의 가격
//구매(메서드):스즈끼의 용돈-컴퓨터의 가격
//구매(메서드):스즈끼의 용돈-냉장고의 가격
//스즈끼의 용돈 잔액을 출력합니다.

@WebServlet("/Aug18Study2")
public class Aug18Study2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TV tv=new TV();
		Computer com=new Computer();
		Ref rf=new Ref();
		Suzuki su=new Suzuki();
		System.out.println("스즈끼의 용돈 : "+su.pocketMoney);
		su.buy(tv);//TV를 구매함
		su.buy(com);//컴퓨터를 구매함
		su.buy(rf);//냉장고를 구매함
		System.out.println("스즈끼의 용돈 : "+su.pocketMoney);
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
//    	} //TV를 구매하는 메서드
//    	void buy (Computer b) {
//    		pocketMoney=pocketMoney-b.price;
//    	} //컴퓨터를 구매하는 메서드
//    	void buy (Ref c) {
//    		pocketMoney=pocketMoney-c.price;
//    	} //냉장고를 구매하는 메서드
    }
    class Item {
    	int price;
    	Item(){}
    }//조상
    class TV extends Item{
    	TV(){price=100000;}//생성자
    }
	class Ref extends Item {
		Ref(){price=200000;}//생성자
	}
	class Computer extends Item{
		Computer(){price=300000;}//생성자
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}