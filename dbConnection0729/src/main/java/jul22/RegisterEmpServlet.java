package jul22;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Jul22/registerEmp")
public class RegisterEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterEmpServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	void insertEmp(HttpServletRequest request) {
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
		
		Connection con = null; PreparedStatement pstmt = null;
		String insert = "insert into my_empls "+
						"values(?, ?, ?, ?, ?, to_date(?,'YY/MM/DD'), ?, ?, ?, ?, ?)";
		//���������� �ִ� ����ǥ(?)�� ���� �����ͷ� �ٲ۴�.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr"); //DB�� ����
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, Integer.parseInt(id));
			pstmt.setString(2, first);
			pstmt.setString(3, last);
			pstmt.setString(4, email);
			pstmt.setString(5, phone);
			
			pstmt.setString(6, hire);
			pstmt.setString(7, job);
			pstmt.setInt(8, Integer.parseInt(salary));
			if(comm.equals("")) {
				pstmt.setString(9, null);
			}else {
				pstmt.setDouble(9, Double.parseDouble(comm));
			}
			pstmt.setInt(10, Integer.parseInt(man));
			pstmt.setInt(11, Integer.parseInt(dept));
			pstmt.executeUpdate(); //����, ���� , ����
			System.out.println("���� ����!");
		}catch(Exception e) {
			System.out.println("DBó�� �� ���� �߻�!");
		}finally {
			try {
				con.close(); pstmt.close();
			}catch(Exception e) {
				
			}
		}
	}
	void deleteEmp(HttpServletRequest request) {
		Connection con = null; PreparedStatement pstmt=null;
		String delete = "delete from my_empls where employee_id=?";
		String id=request.getParameter("ID");
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr"); //DB�� ����
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, Integer.parseInt(id));
			pstmt.executeUpdate(); //delete ���� ����
			System.out.println("���� �Ϸ�!");
		}catch(Exception e) {
			System.out.println("���� �۾� �� �����߻�!");
		}finally {
			try {
				con.close(); pstmt.close();
			}catch(Exception e) {
				
			}
		}
	}
	void updateEmp(HttpServletRequest req) {
		//����� �̸��� �޴´�.
		String id=req.getParameter("ID"); //����� ����
		String name=req.getParameter("LAST"); //�̸��� ����
		Connection con=null; PreparedStatement pstmt=null;
		String update="update my_empls set last_name =? " +
						"where employee_id = ?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr"); //DB�� ����
			pstmt = con.prepareStatement(update);
			pstmt.setInt(2, Integer.parseInt(id));
			pstmt.setString(1, name);
			pstmt.executeUpdate(); //update ���� ����
			System.out.println("���� �Ϸ�!");
		}catch (Exception e) {
			System.out.println("���� �۾� �� ���� �߻�!");
			e.printStackTrace();
		}finally {
			try {
				con.close(); pstmt.close();
			}catch (Exception e) {
				
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String btn=request.getParameter("btn"); //��ư���� ����
		if (btn.equals("�� ��")) {
			insertEmp(request);
		}else if (btn.equals("�� ��")) {
			deleteEmp(request);
		}else if (btn.equals("�� ��")) {
			updateEmp(request);
		}
	}
}