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
		int sum = 0; 			// ������ �����ϱ� ���� ����
		float average = 0f;		// ����� �����ϱ� ���� ����
		
		int [] score = {100, 88, 100,  100, 90};
		
		for(int i = 0; i<score.length ; i++) {
			sum += score[i];
		}
		average =sum / (float)score.length ; // ������� float�� ��� ���ؼ� ����ȯ
		
		System.out.println("���� : "+sum);
		System.out.println("��� : "+average);
	}
}

class ArrayEx6 {
	public static void main(String[] args) {
		int [] score = {79, 88, 91, 33, 100, 55, 95};
		
		int max = score[0];	// �迭�� ù ��° ������ �ִ밪�� �ʱ�ȭ.
		int min = score[0]; // �迭�� ù ��° ������ �ּҰ��� �ʱ�ȭ.
		
		for(int i =1 ; i<score.length; i++) {
			if(score[i] > max) {
				max = score[i];
			}else if (score [i] < min) {
				min = score[i];
			}
		} // end of for
		
		System.out.println("�ִ밪 :" + max);
		System.out.println("�ּҰ� :" + min);
	} //end of main
} //end of class

class ArrayEx7 {
	public static void main(String[] args) {
		int [] numArr = new int[10];
		
		for(int i =0; i<numArr.length ; i++) {
			numArr[i]= i; 	// �迭�� 0~9�� ���ڷ� �ʱ�ȭ�Ѵ�.
			System.out.print(numArr[i]);
		}
		System.out.println();
		
		for(int i = 0; i<100; i++) {
			int n = (int)(Math.random() * 10);	// 0~9���� �� ���� ���Ƿ� ��´�.
			int tmp= numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = tmp;
		}
		
		for(int i = 0; i < numArr.length ; i++) {
			System.out.print(numArr[i]);
		}
	} // main�� ��
}