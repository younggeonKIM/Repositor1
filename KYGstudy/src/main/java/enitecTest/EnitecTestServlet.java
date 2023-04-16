package enitecTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class enitecTestServlet
 */
@WebServlet("/enitecTestServlet")
public class EnitecTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnitecTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnitecCodingTest_C.main(null);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
class EnitecCodingTest_C {
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
//	
//	�Էµ� ���ڸ� ���ڿ� ������ ������ �� �ڷ� ����
//	
	public static void insertChar(char ch) {
		System.out.println(ch+" �� ����");
		for(int i =0; i<chBox.length; i++) {
			if(chBox[i]==' ') {
				chBox[i]=ch;
				break;
			}
		}
		printBox();
	}
//	
//	���� �ȿ� �ִ� ���ڸ� ã�Ƽ� ����
//	
	public static void findChar(char ch) {
		System.out.println(ch+" �� ����");
		int i; char imsi='&';
		for (i =0; i<chBox.length ; i++) {
			if(chBox[i]==ch) {
				int cnt=i;
				for( int a=0 ; a<=cnt ; a++ ) {
					chBox[a]=' ';
				}
			}
		}
		for (i=0; i<chBox.length ; i++) {
			for(int c=0; c<chBox.length-1 ; c++) {
				imsi=chBox[c];
				chBox[c]=chBox[c+1];
				chBox[c+1]=imsi;
			}
			if(chBox[0]!=' ') {
				break;
			}
		}
		printBox();
	}
//	
//	���� ������ Ȯ��
//	
	public static void printBox() {
		System.out.println("���: ");
		for(int i =0; i<chBox.length;i++) {
			System.out.println(chBox[i]+"");
		}
		System.out.println("\n");
	}
}