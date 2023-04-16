package arrayStudy;

import java.io.IOException;
import java.util.*;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Feb17_2023_2
 */
@WebServlet("/Feb17_2023_2")
public class Feb17_2023_2 extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feb17_2023_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayEx11.main(null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class ArrayEx9 {
	public static void main(String[] args) {
		int[] code = {-4, -1, 3, 6, 11};	// �ҿ������� ����� ������ �迭
		int[] arr = new int[10];
		
		for(int i = 0 ; i<arr.length ; i++) {
			int tmp = (int)(Math.random()*code.length);
			arr[i] = code[tmp];
		}
		
		System.out.println(Arrays.toString(arr));
	} // main�� ��
}

class ArrayEx10 {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		
		for(int i = 0; i<numArr.length; i++) {
			System.out.print(numArr[i] = (int)(Math.random()*10));
		}
		System.out.println();
		
		for(int i = 0; i<numArr.length-1 ; i++) {
			boolean changed = false; // �ڸ��ٲ��� �߻��ߴ����� üũ�Ѵ�.
			
			for(int j=0 ; j<numArr.length-1-i ; j++) {
				if(numArr[j]>numArr[j+1]) { // ���� ���� ������ ���� �ٲ۴�.
					int temp=numArr[j];
					numArr[j] = numArr[j+1];
					numArr[j+1]=temp;
					changed = true; 	// �ڸ��ٲ��� �߻������� changed�� true��.
				}
			} // end for j
			
			if(!changed) break; 		// �ڸ��ٲ��� ������ �ݺ����� �����.
			
			for(int k = 0; k<numArr.length ; k++) {
				System.out.print(numArr[k]); // ���ĵ� ����� ����Ѵ�.
			}
			System.out.println();
		} // end for i
	} // main�� ��
}

class ArrayEx11 {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		int[] counter = new int[10];
		
		for(int i = 0; i<numArr.length ; i++) {
			numArr[i] = (int)(Math.random()*10); // 0~9�� ������ ���� �迭�� ����
			System.out.print(numArr[i]);
		}
		System.out.println();
		
		for(int i =0; i<numArr.length ; i++) {
			counter[numArr[i]]++;
		}
		
		for(int i = 0 ; i<numArr.length ; i++) {
			System.out.println( i +"�� ���� : "+counter[i]);
		}
	} // main�� ��
}