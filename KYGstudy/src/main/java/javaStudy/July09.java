package javaStudy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/July09")
public class July09 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public July09() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FloatToBinEx.main(null);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
class OverflowEx {
	public static void main(String[] args) {
		short sMin = -32768;
		short sMax = 32767;
		char cMin=0;
		char cMax= 65535;
		
		System.out.println("sMin = " + sMin);
		System.out.println("sMin-1 = " + (short)(sMin-1));
		System.out.println("sMax = " + sMax);
		System.out.println("sMax+1 = " +(short)(sMax+1));
		System.out.println("cMin = " + (int)cMin);
		System.out.println("cMin-1 = " + (int)--cMin);
		System.out.println("cMax = " + (int)cMax);
		System.out.println("cMax+1 = " + (int)++cMax);		
	}
}
class FloatEx1 {
	public static void main(String[] args) {
		float f = 9.12345678901234567890f;
		float f2= 1.2345678901234567890f;
		double d=9.12345678901234567890d;
		
		System.out.printf("      1234567890"
				+"12345678901234%n");
		System.out.printf("f  : %f%n", f);
		System.out.printf("f  : %24.20f%n", f);
		System.out.printf("f2 : %24.20f%n", f2);
		System.out.printf("d  : %24.20f%n", d);
	}
}
class FloatToBinEx {
	public static void main(String args[]) {
		float f = 9.1234567f;
		int i = Float.floatToIntBits(f);
		
		System.out.printf("%f%n", f);
		System.out.printf("%X%n", i); // 16진수로 출력
	} // main의 끝
}