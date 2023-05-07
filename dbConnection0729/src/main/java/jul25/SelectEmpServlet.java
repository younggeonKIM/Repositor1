package jul25;

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

@WebServlet("/Jul25/selectEmp")
public class SelectEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SelectEmpServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id=request.getParameter("ID");
		String first=request.getParameter("FIRST");
		String last=request.getParameter("LAST");
		String email=request.getParameter("EMAIL");
		String phone=request.getParameter("TEL");
		String hire=request.getParameter("HIRE");
		String job=request.getParameter("JOB");
		String salary=request.getParameter("SALARY");
		String comm=request.getParameter("COMM");
		String man=request.getParameter("MAN");
		String dept=request.getParameter("DEPT");
		
		String select="select * from my_empls where 1=1 ";
		Connection con = null; Statement stmt= null; String result="";
		ResultSet rs= null; ArrayList al = new ArrayList();
		if (! id.equals("")) select=select+"and employee_id="+id+" ";
		if (! first.equals("")) select=select+"and first_name='"+first+"' ";
		if (! last.equals("")) select=select+"and last_name='"+last+"' ";
		if (! email.equals("")) select=select+"and email='"+email+"' ";
		if (! phone.equals("")) select=select+"and phone_number='"+phone+"' ";
		if (! hire.equals("")) {
			select=select+
					"and to_char(hire_date, 'YYYY-MM-DD')='"+hire+"' ";
		}
		if (! job.equals("")) select=select+"and job_id='"+job+"' ";
		if (! salary.equals("")) select=select+"and salary="+salary+" ";
		if (! comm.equals("")) select=select+"and commission_pct="+comm+" ";
		if (! man.equals("")) select=select+"and manager_id="+man+" ";
		if (! dept.equals("")) select=select+"and department_id="+dept;
		System.out.println("생성된 쿼리:"+select);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr"); //DB와 접속
			stmt= con.createStatement();
			rs=stmt.executeQuery(select);
			while(rs.next()) {
				int a=rs.getInt("employee_id");
				String b=rs.getString("first_name");
				String c=rs.getString("last_name");
				String d=rs.getString("email");
				String e=rs.getString("phone_number");
				String f=rs.getString("hire_date");
				String g=rs.getString("job_id");
				int h=rs.getInt("salary");
				int i=rs.getInt("commission_pct");
				int j=rs.getInt("manager_id");
				int k=rs.getInt("department_id");
				//조회 결과를 Employee 객체에 저장한다.
				Employee emp = new Employee(); //DTO 생성
				emp.setEmp_id(a); //사번을 저장
				emp.setFirst_name(b); //성을 저장
				emp.setLast_name(c); //이름을 저장
				emp.setEmail(d); //이메일을 저장
				emp.setPhone(e); //전화번호를 저장
				emp.setHire_date(f); //입사일을 저장
				emp.setJob_id(g); //업무코드를 저장
				emp.setSalary(h); //월급을 저장
				emp.setComm(i); //커미션을 저장
				emp.setManager_id(j); //관리자 사번을 저장
				emp.setDept_id(k); //부서번호를 저장
				//ArrayList에 Employee 객체를 저장한다.
				al.add(emp);
			}
			result="OK";
		}catch (Exception e) {
			result="NOK";
			System.out.println("조회작업 중 문제발생!");
			e.printStackTrace();
		}finally {
			try {
				con.close(); stmt.close(); rs.close();
			}catch(Exception e) {}
		}
		//페이지를 조회결과(empList.jsp)로 전환한다.
		//Redirect, Forward 중 Forward만 가능하다. 객체가 전달되야 하므로.
		//조회결과 저장된 ArrayList로 empList.jsp로 전달한다.
		request.setAttribute("EMPS", al); 
		RequestDispatcher rd =request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);
	}
}