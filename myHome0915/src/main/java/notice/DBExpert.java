package notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import items.Item;
import users.User;

public class DBExpert {
	public DBExpert() {}
	final String name="oracle.jdbc.OracleDriver";
	final String db="jdbc:oracle:thin:@127.0.0.1:1521/xe";
	Connection con; Statement stmt; PreparedStatement pstmt;
	ResultSet rs; 
	//	ArrayList <Integer> al = new ArrayList <Integer>();
	//	al.add(100); 
	
	public String updateItem(Item it) {
		String update="update items_tbl set name=?, price=?, spec=? "
				+ "where id=?";
		String result="";
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, it.getName());
			pstmt.setInt(2, it.getPric());
			pstmt.setString(3, it.getSpec());
			pstmt.setString(4, it.getId());
			pstmt.executeUpdate();
			result="OK";
		}catch(Exception e) {
			e.printStackTrace();
			result="NOK";
		}finally {
			try {
				con.close(); pstmt.close();
			}catch (Exception e) {
				
			}
		}
		return result;
	}
	
	
	public String updateUser(User user) {
		String update="update users_tbl set phone=?, addr=?,"+
					"email=?, job=? where id=?";
		String result="";
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, user.getTel());//전화번호
			pstmt.setString(2, user.getAddr());//주소
			pstmt.setString(3, user.getEmail());//이메일
			pstmt.setString(4, user.getJob());//직업
			pstmt.setString(5, user.getId());//계정
			pstmt.executeQuery();
			result="OK"; //변경 성공
		}catch(Exception e) {
			e.printStackTrace();
			result="NOK"; //변경 실패
		}finally {
			try {
				con.close(); pstmt.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}
	
	public User USERS (String id) {
		String select ="select id, name, phone, addr, gender,"
				+ " email, job, to_char(entry_date, 'YYYY/MM/DD HH24:MI:SS')"
				+ " from users_tbl where id = ?";
		User us=null; 
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				us=new User();
				us.setId(rs.getString(1));
				
				us.setName(rs.getString(2));
				us.setTel(rs.getString(3));
				us.setAddr(rs.getString(4));
				us.setGender(rs.getString(5).charAt(0));
				us.setEmail(rs.getString(6));
				us.setJob(rs.getString(7));
				us.setEntry_date(rs.getString(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close(); pstmt.close(); rs.close();
			}catch(Exception e) {
				
			}
		}
		return us;
	}
	public int MemberTotalCount() {
		String select = "select count(*) from users_tbl";
		int count=-1;
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			stmt=con.createStatement();
			rs=stmt.executeQuery(select);
			if(rs.next()) {
				count=rs.getInt(1);
			}else {count=0;}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("페이지 번호 얻기 실패");
		}finally {
			try {
				rs.close(); stmt.close(); con.close();
			}catch(Exception e) {
				
			}
		}
		return count;
	}
	public ArrayList<User> getUserAll(String page){
		String select="select id, name, dat from "
				+ "(select id, name, dat, rownum rn from "
				+ "(select id, name, to_char(entry_date, 'YYYY/MM/DD HH24:MI:SS') dat "
				+ "from users_tbl)) "
				+ "where rn > ? and rn < ?";
		ArrayList<User> al=new ArrayList<User>();
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			pstmt=con.prepareStatement(select);
			Integer pageNo=1; 
			if (page!=null) {
				pageNo=Integer.parseInt(page);
			}
			//페이지 번호를 넣는다.
			int start=(pageNo-1)*5;
			int end=((pageNo-1)*5)+6;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				User user=new User();
				user.setId(rs.getString(1));
				
				user.setName(rs.getString(2));
				
				user.setEntry_date(rs.getString(3));
				
				al.add(user);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원 정보 조회에 실패.");
		}finally {
			try {
				con.close(); pstmt.close(); rs.close();
			}catch (Exception e) {
				
			}
		}
		return al;
	}
	
	public String putUser(User user) {
		String insert="insert into users_tbl values("
				+ "?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		String result="";
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setString(1, user.getId()); //계정
			pstmt.setString(2, user.getPwd()); //암호
			pstmt.setString(3, user.getName()); //이름
			pstmt.setString(4, user.getTel()); //전화번호
			pstmt.setString(5, user.getAddr()); //주소
			pstmt.setString(6, user.getGender()+""); //성별
			pstmt.setString(7, user.getEmail()); //이메일
			pstmt.setString(8, user.getJob()); //직업
			pstmt.executeUpdate(); //실행
			result="OK"; //삽입 성공을 의미
		}catch(Exception e) {
			
			result="NOK"; //삽입 실패를 의미
			e.printStackTrace();
		}finally {
			try {
				con.close(); pstmt.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}//가입자 삽입 메서드
	
	public String getLogId(String id) {
		String select="select id from users_tbl where id=?";
		String selectedLogId =null;
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				selectedLogId=rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); rs.close(); con.close();
			}catch(Exception e) {
				
			}
		}
		return selectedLogId;
	}
	
	public String getId(String id) {
		String select="select id from items_tbl "+
						"where id=?";
		String selectedId = null;
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				selectedId=rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close(); pstmt.close(); rs.close();
			}catch(Exception e) {
				
			}
		}
		return selectedId;
	}
	
	public Item getItem(String id) {
		String select="select * from items_tbl" +
						" where id=?";
		Item it=null;
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				it=new Item();
				it.setId(rs.getString(1));
				it.setName(rs.getString(2));
				it.setPric(rs.getInt(3));
				it.setSpec(rs.getString(4));
				it.setOrig(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close(); pstmt.close(); rs.close();
			}catch(Exception e) {
				
			}
		}
		return it;
	}
	public ArrayList<Item> getAllItems (String page) {
		String select="select id, name, price ,origin from "
				+ "(select id, name, price ,origin, rownum rn from ("
				+ "select id, name, price, origin from items_tbl))"
				+ "where rn > ? and rn < ?";
		ArrayList<Item> al=new ArrayList<Item>();
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			pstmt=con.prepareStatement(select);
			Integer pageNo=1; 
			if (page!=null) {
				pageNo=Integer.parseInt(page);
			}
			//페이지 번호를 넣는다.
			int start=(pageNo-1)*5;
			int end=((pageNo-1)*5)+6;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery(); //조회 실행
			while(rs.next()) {
				Item it=new Item(); //DTO 생성
				it.setId(rs.getString(1)); //상품번호
				it.setName(rs.getString(2)); //상품이름
				it.setPric(rs.getInt(3)); //상품가격
				it.setOrig(rs.getString(4)); //국가코드
				al.add(it); //ArrayList에 조회결과 저장
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close(); pstmt.close(); rs.close();
			}catch(Exception e) {
				
			}
		}
		return al;
	}
	
	public boolean putItem(Item it) {
		String insert="insert into items_tbl "+"values(?, ?, ?, ?, ?)";
		boolean result=false; //삽입 실패를 의미
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setString(1, it.getId());
			pstmt.setString(2, it.getName());
			pstmt.setInt(3, it.getPric());
			pstmt.setString(4, it.getSpec());
			pstmt.setString(5, it.getOrig());
			pstmt.executeUpdate(); 
			result=true; //삽입 성공을 의미
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}
	
	public ArrayList<String> getNations() {
		String select="select code from nation_code";
		ArrayList<String> al=new ArrayList<String>(); 
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			stmt=con.createStatement();
			rs=stmt.executeQuery(select);
			while(rs.next()) {
				al.add(rs.getString(1));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close(); stmt.close(); rs.close();
			}catch (Exception e) {
				
			}
		}
		return al;
	}
	public int selectItemsCount() {
		String select ="select count(*) from items_tbl";
		int count=-1;
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			stmt=con.createStatement();
			rs=stmt.executeQuery(select);
			if(rs.next()) {
				count=rs.getInt(1);
			}else {count=0;}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); stmt.close(); con.close();
			}catch(Exception e) {
				
			}
		}
		return count;
	}
	
	int selectTotalCount() {
		String select = "select count(*) from notice_tbl";
		int count=-1;
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			stmt=con.createStatement();
			rs=stmt.executeQuery(select);
			if(rs.next()) {
				count=rs.getInt(1);
			}else {count=0;}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); stmt.close(); con.close();
			}catch(Exception e) {
				
			}
		}
		return count;
	}
	
	Notice getNotice(String seqno) {
		String select="select seqno, id, title, "+
					"to_char(input_date, 'YYYY/MM/DD HH:MI:SS'), content "+
					"from notice_tbl where seqno=? ";
		Notice notice=null; //조회 결과 저장을 위한 변수 선언
		Connection con=null; PreparedStatement pstmt=null; ResultSet rs=null;
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setInt(1, Integer.parseInt(seqno));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				notice=new Notice();
				notice.setSeqno(rs.getInt(1)); //글번호
				notice.setId(rs.getString(2)); //작성자
				notice.setTitle(rs.getString(3)); //제목
				notice.setDate(rs.getString(4)); //작성일
				notice.setContent(rs.getString(5)); //내용
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close(); pstmt.close(); rs.close();
			}catch(Exception e) {
				
			}
		}
		return notice;
	}
	
	ArrayList <Notice> selectAllNotice(String page) {
		ArrayList <Notice> al=new ArrayList <Notice> ();
		//조회 결과를 Notice에 담고,
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
//			String select="select seqno, id, title, to_char(input_date, "
//					+ "'YY/MM/DD HH:MM:SS') "
//					+ "from notice_tbl order by seqno desc";
			String select="select seqno, id, title, d from "
					+ "(select seqno, id, title, d, rownum rn from "
					+ "(select seqno, id, title, to_char"
					+ "(input_date, 'YY/MM/DD HH24:MI:SS') d from notice_tbl"
					+ " order by seqno desc)) "
					+ "where rn > ? and rn < ?";
			pstmt=con.prepareStatement(select);
			Integer pageNo=1;
			if (page!=null) {
				pageNo=Integer.parseInt(page);
			}
			 //페이지 번호를 넣는다.
			int start=(pageNo-1)*5;
			int end=((pageNo-1)*5)+6;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery(); //select 실행
			while(rs.next()) {
				Notice not=new Notice();
				not.setSeqno(rs.getInt(1));//글번호
				not.setId(rs.getString(2));//작성자
				not.setTitle(rs.getString(3));//제목
				not.setDate(rs.getString(4));//작성일
				al.add(not); //Notice를 ArrayList에 담는다.
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{con.close(); stmt.close(); rs.close();}
			catch (Exception e) {}
		}
		return al;
	}
	
	void insertNotice (Notice n) {
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			String insert="insert into notice_tbl values("+
					"?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(insert);
			pstmt.setInt(1, n.getSeqno());//글번호 설정
			pstmt.setString(2, n.getId());//작성자 설정
			pstmt.setString(3, n.getTitle());//제목 설정
			pstmt.setString(4, n.getContent());//내용 설정
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {
				
			}
		}
	}//공지글 등록
	
	int getSeqno() {
		int maxSeqno=-1; //가장 큰 글번호가 저장될 변수
		
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			String select="select max(seqno) from notice_tbl";
			stmt=con.createStatement();
			rs=stmt.executeQuery(select); //select 실행
			if (rs.next()) {//검색 결과로 이동이 되는 경우
				maxSeqno=rs.getInt(1);
			}else {//검색 결과로 이동이 안되는 경우
				maxSeqno=0;
			}
		}catch(Exception e) {
			e.printStackTrace(); //예외 정보가 콘솔로 출력된다.
		}finally {
			try {
				con.close();stmt.close();rs.close();
			}catch (Exception e) {
				
			}
		}
		return maxSeqno;
	}
}
