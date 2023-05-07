package sales;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/salesAll.do")
public class SalesAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SalesAllServlet() {
        super();
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("LOGINID");
		if (id==null) {
			response.sendRedirect("login.jsp?M=Y");
		}else {
		
		String select = "select t1.custno, t1.custname, t1.grade, t2.total "
				+ "from member_tbl_02 t1, "
				+ "(select custno, sum(price) total "
				+ "from money_tbl_02 group by custno) t2 "
				+ "where t1.custno = t2.custno order by total desc";
		Connection con=null; Statement stmt=null; ResultSet rs =null;
		ArrayList al= new ArrayList(); 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/xe","hr","hr");
			stmt=con.createStatement();
			rs=stmt.executeQuery(select);
			while(rs.next()) {
				Output otpt=new Output();
				otpt.setCustno(rs.getInt(1));
				otpt.setName(rs.getString(2));
				otpt.setGrade(rs.getString(3));
				otpt.setTotal(rs.getInt(4));
				al.add(otpt);
			}
		}catch(Exception e) {
			
		}finally {
			try {
				con.close(); stmt.close(); rs.close();
			}catch(Exception e) {
				
			}
		}
		request.setAttribute("LIST", al);
		RequestDispatcher rd = request.getRequestDispatcher("outputResult.jsp");
		rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
