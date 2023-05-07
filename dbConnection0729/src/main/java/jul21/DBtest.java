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
		insert=insert+"220721,'홍','길동','hong@naver.com',";
		insert=insert+"'010-1234-0987',sysdate,'IT_PROG',";
		insert=insert+"500,null,200208,8009)";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr");
			stmt = con.createStatement();
			int r =stmt.executeUpdate(insert); //삽입, 삭제, 변경
			System.out.println("DB연동이 성공!");
			if (r > 0) System.out.println("삽입 성공!");
			else System.out.println("삽입 실패!");
		}catch(Exception e) {
			System.out.println("DB연동이 실패!");
		}finally {
			try {
				con.close(); //접속을 해제.
				stmt.close(); //쿼리 실행 객체를 해제.
			}catch (Exception e) {
				
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}