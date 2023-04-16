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
		//A~J �ʱ� ����
		for(int i =0; i<chBox.length ; i++) {
			chBox[i]=Character.toChars(i+65)[0];
		}
		
		findChar('D'); //A B C D�� ����� E F G H I J�� ���
		insertChar('1'); //1�� �� �ڷ� �Էµ� E F G H I J 1�� ���
		insertChar('2'); //2�� �� �ڷ� �Էµ� E F G H I J 1 2�� ���
		insertChar('3'); //3�� �� �ڷ� �Էµ� E F G H I J 1 2 3�� ���
		insertChar('4'); //4�� �� �ڷ� �Էµ� E F G H I J 1 2 3 4�� ���
		insertChar('5'); //�̹� 10���� ��� ���ֱ� ������ 5�� �Է��� ���� ����
		findChar('H'); //F G H�� ����Ǿ� I J 1 2 3 4�� ���
		insertChar('A'); //A�� �� �ڷ� �Էµ� I J 1 2 3 4 A�� ���
		insertChar('B'); //B�� �� �ڷ� �Էµ� I J 1 2 3 4 A B�� ���
		findChar('2'); //I J 1 2�� ����� 3 4 A B�� ���
	}
	public static void findChar(char c) {
		System.out.println(c+"�� ����");
		int index = -1;
		for(int i=0; i<chBox.length; i++) {
			if(chBox[i] == c) {
				index = i;
				break;
			}
		}
		int length = chBox.length;//�� �迭�� ����
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
		System.out.println(c+"�� ����");
		for(int i=0; i<chBox.length; i++) {
			if(chBox[i] == '\u0000') {
				chBox[i] = c;
				break;
			}
		}
		printBox();
	}
	public static void printBox() {
		System.out.println("���: ");
		for(int i =0; i<chBox.length;i++) {
			System.out.println(chBox[i]+"");
		}
		System.out.println("\n");
	}
}
