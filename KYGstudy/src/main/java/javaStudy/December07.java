package javaStudy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/December07")
public class December07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public December07() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ThreadEx1.main(null);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class MyThread extends Thread {
	public void run() { System.out.println("���� �ٺ�");} //Thread Ŭ������ run() �� �������̵�
}

class MyThread2 implements Runnable {
	public void run() {System.out.println("���� �ٺ�");} //Runnable �������̽��� run() �� ����
}

class ThreadEx1 {
	public static void main(String args[]) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r); //������ Thread(Runnable target)
		
		t1.start();
		t2.start();
	}
}

class ThreadEx1_1 extends Thread {
	public void run() {
		for(int i = 0 ; i<5 ; i++ ) {
			System.out.println(getName()); //������ Thread�� getName() �� ȣ��
		}
	}
}

class ThreadEx1_2 implements Runnable {
	public void run() {
		for(int i =0 ; i<5 ; i++) {
			// Thread.currentThread() - ���� �������� Thread�� ��ȯ�Ѵ�.
			System.out.println(Thread.currentThread().getName());
		}
	}
}