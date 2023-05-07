package jul22;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Jul22/registerBBS")
public class RigisterBBSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RigisterBBSServlet() {
        super();
        
    }
    String insertBBS (HttpServletRequest request, HttpServletResponse response) {
    	Connection con = null; PreparedStatement pstmt =null;
    	String insert = "insert into test_bbs values(" +
    					"?, ?, ?)";
    	String result = "";
    	String id = request.getParameter("ID");
    	String title=request.getParameter("TITLE");
    	String conten=request.getParameter("CONTENT");
    	try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr"); //DB와 접속
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, conten);
			pstmt.executeUpdate();
			//Redirect, Forward 
			result= "OK";
		}catch(Exception e) {
			result= "NOK";
		}finally {
			try {
				con.close(); pstmt.close();
			}catch(Exception e) {
				
			}
		}
    	return result;
    	
    }
    String updateBBS (HttpServletRequest request, HttpServletResponse response) {
    	Connection con = null; PreparedStatement pstmt= null;
    	
    	String result="";
    	String conten = request.getParameter("CONTENT");
    	String title = request.getParameter("TITLE");
    	String id=request.getParameter("ID");	
    	String update="update test_bbs set content=?"+
				"where id=? and title=?";
    	try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr"); //DB와 접속
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, conten);
			pstmt.setString(2, id);
			pstmt.setString(3, title);
			pstmt.executeUpdate();
			result="OK";
		}catch(Exception e) {
			result="NOK";
		}finally {
			try {
				con.close(); pstmt.close();
			}catch(Exception e) {
				
			}
		}
    	return result;
    }
    String selectBBS (HttpServletRequest request) {
    	String select="select * from test_bbs where 1=1";
    	Connection con=null; PreparedStatement pstmt=null;
    	Statement stmt= null;
    	ResultSet rs = null; String result= "";
    	String id=request.getParameter("ID");
    	if (! id.equals("")) {
    		select=select+ " and id='"+id+"'";
    	}
    	String title=request.getParameter("TITLE");
    	if (! title.equals("")) {
    		select=select + " and title='"+title+"'";
    	}
    	String conten=request.getParameter("CONTENT");
    	if (! conten.equals("")) {
    		select=select+ " and content like'%"+conten+"%'";
    	}
    	try {
    		Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr"); //DB와 접속
			stmt=con.createStatement();
			System.out.println("생성된 쿼리: "+select);
			rs = stmt.executeQuery(select);
			System.out.println("작성자     글제목     글내용");
			System.out.println("========================");
			while(rs.next()) {
				String idd=rs.getString("id");
				String titlee=rs.getString("title");
				String contenn=rs.getString("CONTENT");
				System.out.println(idd+", "+titlee+", "+contenn);
			}
			System.out.println("조회가 완료됐습니다!");
			result="OK";
    	} catch(Exception e) {
    		result="NOK";
    	} finally {
    		try {
    			rs.close(); pstmt.close(); con.close();
    		} catch(Exception e) {
    			
    		}
    	}
    	return result;
    }
    String deleteBBS (HttpServletRequest request, HttpServletResponse response) {
    	Connection con = null; PreparedStatement pstmt= null;
    	String id= request.getParameter("ID");
    	
    	String delete= "delete from test_bbs where id=?";
    	String result="";
    	try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.182:1521/xe",
							"hr","hr"); //DB와 접속
			pstmt=con.prepareStatement(delete);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			result="OK";
		}catch(Exception e) {
			result="NOK";
		}finally {
			try {
				con.close(); pstmt.close();
			}catch(Exception e) {
				
			}
		}
    	return result;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String btn=request.getParameter("btn");
		String result="";
		String html="";
		if (btn.equals("등 록")) {
			result=insertBBS(request, response);
			html="insertResult.jsp?R="+result;
		} else if (btn.equals("수 정")) {
			result=updateBBS(request, response);
			html="updateResult.jsp?R="+result;
		} else if (btn.equals("삭 제")) {
			result=deleteBBS(request, response);
			html="deleteResult.jsp?R="+result;
		} else if (btn.equals("조 회")) {
			result=selectBBS(request);
			html="selectResult.jsp?R="+result;
		}
		response.sendRedirect(html);
	}
}