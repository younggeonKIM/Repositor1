package aug11;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.CRUD;
import cart.Cart;
import items.CartItem;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("ID");
		String pwd=request.getParameter("PWD");
		String popUp=request.getParameter("CART");
		//고객정보 테이블에 있는 계정과 암호와 비교한다.
		CRUD crud =new CRUD();
		String result="";
		String pwdInDB=crud.getPwd(id);//조회결과
		if(pwdInDB == null) {//조회 결과로 이동 실패, 즉 조회결과 없음.
			result="NOID";//계정 없음
		}else if(pwdInDB.equals(pwd)) {//입력한 암호와 DB의 암호를 비교
			result="OK";//로그인 성공
			HttpSession session = request.getSession();
			
			if(id.equals("manager")) {//관리자 계정인 경우
				session.setAttribute("MANAGER", id);
			}else {
				session.setAttribute("LOGINID", id);
			}
			//DB에서 로그인 계정으로 장바구니를 찾는다. 시작
			List<CartItem> cartList=crud.getCart(id);
			if(cartList !=null) {
				Cart cart=new Cart(id);//장바구니를 생성
				for (int i=0 ; i < cartList.size() ; i++) {
					CartItem ci = cartList.get(i);
					cart.getCodeList().add(ci.getCode());
					cart.getNumList().add(ci.getNum());
				}
				session.setAttribute("CART", cart);
			}//장바구니 정보가 있는 경우
			//DB에서 로그인 계정으로 장바구니를 찾는다. 끝
		}else {
			result="NOPWD";//암호 불일치
		}
	
		//로그인 결과 JSP(loginResult.jsp)로 전환
		//1.Redirect, 2.Forward, 3.상관 없음. -->Redirect
		if(popUp!=null) { //팝업창을 통한 로그인
			response.sendRedirect("loginResult.jsp?R="+result+"&POPUP=YES");
		}else { //홈을 통한 로그인
			response.sendRedirect(
					"template.jsp?BODY=loginResult.jsp?R="+result);
		}
		
		}
	}

