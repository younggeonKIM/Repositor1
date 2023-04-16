package javaStudy;

import java.io.IOException;
import java.util.*;
import java.text.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class December27_1
 */
@WebServlet("/December27_1")
public class December27_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public December27_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{MessageFormatEx4.main(null);} catch(Exception e) {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class MessageFormatEx4 {
	public static void main(String[] args) throws Exception {
		String tableName = "CUST_INFO";
		String fileName = "data4.txt";
		String msg = "INSERT INTO "+ tableName + " VALUES ({0}, {1}, {2}, {3});";
		
		Scanner s = new Scanner (new File(fileName));
		
		String pattern = "{0},{1},{2},{3}";
		MessageFormat mf = new MessageFormat(pattern);
		
		while(s.hasNextLine()) {
			String line = s.nextLine();
			Object[] objs = mf.parse(line);
			System.out.println(MessageFormat.format(msg, objs));
			
		}
		
		s.close(); // 작업이 끝났으니 Scanner에서 사용한 파일을 닫아 준다.
	} //main
}