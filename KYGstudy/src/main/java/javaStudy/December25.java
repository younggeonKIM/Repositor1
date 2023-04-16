package javaStudy;

import java.io.IOException;
import java.text.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class December25
 */
@WebServlet("/December25")
public class December25 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public December25() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChoiceFormatEx2.main(null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class ChoiceFormatEx1 {
	public static void main(String[] args) {
		double[] limits = {60, 70, 80, 90};		// 낮은 값부터 큰 값의 순서로 적어야한다.
		// limits, grades간의 순서와 개수를 맞추어야 한다.
		String[] grades = {"D", "C", "B", "A"};
		
		int[] scores = { 100, 95, 88, 70, 52, 60, 70};
		
		ChoiceFormat form = new ChoiceFormat(limits, grades);
		
		for(int i = 0 ; i<scores.length ; i++) {
			System.out.println(scores[i] + ":" + form.format(scores[i]));
		}
	} // main
}

class ChoiceFormatEx2 {
	public static void main(String[] args) {
		String pattern = "60#D|70#C|80<B|90#A";
		int[] scores = {91, 90, 80, 88, 70, 52, 60};
		
		ChoiceFormat form = new ChoiceFormat(pattern);
		
		for(int i =0; i<scores.length; i++) {
			System.out.println(scores[i]+":"+form.format(scores[i]));
		}
	} //main
}