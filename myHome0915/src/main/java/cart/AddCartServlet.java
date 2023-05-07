package cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addCart.do")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddCartServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("CODE");
		HttpSession ss=request.getSession();
		String id = (String) ss.getAttribute("LOGINID");
		
		if(id == null) { //�α����� �� �� ���
			response.sendRedirect("login.jsp?CART=YES");
		} else { //�α����� �� ���
			Cart cart=(Cart)ss.getAttribute("CART");
			cart = new Cart(id);
			cart.addCart(code, 1); //��ǰ��ȣ�� 1�� ��ٱ��Ͽ� ����
			ss.setAttribute("CART", cart);
			response.sendRedirect("addCartResult.jsp");
		}
		//addCartResult.jsp�� ��ȯ
		//Redirect? Forward? --> Redirect
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
