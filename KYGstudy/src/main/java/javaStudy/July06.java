package javaStudy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/July06")
public class July06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public July06() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpecialCharEx.main(null);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
class CharToCode {
	public static void main (String[] args) {
		char ch='A'; //char ch= 65;
		int code=(int)ch; //ch에 저장된 값을 int 타입으로 변환하여 저장.
		
		System.out.printf("%c=%d (%#x) %n", ch, code, code);
		char hch='가'; //char hch= 0xAC00;
		System.out.printf("%c=%d (%#x) %n", hch, (int)hch, (int)hch);
		
	}
}
class SpecialCharEx {
	public static void main (String[] args) {
		System.out.println('\''); // '''처럼 할 수 없음.
		System.out.println("abc\t123\b456"); // \b에 의해 3이 지워짐.
		System.out.println('\n'); // 개행(new line) 문자 출력하고 개행
		System.out.println("\"Hello\""); // 큰따옴표를 출력하려면 이렇게 함.
		System.out.println("c:\\"); 
	}
}