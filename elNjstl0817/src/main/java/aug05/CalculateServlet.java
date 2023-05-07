package aug05;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate.do")
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalculateServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn=request.getParameter("btn");
		String n1=request.getParameter("N1");
		String n2=request.getParameter("N2");
		int n1Int=Integer.parseInt(n1);
		int n2Int=Integer.parseInt(n2);
		int sum=n1Int+n2Int;
		int sub=n1Int-n2Int;
		int mul=n1Int*n2Int;
		int div=n1Int/n2Int;
		if(btn.equals("결과보기1")) {
			System.out.println("결과보기 1 선택");
		}else if(btn.equals("결과보기1_1")) {
			System.out.println("결과보기 1_1 선택");
		}
		//화면을 사칙연산의 결과(calcResult.jsp)로 전환
		//1.Redirect, 2.Forward, 3.둘다
		
//		response.sendRedirect("calcResult.jsp?A="+sum+
//				"&B="+sub+"&C="+mul+"&D="+div);
		
//		RequestDispatcher r= 
//				request.getRequestDispatcher("calcResult.jsp?A="+sum+"&B="+sub
//						+"&C="+mul+"&D="+div);
//		r.forward(request, response);
		
		request.setAttribute("A", sum);
		request.setAttribute("B", sub);
		request.setAttribute("C", mul);
		request.setAttribute("D", div);
		RequestDispatcher r= 
				request.getRequestDispatcher("calcResult.jsp");
		r.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
