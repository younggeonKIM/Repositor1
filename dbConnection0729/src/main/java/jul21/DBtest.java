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

@WebServlet("/DBtest")
public class DBtest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DBtest() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null; Statement stmt = null;
		String insert="insert into my_empls values(";
		insert=insert+"220721,'ȫ','�浿','hong@naver.com',";
		insert=insert+"'010-1234-0987',sysdate,'IT_PROG',";
		insert=insert+"500,null,200208,8009)";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr");
			stmt = con.createStatement();
			int r =stmt.executeUpdate(insert); //����, ����, ����
			System.out.println("DB������ ����!");
			if (r > 0) System.out.println("���� ����!");
			else System.out.println("���� ����!");
		}catch(Exception e) {
			System.out.println("DB������ ����!");
		}finally {
			try {
				con.close(); //������ ����.
				stmt.close(); //���� ���� ��ü�� ����.
			}catch (Exception e) {
				
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}