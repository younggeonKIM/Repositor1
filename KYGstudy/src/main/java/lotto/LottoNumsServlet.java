package lotto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/byMyself/lottonums.do")
public class LottoNumsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LottoNumsServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select ="select max(lotto_seq) from lotto_info_tbl02";
		Connection con=null; Statement stmt=null; ResultSet rs=null;
		int lotseq=0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/xe","hr","hr");
			stmt=con.createStatement();
			rs=stmt.executeQuery(select);
			rs.next();
			lotseq=rs.getInt(1);
			lotseq=lotseq+1;
		}catch (Exception e) {
			System.out.println("오류가 발생했습니다.");
			e.printStackTrace();
		}finally {
			try {
				con.close(); stmt.close(); rs.close();
			}catch(Exception e) {}
		}
		response.sendRedirect("lottonums_look.jsp?SEQ="+lotseq);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}