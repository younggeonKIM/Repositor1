package jul25;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Jul25/manageDo")
public class ManageDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManageDoServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id=request.getParameter("ID"); //사번을 수신
		String btn=request.getParameter("btn"); //버튼제목을 수신
		String result=""; //작업의 결과를 위한 변수 선언
		if (btn.equals("삭제")) {
			result=deleteEmp(id);
		} else if (btn.equals("수정")) {
			result=updateEmp(request);
		}
		response.sendRedirect("manageResult.jsp?R="+result);
	}
	String updateEmp (HttpServletRequest request) {
		String id=request.getParameter("ID"); //사번 수신
		String f=request.getParameter("FIRST"); //성 수신
		String l=request.getParameter("NAME"); //이름 수신
		String email=request.getParameter("EMAIL"); //이메일 수신
		String tel=request.getParameter("TEL"); //연락처 수신
		String hire=request.getParameter("HIRE"); //입사일 수신
		String job=request.getParameter("JOB"); //업무코드 수신
		String salary=request.getParameter("SALARY"); //월급 수신
		String comm=request.getParameter("COMM"); //커미션 수신
		String man=request.getParameter("MAN"); //관리자 사번 수신
		String dept=request.getParameter("DEPT"); //부서 번호 수신
		String update="update my_empls set first_name = ?, last_name = ?, "+
					"email = ?, phone_number = ?, "
					+ "hire_date = to_date(?, 'YYYY/MM/DD'),"+
					"job_id = ?, salary = ?, commission_pct = ?, "
					+ "manager_id = ?, "+
					"department_id = ? where employee_id = ?";
		Connection con =null; PreparedStatement pstmt = null; String result="";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr"); //DB와 접속
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, f);
			pstmt.setString(2, l);
			pstmt.setString(3, email);
			pstmt.setString(4, tel);
			pstmt.setString(5, hire);
			pstmt.setString(6, job);
			pstmt.setInt(7, Integer.parseInt(salary));
			pstmt.setDouble(8, Double.parseDouble(comm));
			pstmt.setInt(9, Integer.parseInt(man));
			pstmt.setInt(10, Integer.parseInt(dept));
			pstmt.setInt(11, Integer.parseInt(id));
			pstmt.executeUpdate(); //수정 실행
			result="OK";
		} catch(Exception e) {
			result="NOK";
			e.printStackTrace();
		} finally {
			try {
				con.close(); pstmt.close();
			}catch (Exception e) {}
		}
		return result;
	}
	String deleteEmp(String empId) {
		String delete="delete from my_empls where employee_id =?";
		String result="";
		Connection con=null; PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr"); //DB와 접속
			pstmt=con.prepareStatement(delete);
			pstmt.setInt(1, Integer.parseInt(empId));
			pstmt.executeUpdate(); //삭제 실행
			result="OK";
		}catch (Exception e) {
			result="NOK";
		}finally {
			try {
				con.close(); pstmt.close();
			} catch(Exception e) {}
		}
		return result;
		
	}
}
