package colFramStudy;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Jan01_2023
 */
@WebServlet("/Jan01_2023")
public class Jan01_2023 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jan01_2023() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VectorEx1.main(null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class VectorEx1 {
	public static void main(String[] args) {
		Vector v = new Vector(5);	// 용량(capacity)이 5인 Vector를 생성함.
		v.add("1");
		v.add("2");
		v.add("3");
		print(v);
		
		v.trimToSize(); // 빈 공간을 없앤다.(용량과 크기가 같아진다.)
		System.out.println("=== After trimToSize() ===");
		print(v);
		
		v.ensureCapacity(6);
		System.out.println("=== After ensureCapacity(6) ===");
		print(v);
		
		v.setSize(7);
		System.out.println("=== After setSize(7) ===");
		print(v);
		
		v.clear();
		System.out.println("=== After clear() ===");
		print(v);
	}
	
	public static void print(Vector v) {
		System.out.println(v);
		System.out.println("size :" + v.size());
		System.out.println("capacity :" + v.capacity());
	}
}