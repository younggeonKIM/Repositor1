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
		
		if(id == null) { //로그인을 안 한 경우
			response.sendRedirect("login.jsp?CART=YES");
		} else { //로그인을 한 경우
			Cart cart=(Cart)ss.getAttribute("CART");
			cart = new Cart(id);
			cart.addCart(code, 1); //상품번호와 1을 장바구니에 저장
			ss.setAttribute("CART", cart);
			response.sendRedirect("addCartResult.jsp");
		}
		//addCartResult.jsp로 전환
		//Redirect? Forward? --> Redirect
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
