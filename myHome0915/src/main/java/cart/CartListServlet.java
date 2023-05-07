package cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.CRUD;
import items.Item;

@WebServlet("/cartlist.do")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CartListServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession();
		Cart cart = (Cart)ss.getAttribute("CART");
		if(cart==null) { //��ٱ��ϰ� ���� ���
			request.setAttribute("LISTS", null);
		}else { //��ٱ��ϰ� �ִ� ���
			ArrayList<String> codeList= cart.getCodeList();
			ArrayList<Integer> numList= cart.getNumList();
			
			ArrayList<Item> itemList=new ArrayList<Item>();
			CRUD crud=new CRUD();
			int total=0; //�Ѿ� ����� ���� ���� ����
			for (int i = 0 ; i<codeList.size() ; i++) {
				String code=codeList.get(i);
				int num = numList.get(i);
				//code�� �ִ� ��ǰ��ȣ�� ��ȸ
				
				Item item=crud.getItem(code);
				item.setNum(num);
				total=total+(item.getPrice()*num);
				itemList.add(item);
			}
			request.setAttribute("LISTS", itemList);
			request.setAttribute("TOTAL", total);
		}
		RequestDispatcher r = 
				request.getRequestDispatcher(
						"template.jsp?BODY=cartList.jsp");
		r.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
