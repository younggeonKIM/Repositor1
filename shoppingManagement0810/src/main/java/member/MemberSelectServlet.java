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

@WebServlet("/memberSelect.do")
public class MemberSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberSelectServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		String select = "select custno, custname, phone, address, "
				+ "to_char(joindate, 'YYYY-MM-DD'), grade, city from member_tbl_02"
				+ " where custno= "+id;
		Connection con=null; Statement stmt=null; ResultSet rs = null;
		Member mem=new Member();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/xe","hr","hr");
			stmt = con.createStatement();
			rs = stmt.executeQuery(select);
			rs.next(); //조회 결과로 이동(1번만 이동하면 됨. 조회할 데이터가 1건이라서.)
			mem.setCustno(rs.getInt(1)); //고객번호
			mem.setName(rs.getString(2)); //이름
			mem.setTel(rs.getString(3)); //전화번호
			mem.setAddr(rs.getString(4)); //주소
			mem.setDate(rs.getString(5)); //가입일
			mem.setGrade(rs.getString(6)); //등급
			mem.setCode(rs.getString(7)); //도시코드
		} catch(Exception e) {
			
		} finally {
			try {
				con.close(); stmt.close(); rs.close();
			}catch (Exception e) {}
		}
		request.setAttribute("MEM", mem);
		RequestDispatcher rd=request.getRequestDispatcher("memberDetail.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
