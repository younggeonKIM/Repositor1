package cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/modifyCart.do")
public class ModifyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ModifyCartServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String code=request.getParameter("CODE");
		String num=request.getParameter("NUM");
		String btn=request.getParameter("BTN");
		
		HttpSession ss=request.getSession();
		Cart cart=(Cart)ss.getAttribute("CART");
		if(cart!=null) { //��ٱ��ϰ� �����ϴ� ���
			if(btn.equals("����")) {
				cart.modifyItem(code, Integer.parseInt(num));
			}else if(btn.equals("����")) {
				cart.deleteItem(code);
			}
		}else { //��ٱ��ϰ� �������� �ʴ� ���
			
		}
		response.sendRedirect("cartlist.do");
	}

}