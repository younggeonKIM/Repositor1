package lotto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/byMyself/lotto_insert.do")
public class LottoInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LottoInsertServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String seqnum=request.getParameter("SEQNUM");
		String name=request.getParameter("NAME");
		String date=request.getParameter("DATE");
		System.out.println(date);
		String lotnum =request.getParameter("Lotnum");
		System.out.println("이름 : "+name+", 도전일 : "+date+
				", 당첨 추천번호 : "+lotnum);
		Connection con=null; Statement stmt=null;
		String result="";
		String insert="insert into lotto_info_tbl02 values("+seqnum+
					", '"+name+"', "+null+", '"+lotnum+"', to_date('"+date+"', 'YYYY-MM-DD'))";
		System.out.println(insert);
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/xe","hr","hr");
			stmt=con.createStatement();
			stmt.executeUpdate(insert);
			result="OK";
			System.out.println("등록이 성공했습니다.");
		}catch(Exception e ) {
			result="NOK";
			System.out.println("등록이 실패했습니다.");
			e.printStackTrace();
		}finally {
			try {
				con.close(); stmt.close();
			}catch(Exception e) {}
		}
		response.sendRedirect("lot_insert_res.jsp?R="+result);
	}
}