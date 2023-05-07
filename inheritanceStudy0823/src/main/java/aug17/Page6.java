package aug17;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Page6")
public class Page6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Page6() {
        super();

    }
class IamKing {
	String name;
	IamKing(String name) {
		this.name=name;
	}
}
class IamSon extends IamKing {
	IamSon() {
		super("ȫ�浿"); //--->IamKing("ȫ�浿");
	}
}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IamSon s1 =new IamSon(); 
		IamKing k1 =new IamKing("a");
		IamKing k2 =new IamKing("Korea");
		IamKing k3 =new IamKing("ȫ�浿");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}