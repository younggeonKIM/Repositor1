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
		System.out.println("������ ����:"+select);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr"); //DB�� ����
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
				//��ȸ ����� Employee ��ü�� �����Ѵ�.
				Employee emp = new Employee(); //DTO ����
				emp.setEmp_id(a); //����� ����
				emp.setFirst_name(b); //���� ����
				emp.setLast_name(c); //�̸��� ����
				emp.setEmail(d); //�̸����� ����
				emp.setPhone(e); //��ȭ��ȣ�� ����
				emp.setHire_date(f); //�Ի����� ����
				emp.setJob_id(g); //�����ڵ带 ����
				emp.setSalary(h); //������ ����
				emp.setComm(i); //Ŀ�̼��� ����
				emp.setManager_id(j); //������ ����� ����
				emp.setDept_id(k); //�μ���ȣ�� ����
				//ArrayList�� Employee ��ü�� �����Ѵ�.
				al.add(emp);
			}
			result="OK";
		}catch (Exception e) {
			result="NOK";
			System.out.println("��ȸ�۾� �� �����߻�!");
			e.printStackTrace();
		}finally {
			try {
				con.close(); stmt.close(); rs.close();
			}catch(Exception e) {}
		}
		//�������� ��ȸ���(empList.jsp)�� ��ȯ�Ѵ�.
		//Redirect, Forward �� Forward�� �����ϴ�. ��ü�� ���޵Ǿ� �ϹǷ�.
		//��ȸ��� ����� ArrayList�� empList.jsp�� �����Ѵ�.
		request.setAttribute("EMPS", al); 
		RequestDispatcher rd =request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);
	}
}