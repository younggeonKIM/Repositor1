package items;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.CRUD;

@WebServlet("/putItem.do")
public class PutItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PutItemServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id=request.getParameter("ID");
		String name=request.getParameter("NAME");
		String price=request.getParameter("PRICE");
		String code=request.getParameter("CODE");
		String spec=request.getParameter("CONTENT");
		
		Item it=new Item(); //DTO 생성
		it.setId(id); it.setName(name); it.setPric(Integer.parseInt(price));
		it.setOrig(code); it.setSpec(spec);
		CRUD crud=new CRUD();
		int result=crud.putItem(it); //상품정보 삽입
		
		//페이지 전환(서블릿(상품목록 조회)매핑)
		//상품목록 조회 서블릿의 매핑 이름 : getAllItems
		//Redirect, Forward
		response.sendRedirect("getAllItems?R="+result);
	}
}
