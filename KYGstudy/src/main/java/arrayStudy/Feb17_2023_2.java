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
		int[] code = {-4, -1, 3, 6, 11};	// 불연속적인 값들로 구성된 배열
		int[] arr = new int[10];
		
		for(int i = 0 ; i<arr.length ; i++) {
			int tmp = (int)(Math.random()*code.length);
			arr[i] = code[tmp];
		}
		
		System.out.println(Arrays.toString(arr));
	} // main의 끝
}

class ArrayEx10 {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		
		for(int i = 0; i<numArr.length; i++) {
			System.out.print(numArr[i] = (int)(Math.random()*10));
		}
		System.out.println();
		
		for(int i = 0; i<numArr.length-1 ; i++) {
			boolean changed = false; // 자리바꿈이 발생했는지를 체크한다.
			
			for(int j=0 ; j<numArr.length-1-i ; j++) {
				if(numArr[j]>numArr[j+1]) { // 옆의 값이 작으면 서로 바꾼다.
					int temp=numArr[j];
					numArr[j] = numArr[j+1];
					numArr[j+1]=temp;
					changed = true; 	// 자리바꿈이 발생했으니 changed를 true로.
				}
			} // end for j
			
			if(!changed) break; 		// 자리바꿈이 없으면 반복문을 벗어난다.
			
			for(int k = 0; k<numArr.length ; k++) {
				System.out.print(numArr[k]); // 정렬된 결과를 출력한다.
			}
			System.out.println();
		} // end for i
	} // main의 끝
}

class ArrayEx11 {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		int[] counter = new int[10];
		
		for(int i = 0; i<numArr.length ; i++) {
			numArr[i] = (int)(Math.random()*10); // 0~9의 임의의 수를 배열에 저장
			System.out.print(numArr[i]);
		}
		System.out.println();
		
		for(int i =0; i<numArr.length ; i++) {
			counter[numArr[i]]++;
		}
		
		for(int i = 0 ; i<numArr.length ; i++) {
			System.out.println( i +"의 개수 : "+counter[i]);
		}
	} // main의 끝
}