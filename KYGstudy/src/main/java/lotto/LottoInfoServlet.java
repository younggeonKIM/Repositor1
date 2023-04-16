package lotto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/byMyself/lottoinfo.do")
public class LottoInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LottoInfoServlet() {
        super();  
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String select="select lotto_seq, lotto_whom, lotto_grade, lotto_nums, "
//				+ "to_char(lotto_date, 'YY/MM/DD') from lotto_info_tbl02";
//		String select="select lotto_seq, lotto_whom, lotto_grade"
//				+ ", lotto_nums, dat from"
//				+ " (select lotto_seq, lotto_whom, lotto_grade"
//				+ ", lotto_nums, to_char(lotto_date, 'YY-MM-DD') dat, "
//				+ "rownum rn from lotto_info_tbl02) "
//				+ "where rn>? and rn<?";
//		Connection con=null; Statement stmt=null; ResultSet rs = null; 
//		
//		String page = request.getParameter("PNUM");
//		int totalNum = getLotInfNumCount();
//		
//		int pageNum = totalNum / 5 ; 
//		if(totalNum%5!=0) {
//			pageNum++;
//		}
//		ArrayList<Lotnum> al2 = getLotInfPagesInf(page);
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//			con=DriverManager.getConnection(
//					"jdbc:oracle:thin:@127.0.0.1:1521/xe","hr","hr");
//			stmt=con.createStatement();
//			rs=stmt.executeQuery(select);
//			System.out.println(select);
//			while (rs.next()) {
//				Lotnum ltnm=new Lotnum();
//				ltnm.setLotSeq(rs.getInt(1));
//				ltnm.setName(rs.getString(2));
//				String lotGrad = rs.getString(3);
//				if(lotGrad == null) {
//					lotGrad = "미확인";
//				}
//				ltnm.setGrade(lotGrad);
//				ltnm.setNums(rs.getString(4));
//				ltnm.setDate(rs.getString(5));
//				al2.add(ltnm);
//			}
//			System.out.println(al2);
//			System.out.println("추천 결과들 조회에 성공");
//		}catch (Exception e) {
//			System.out.println("추천 결과들 조회에 실패");
//			e.printStackTrace();
//		}finally {
//			try {
//				con.close(); stmt.close(); rs.close();
//			}catch (Exception e) {
//				
//			}
//		}
		
		String select="select lotto_seq, lotto_whom, lotto_grade"
				+ ", lotto_nums, dat from"
				+ " (select lotto_seq, lotto_whom, lotto_grade"
				+ ", lotto_nums, to_char(lotto_date, 'YY-MM-DD') dat, "
				+ "rownum rn from lotto_info_tbl02) "
				+ "where rn>? and rn<?";
		Connection con=null; PreparedStatement pstmt= null; 
		ResultSet rs = null; ArrayList<Lotnum> al = new ArrayList<Lotnum>();
		String page = request.getParameter("PNUM");
		int totalNum = getLotInfNumCount();
		int pageNum = totalNum / 5 ; 
		if(totalNum%5!=0) {
			pageNum++;
		}
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/xe","hr","hr");
			pstmt = con.prepareStatement(select);
			Integer pageCount=1;
			if(page!=null) {
				pageCount = Integer.parseInt(page);
				
			}
			pstmt.setInt(1, (pageCount-1)*5);
			pstmt.setInt(2, (pageCount-1)*5+6);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Lotnum ltnm = new Lotnum();
				ltnm.setLotSeq(rs.getInt(1));
				ltnm.setName(rs.getString(2));
				String lotGrad = rs.getString(3);
				if(lotGrad == null) {
					lotGrad = "미확인";
				}
				ltnm.setGrade(lotGrad);
				ltnm.setNums(rs.getString(4));
				ltnm.setDate(rs.getString(5));
				al.add(ltnm);
			}
			System.out.println("페이지별 5개 로또 테이블 정보 조회 성공");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("페이지별 5개 로또 테이블 정보 조회 실패");
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {
				
			}
		}
		request.setAttribute("AL", al);
		request.setAttribute("PAGE", pageNum);
		RequestDispatcher r=request.getRequestDispatcher("lottoinfo.jsp");
		r.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public int getLotInfNumCount () {
		String select="select count(*) from lotto_info_tbl02";
		int num = -1;
		Connection con=null; PreparedStatement pstmt= null; 
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/xe","hr","hr");
			pstmt=con.prepareStatement(select);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				num=rs.getInt(1);
			}
			System.out.println("로또 테이블 정보 개수 조회 성공");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("로또 테이블 정보 개수 조회 실패");
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {
				
			}
		}
		return num;
	}
	public ArrayList<Lotnum> getLotInfPagesInf(String page) {
		String select="select lotto_seq, lotto_whom, lotto_grade"
				+ ", lotto_nums, dat from"
				+ " (select lotto_seq, lotto_whom, lotto_grade"
				+ ", lotto_nums, to_char(lotto_date, 'YY-MM-DD') dat, "
				+ "rownum rn from lotto_info_tbl02) "
				+ "where rn>? and rn<?";
		Connection con=null; PreparedStatement pstmt= null; 
		ResultSet rs = null; ArrayList<Lotnum> al = new ArrayList<Lotnum>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521/xe","hr","hr");
			pstmt = con.prepareStatement(select);
			Integer pageCount=1;
			if(page!=null) {
				pageCount = Integer.parseInt(page);
				
			}
			pstmt.setInt(1, (pageCount-1)*5);
			pstmt.setInt(2, (pageCount-1)*5+6);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Lotnum ltnm = new Lotnum();
				ltnm.setLotSeq(rs.getInt(1));
				ltnm.setName(rs.getString(2));
				ltnm.setGrade(rs.getString(3));
				ltnm.setNums(rs.getString(4));
				ltnm.setDate(rs.getString(5));
				al.add(ltnm);
			}
			System.out.println("페이지별 5개 로또 테이블 정보 조회 성공");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("페이지별 5개 로또 테이블 정보 조회 실패");
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {
				
			}
		}return al;
	}
}
