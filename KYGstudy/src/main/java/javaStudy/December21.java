package javaStudy;

public class December21 {
	public static void main(String[] args) {
		char ch ='A';	//char ch=65;
		int code = (int)ch; 	//ch에 저장된 값을 int타입으로 변환해 저장.
		
		System.out.printf("%c=%d (%#X) %n" , ch, code, code);
		
		char hch = '가'; 	//char hch = 0xAC00;
		System.out.printf("%c=%d (%#X) %n", hch, (int)hch, (int)hch);
		
		char nu = '\u0000';
		int code2 = (int)nu;
		
		System.out.printf("%c=%d (%#X) %n", nu, code2, code2);
		
		int nul=16;
		System.out.printf("%c %d %o %x" , nul, nul, nul, nul);
	}
}
