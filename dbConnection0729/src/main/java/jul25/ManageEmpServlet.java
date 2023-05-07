package jul25;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Jul25/ManageEmp")
public class ManageEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ManageEmpServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("ID"); //사번을 수신
		//사번을 조건으로 사원정보를 검색한다.
		String select="select employee_id, first_name, last_name, email, phone_number"
				+ ", to_char(hire_date, 'YYYY-MM-DD'), job_id, salary, commission_pct"
				+ ", manager_id, department_id from my_empls where employee_id = "+id+" ";
		//String select2="select employee_id, first_name, last_name, email, phone_number"
				//+ ", to_char(hire_date, 'YYYY-MM-DD'), job_id, salary, commission_pct"
				//+ ", manager_id, department_id from my_empls where employee_id=?";
		Connection con= null; Statement stmt=null; //PreparedStatement pstmt= null;
		ResultSet rs=null; Employee emp= new Employee();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr"); //DB와 접속
			///////////PreparedStatement를 사용하는 경우
			//pstmt=con.prepareStatement(select2);
			//pstmt.setInt(1, Integer.parseInt(id));
			//pstmt.executeQuery();
			/////////////////////////////////////////
			//////////Statement를 사용하는 경우
			stmt= con.createStatement();
			rs=stmt.executeQuery(select);
			rs.next(); //조회 결과로 이동
			
			emp.setEmp_id(rs.getInt(1)); //사번을 저장
			emp.setFirst_name(rs.getString(2)); //성을 저장
			emp.setLast_name(rs.getString(3)); //이름을 저장
			emp.setEmail(rs.getString(4)); //이메일을 저장
			emp.setPhone(rs.getString(5)); //전화번호를 저장
			emp.setHire_date(rs.getString(6)); //입사일을 저장
			emp.setJob_id(rs.getString(7)); //업무코드를 저장
			emp.setSalary(rs.getInt(8)); //월급을 저장
			emp.setComm(rs.getDouble(9)); //커미션을 저장
			emp.setManager_id(rs.getInt(10)); //관리자 사번을 저장
			emp.setDept_id(rs.getInt(11)); //부서번호를 저장
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close(); stmt.close(); rs.close();
			}catch(Exception e) {
				
			}
		}
		request.setAttribute("EMP", emp);
		RequestDispatcher rd=request.getRequestDispatcher("manageEmp.jsp");
		rd.forward(request, response);
	}
}