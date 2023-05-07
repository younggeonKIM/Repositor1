package june27;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssignmentJune27")
public class AssignmentJune27 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AssignmentJune27() {
        super();        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Clock time1= new Clock(11,11,11);
		System.out.println(time1.hour+"�� "+time1.minute+"�� "+time1.second+"��");
		Clock time=new Clock();
		System.out.println(time.hour+"�� "+time.minute+"�� "+time.second+"��");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
class Clock {
	int hour; int minute; int second;
	Clock (int hour, int minute, int second) {
		this.hour=hour; this.minute=minute; this.second=second; //this ������
	}
	Clock () {
		this (12,12,12); //this ������
	}
}
