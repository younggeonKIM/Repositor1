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
			pstmt.setString(1, user.getTel());//��ȭ��ȣ
			pstmt.setString(2, user.getAddr());//�ּ�
			pstmt.setString(3, user.getEmail());//�̸���
			pstmt.setString(4, user.getJob());//����
			pstmt.setString(5, user.getId());//����
			pstmt.executeQuery();
			result="OK"; //���� ����
		}catch(Exception e) {
			e.printStackTrace();
			result="NOK"; //���� ����
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
			System.out.println("������ ��ȣ ��� ����");
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
			//������ ��ȣ�� �ִ´�.
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
			System.out.println("ȸ�� ���� ��ȸ�� ����.");
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
			pstmt.setString(1, user.getId()); //����
			pstmt.setString(2, user.getPwd()); //��ȣ
			pstmt.setString(3, user.getName()); //�̸�
			pstmt.setString(4, user.getTel()); //��ȭ��ȣ
			pstmt.setString(5, user.getAddr()); //�ּ�
			pstmt.setString(6, user.getGender()+""); //����
			pstmt.setString(7, user.getEmail()); //�̸���
			pstmt.setString(8, user.getJob()); //����
			pstmt.executeUpdate(); //����
			result="OK"; //���� ������ �ǹ�
		}catch(Exception e) {
			
			result="NOK"; //���� ���и� �ǹ�
			e.printStackTrace();
		}finally {
			try {
				con.close(); pstmt.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}//������ ���� �޼���
	
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
			//������ ��ȣ�� �ִ´�.
			int start=(pageNo-1)*5;
			int end=((pageNo-1)*5)+6;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery(); //��ȸ ����
			while(rs.next()) {
				Item it=new Item(); //DTO ����
				it.setId(rs.getString(1)); //��ǰ��ȣ
				it.setName(rs.getString(2)); //��ǰ�̸�
				it.setPric(rs.getInt(3)); //��ǰ����
				it.setOrig(rs.getString(4)); //�����ڵ�
				al.add(it); //ArrayList�� ��ȸ��� ����
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
		boolean result=false; //���� ���и� �ǹ�
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
			result=true; //���� ������ �ǹ�
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
		Notice notice=null; //��ȸ ��� ������ ���� ���� ����
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
				notice.setSeqno(rs.getInt(1)); //�۹�ȣ
				notice.setId(rs.getString(2)); //�ۼ���
				notice.setTitle(rs.getString(3)); //����
				notice.setDate(rs.getString(4)); //�ۼ���
				notice.setContent(rs.getString(5)); //����
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
		//��ȸ ����� Notice�� ���,
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
			 //������ ��ȣ�� �ִ´�.
			int start=(pageNo-1)*5;
			int end=((pageNo-1)*5)+6;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs=pstmt.executeQuery(); //select ����
			while(rs.next()) {
				Notice not=new Notice();
				not.setSeqno(rs.getInt(1));//�۹�ȣ
				not.setId(rs.getString(2));//�ۼ���
				not.setTitle(rs.getString(3));//����
				not.setDate(rs.getString(4));//�ۼ���
				al.add(not); //Notice�� ArrayList�� ��´�.
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
			pstmt.setInt(1, n.getSeqno());//�۹�ȣ ����
			pstmt.setString(2, n.getId());//�ۼ��� ����
			pstmt.setString(3, n.getTitle());//���� ����
			pstmt.setString(4, n.getContent());//���� ����
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {
				
			}
		}
	}//������ ���
	
	int getSeqno() {
		int maxSeqno=-1; //���� ū �۹�ȣ�� ����� ����
		
		try {
			Class.forName(name);
			con = DriverManager.getConnection(
					db,"hr","hr");
			String select="select max(seqno) from notice_tbl";
			stmt=con.createStatement();
			rs=stmt.executeQuery(select); //select ����
			if (rs.next()) {//�˻� ����� �̵��� �Ǵ� ���
				maxSeqno=rs.getInt(1);
			}else {//�˻� ����� �̵��� �ȵǴ� ���
				maxSeqno=0;
			}
		}catch(Exception e) {
			e.printStackTrace(); //���� ������ �ַܼ� ��µȴ�.
		}finally {
			try {
				con.close();stmt.close();rs.close();
			}catch (Exception e) {
				
			}
		}
		return maxSeqno;
	}
}
