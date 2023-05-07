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
		System.out.println(le.price); //레몬 가격
		System.out.println(ki.price); //키위 가격
		System.out.println(gr.price); //포도 가격
		FruitMart fm=new FruitMart(); 
		System.out.println(fm.le.price); //과일가게 안의 레몬 가격 
		System.out.println(fm.ki.price); //과일가게 안의 키위 가격
		System.out.println(fm.gr.price); //과일가게 안의 포도 가격
		if (le==fm.le) {
			System.out.println("같다.");
		} else {
			System.out.println("다르다.");
		}
		
		Bag mybag=new Bag();
		System.out.println(mybag.wal.pap.pric); 
			//가방 안의 지갑 안의 지폐의 액면가 출력
		Paper paper1=new Paper();
		System.out.println(paper1.pric); 
			//지폐의 액면가 출력
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
//레몬의 가격은 200원입니다.
//키위의 가격은 500원입니다.
//포도의 가격은 800원입니다.
//레몬과 키위와 포도가 과일가게 안에 있습니다.
//과일가게 안에 있는 레몬과 키위와 포도의 가격을 출력합니다.
class FruitMart {
	FruitMart () {}
	Lemon le=new Lemon(); Kiwi ki=new Kiwi(); Grapes gr=new Grapes();
} //과일가게
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

//지폐가 있습니다. 액면가가 1000원입니다. 
//지폐가 지갑 안에 있습니다. 
//지갑이 가방 안에 있습니다.
//문. 가방 안의 지갑 안의 지폐의 액면가를 출력합니다.
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