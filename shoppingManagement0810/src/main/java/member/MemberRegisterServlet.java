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
		request.setCharacterEncoding("EUC-KR");//�ѱ�ó��
		String id=request.getParameter("ID");//ȸ����ȣ
		String name=request.getParameter("NAME");//�̸�
		String tel=request.getParameter("TEL");//��ȭ��ȣ
		String addr=request.getParameter("ADDR");//�ּ�
		String date=request.getParameter("DATE");//������
		//2022-07-28 ---> 20220728
		String year= date.substring(0,4);
		String month= date.substring(5,7);
		String date_= date.substring(8);
		System.out.println("������ ��¥ :"+date);
		date=year+month+date_;
		System.out.println("������ ��¥ :"+date);
		String grade=request.getParameter("LEVEL");//�����
		String city=request.getParameter("CITY");//�����ڵ�
		String insert="insert into member_tbl_02 "+
					"values(?,?,?,?,to_date(?, 'YYYYMMDD'),?,?)";
		Connection con=null; PreparedStatement pstmt=null; 
		String result=""; //���� ���������� ���� ���� ����
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/xe","hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1, Integer.parseInt(id)); //ȸ����ȣ
			pstmt.setString(2, name); //�̸�
			pstmt.setString(3, tel); //��ȭ��ȣ
			pstmt.setString(4, addr); //�ּ�
			pstmt.setString(5, date); //������
			pstmt.setString(6, grade); //���
			pstmt.setString(7, city); //�����ڵ�
			pstmt.executeUpdate(); //insert����
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