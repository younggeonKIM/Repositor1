package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberRegister.do")
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberRegisterServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");//한글처리
		String id=request.getParameter("ID");//회원번호
		String name=request.getParameter("NAME");//이름
		String tel=request.getParameter("TEL");//전화번호
		String addr=request.getParameter("ADDR");//주소
		String date=request.getParameter("DATE");//가입일
		//2022-07-28 ---> 20220728
		String year= date.substring(0,4);
		String month= date.substring(5,7);
		String date_= date.substring(8);
		System.out.println("변경전 날짜 :"+date);
		date=year+month+date_;
		System.out.println("변경후 날짜 :"+date);
		String grade=request.getParameter("LEVEL");//고객등급
		String city=request.getParameter("CITY");//도시코드
		String insert="insert into member_tbl_02 "+
					"values(?,?,?,?,to_date(?, 'YYYYMMDD'),?,?)";
		Connection con=null; PreparedStatement pstmt=null; 
		String result=""; //가입 성공유무를 위한 변수 선언
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/xe","hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1, Integer.parseInt(id)); //회원번호
			pstmt.setString(2, name); //이름
			pstmt.setString(3, tel); //전화번호
			pstmt.setString(4, addr); //주소
			pstmt.setString(5, date); //가입일
			pstmt.setString(6, grade); //등급
			pstmt.setString(7, city); //도시코드
			pstmt.executeUpdate(); //insert실행
			result="OK";
		}catch(Exception e) {
			result="NOK";
			e.printStackTrace();
		}finally {
			try {
				con.close(); pstmt.close();
			}catch (Exception e) {
				
			}
		}
		response.sendRedirect("registerResult.jsp?R="+result);
	}
}