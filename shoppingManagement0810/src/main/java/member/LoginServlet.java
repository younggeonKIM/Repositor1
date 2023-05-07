package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("ID");
		String pwd=request.getParameter("PWD");
		//������ ���̺� �ִ� ������ ��ȣ�� ���Ѵ�.
		String select="select password from member_info_tbl " + "where id=?";
		String result=""; //�α��� ����� ���� ���� ����
		Connection con=null; PreparedStatement pstmt =null; ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/xe","hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {//��ȸ ����� �̵� ����, �� ��ȸ��� ����.
				String pwdInDB=rs.getString(1);//��ȸ���
				if(pwdInDB.equals(pwd)) {//�Է��� ��ȣ�� DB�� ��ȣ�� ��
					result="OK";//�α��� ����
					HttpSession session = request.getSession();
					session.setAttribute("LOGINID",id);
				}
				else {
					result="NOPWD";//��ȣ ����ġ
				}
			}else {//��ȸ ����� �̵� ����, �� ��ȸ��� ����.
				result="NOID";//���� ����
			}
		}catch (Exception e) {
			
		}finally {
			try {
				con.close(); pstmt.close(); rs.close();
			}catch (Exception e) {}
		}
		//�α��� ��� JSP(loginResult.jsp)�� ��ȯ
		//1.Redirect, 2.Forward, 3.��� ����. -->Redirect
		response.sendRedirect("loginResult.jsp?R="+result);
	}

}
