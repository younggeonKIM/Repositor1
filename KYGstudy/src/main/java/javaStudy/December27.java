package javaStudy;

import java.io.IOException;
import java.text.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class December27
 */
@WebServlet("/December27")
public class December27 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public December27() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{MessageFormatEx3.main(null);}
		catch(Exception e) {
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class MessageFormatEx2 {
	public static void main(String[] args) {
		String tableName = "CUST_INFO";
		String msg = "INSERT INTO "+ tableName + " VALUES (''{0}'',''{1}'',{2},''{3}'');";
		
		Object[][] arguments = {
				{"이자바","02-123-1234", "27", "07-09"},
				{"김프로","032-333-1234", "33", "10-07"},
		};
		
		for(int i =0 ; i<arguments.length ; i++) {
			String result = MessageFormat.format(msg, arguments[i]);
			System.out.println(result);
		}
	}
}

class MessageFormatEx3 {
	public static void main(String[] args) throws Exception {
		String[] data = {
				"INSERT INTO CUST_INFO VALUES ('이자바', '02-123-1234',27,'07-09');",
				"INSERT INTO CUST_INFO VALUES ('김프로', '032-333-1234',33,'10-07');"
		};
		
		String pattern = "INSERT INTO CUST_INFO VALUES ({0},{1},{2},{3});";
		MessageFormat mf = new MessageFormat(pattern);
		
		for(int i =0 ; i<data.length ; i++) {
			Object[] objs = mf.parse(data[i]);
			for(int j = 0 ; j<objs.length; j++) {
				System.out.print(objs[j] + ",");
			}
			System.out.println();
		}
	} //main
}
