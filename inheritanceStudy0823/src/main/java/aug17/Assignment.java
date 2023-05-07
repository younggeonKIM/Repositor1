package aug17;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Assignment")
public class Assignment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Assignment() {
        super();

    }
    class One {
    	int i; String name;
    	One (int i) {
    		this.i=i;
    	}
    	One (String name) {
    		this.name=name;
    	}
    }
    class Two extends One {
    	Two (int i) {
    		super(i);
    	}
    	Two (String name) {
    		super(name);
    	}
    }
    
    class Hana {
	int i; int j; double k;
	Hana (int i, int j) {
		this.i=i; this.j=j;
	}
	Hana (double k) {
		this.k=k;
	}
}
class Dool extends Hana {
	Dool(int i, int j) {
		super(i,j);
	}
	Dool(double k) {
		super(k);
	}
}
class Seet extends Dool {
	Seet (int a, int b) {
		super(a, b);
	}
	Seet (double k) {
		super(k);
	}
}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		One o1=new One(2);
		One o2=new One("3");
		Two t1=new Two(3);
		Two t2=new Two("2");
		
		Hana h1=new Hana(1,2);
		Hana h2=new Hana(1.2);
		Dool d1=new Dool(3,4);
		Dool d2=new Dool(3.14);
		Seet s1=new Seet(10.5);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
