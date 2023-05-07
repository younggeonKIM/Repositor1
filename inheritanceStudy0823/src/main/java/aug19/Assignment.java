package aug19;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class JavaDep {
	Goods g1 = new Goods();
	Goods b1 = new Bag();
	Goods w1 = new Watch();
	Goods s1 = new Shoe();
	Yoshida y1=new Yoshida();
}
class Goods {
	Goods () {}
	int price;
	int getPrice () {return price;} 
}
class Bag extends Goods{
	int getPrice () {
		price=(int)((Math.random()*5)+5);
		return price;
	}
}
class Watch extends Goods{
	int getPrice () {
		price=(int)((Math.random()*5)+5);
		return price;
	}
}
class Shoe extends Goods{
	int getPrice () {
		price=(int)((Math.random()*5)+5);
		return price;
	}
}
class Yoshida {
	int sales=0;
	void sell(Goods g) {
		sales=sales+g.getPrice();
	}
}
@WebServlet(name = "Aug19Assignment", urlPatterns = { "/Aug19Assignment" })
public class Assignment extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JavaDep jd=new JavaDep();
		jd.y1.sell(jd.b1); 
		jd.y1.sell(jd.w1);
		jd.y1.sell(jd.s1);
		System.out.println("요시다 판매원이 판매한 모든 물품의 가격 합 : "+jd.y1.sales);
		
	}
	private static final long serialVersionUID = 1L;

    public Assignment() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
