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
		//�α��� ���θ� �˻��Ѵ�.
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("LOGINID");
		if (id==null) {
			response.sendRedirect("login.jsp?M=Y");
		}else {
		//���������̺��� ���� ū ȸ�������� ã�´�.
		String select="select max(custno) from member_tbl_02";
		int custno =0; //��ȸ�� �� ��ȣ�� ���� ����
		Connection con =null; Statement stmt=null; ResultSet rs= null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/xe","hr","hr");
			stmt =con.createStatement();
			rs=stmt.executeQuery(select); //��ȸ ����
			rs.next(); //��ȸ ����� �̵�
			custno=rs.getInt(1); //ù��° ��ȸ ����� ����
			custno=custno+1; //�� ���� ����ȣ
		}catch(Exception e) {
			
		}finally {
			try {
				con.close(); rs.close(); stmt.close();
			}catch(Exception e) {
				
			}
		}//custno�� entry.jsp�� �Ѱ��ش�.
		//Redirect, Forward, �� ��? -->Forward
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