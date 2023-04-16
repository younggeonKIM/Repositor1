package colFramStudy;

import java.io.IOException;
import java.util.*;

import javax.print.attribute.standard.PrinterInfo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class December28
 */
@WebServlet("/December28")
public class December28 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public December28() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayListEx2.main(null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class ArrayListEx1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer (5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1, list2);
		
		Collections.sort(list1);	// list1과 list2를 정렬함.
		Collections.sort(list2);	// Collections.sort(List 1)
		print(list1, list2);
		
		System.out.println("list1.containsAll(list2):" + list1.containsAll(list2));
		
		list2.add("B");
		list2.add("C");
		list2.add(3, "A");
		print(list1, list2);
		
		list2.set(3, "AA");
		print(list1, list2);
		
		// list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제함.
		System.out.println("list1.retainAll(list2):" + list1.retainAll(list2));
		print(list1, list2);
		
		// list2에서 list1에 포함된 객체들을 삭제함.
		for(int i = list2.size()-1 ; i>=0 ; i--) {
			if(list1.contains(list2.get(i))) {
				list2.remove(i);
			}	
		}
		print(list1, list2);
	} //main의 끝
	
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		System.out.println();
	}
}

class ArrayListEx2 {
	public static void main(String[] args) {
		final int LIMIT =10; 		// 자르고자 하는 글자의 개수를 지정한다.
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();
		
		List list = new ArrayList(length/LIMIT + 10);// 크기를 약간 여유있게 잡는다.
		
		for(int i = 0; i< length; i+=LIMIT) {
			if(i+LIMIT < length ) {
				list.add(source.substring(i, i+LIMIT));
			} 
			else { list.add(source.substring(i));
			}
		}
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}