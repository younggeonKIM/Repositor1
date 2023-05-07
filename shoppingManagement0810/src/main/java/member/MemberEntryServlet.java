package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/memberEntry.do")
public class MemberEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberEntryServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 여부를 검사한다.
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("LOGINID");
		if (id==null) {
			response.sendRedirect("login.jsp?M=Y");
		}else {
		//고객정보테이블에서 가장 큰 회원정보를 찾는다.
		String select="select max(custno) from member_tbl_02";
		int custno =0; //조회된 고객 번호를 위한 변수
		Connection con =null; Statement stmt=null; ResultSet rs= null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/xe","hr","hr");
			stmt =con.createStatement();
			rs=stmt.executeQuery(select); //조회 실행
			rs.next(); //조회 결과로 이동
			custno=rs.getInt(1); //첫번째 조회 결과를 수신
			custno=custno+1; //새 고객의 고객번호
		}catch(Exception e) {
			
		}finally {
			try {
				con.close(); rs.close(); stmt.close();
			}catch(Exception e) {
				
			}
		}//custno를 entry.jsp로 넘겨준다.
		//Redirect, Forward, 둘 다? -->Forward
		RequestDispatcher rd=request.getRequestDispatcher(
				"entry.jsp?ID="+custno);
		rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}