package jul21;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Jul21/entryEmp")
public class EntryEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EntryEmpServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		String insert="insert into my_empls values(";
		insert = insert+id+","+"'"+first+"','"+last+"','";
		insert = insert+email+"','"+phone+"',";
		insert = insert+"to_date('"+hire+"','YY/MM/DD'),";
		insert = insert+"'"+job+"',"+salary+",";
		if(comm.equals("")) {
			insert=insert+"null,";
		} else {
			insert=insert+comm+",";
		}
		insert = insert+man+","+dept+")";
		
		Connection con=null; Statement stmt=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr"); //DB와 접속
			stmt=con.createStatement();
			stmt.executeUpdate(insert);
			System.out.println("삽입 성공!");
		} catch(Exception e) {
			System.out.println("DB작업 중 문제발생!");
		} finally {
			try {
				con.close(); stmt.close();
			} catch (Exception e) {
				
			}
		}
	}
}