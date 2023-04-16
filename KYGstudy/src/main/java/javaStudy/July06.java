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
		int code=(int)ch; //ch�� ����� ���� int Ÿ������ ��ȯ�Ͽ� ����.
		
		System.out.printf("%c=%d (%#x) %n", ch, code, code);
		char hch='��'; //char hch= 0xAC00;
		System.out.printf("%c=%d (%#x) %n", hch, (int)hch, (int)hch);
		
	}
}
class SpecialCharEx {
	public static void main (String[] args) {
		System.out.println('\''); // '''ó�� �� �� ����.
		System.out.println("abc\t123\b456"); // \b�� ���� 3�� ������.
		System.out.println('\n'); // ����(new line) ���� ����ϰ� ����
		System.out.println("\"Hello\""); // ū����ǥ�� ����Ϸ��� �̷��� ��.
		System.out.println("c:\\"); 
	}
}