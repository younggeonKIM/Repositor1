package enitecTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnitecTest2Servlet
 */
@WebServlet("/EnitecTest2Servlet")
public class EnitecTest2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnitecTest2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnitecCodingTest_C2.main(null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
class EnitecCodingTest_C2 {
	private static char[] chBox=new char[10];
	
	public static void main(String args[]) {
		//A~J 초기 설정
		for(int i =0; i<chBox.length ; i++) {
			chBox[i]=Character.toChars(i+65)[0];
		}
		
		findChar('D'); //A B C D가 추출돼 E F G H I J가 출력
		insertChar('1'); //1이 맨 뒤로 입력돼 E F G H I J 1가 출력
		insertChar('2'); //2가 맨 뒤로 입력돼 E F G H I J 1 2가 출력
		insertChar('3'); //3이 맨 뒤로 입력돼 E F G H I J 1 2 3가 출력
		insertChar('4'); //4가 맨 뒤로 입력돼 E F G H I J 1 2 3 4가 출력
		insertChar('5'); //이미 10개가 모두 차있기 때문에 5는 입력이 되지 않음
		findChar('H'); //F G H가 추출되어 I J 1 2 3 4가 출력
		insertChar('A'); //A가 맨 뒤로 입력돼 I J 1 2 3 4 A가 출력
		insertChar('B'); //B가 맨 뒤로 입력돼 I J 1 2 3 4 A B가 출력
		findChar('2'); //I J 1 2가 추출돼 3 4 A B가 출력
	}
	public static void findChar(char c) {
		System.out.println(c+"를 추출");
		int index = -1;
		for(int i=0; i<chBox.length; i++) {
			if(chBox[i] == c) {
				index = i;
				break;
			}
		}
		int length = chBox.length;//총 배열의 길이
		int start = index+1;//4
		int end = index;//3
		char[] imsi = new char[length-index];
		for(int i=0; i < (length-index)-1; i++) {
			System.out.println(i+","+start);
			chBox[i] = chBox[start++];
		}
		for(int i=(10-(index+1)); i<10; i++) {
			chBox[i]='\u0000';
		}
		printBox();
	}
	public static void insertChar(char c) {
		System.out.println(c+"를 삽입");
		for(int i=0; i<chBox.length; i++) {
			if(chBox[i] == '\u0000') {
				chBox[i] = c;
				break;
			}
		}
		printBox();
	}
	public static void printBox() {
		System.out.println("결과: ");
		for(int i =0; i<chBox.length;i++) {
			System.out.println(chBox[i]+"");
		}
		System.out.println("\n");
	}
}
