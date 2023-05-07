package jul26;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/List1Servlet")
public class List1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public List1Servlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList al =new ArrayList();
		al.add("사과"); 
		al.add(100);
		al.add(3.14);
		al.add("토마토");
		al.add("홍길동");
		int count =al.size();
		System.out.println("저장된 데이터의 갯수: "+count);
		String a = (String) al.get(0);
		int b = (int) al.get(1); double c = (double) al.get(2); 
		String d = (String) al.get(3); String e = (String) al.get(4);
		System.out.println(a+", "+b+", "+c+", "+d+", "+e);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
