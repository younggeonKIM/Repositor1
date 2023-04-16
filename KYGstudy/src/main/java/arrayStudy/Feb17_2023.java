package arrayStudy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Feb17_2023
 */
@WebServlet("/Feb17_2023")
public class Feb17_2023 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feb17_2023() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayEx7.main(null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class ArrayEx5 {
	public static void main(String[] args) {
		int sum = 0; 			// 총점을 저장하기 위한 변수
		float average = 0f;		// 평균을 저장하기 위한 변수
		
		int [] score = {100, 88, 100,  100, 90};
		
		for(int i = 0; i<score.length ; i++) {
			sum += score[i];
		}
		average =sum / (float)score.length ; // 계산결과를 float로 얻기 위해서 형변환
		
		System.out.println("총점 : "+sum);
		System.out.println("평균 : "+average);
	}
}

class ArrayEx6 {
	public static void main(String[] args) {
		int [] score = {79, 88, 91, 33, 100, 55, 95};
		
		int max = score[0];	// 배열의 첫 번째 값으로 최대값을 초기화.
		int min = score[0]; // 배열의 첫 번째 값으로 최소값을 초기화.
		
		for(int i =1 ; i<score.length; i++) {
			if(score[i] > max) {
				max = score[i];
			}else if (score [i] < min) {
				min = score[i];
			}
		} // end of for
		
		System.out.println("최대값 :" + max);
		System.out.println("최소값 :" + min);
	} //end of main
} //end of class

class ArrayEx7 {
	public static void main(String[] args) {
		int [] numArr = new int[10];
		
		for(int i =0; i<numArr.length ; i++) {
			numArr[i]= i; 	// 배열을 0~9의 숫자로 초기화한다.
			System.out.print(numArr[i]);
		}
		System.out.println();
		
		for(int i = 0; i<100; i++) {
			int n = (int)(Math.random() * 10);	// 0~9중의 한 값을 임의로 얻는다.
			int tmp= numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = tmp;
		}
		
		for(int i = 0; i < numArr.length ; i++) {
			System.out.print(numArr[i]);
		}
	} // main의 끝
}