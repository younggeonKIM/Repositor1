package june23;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssignmentJune23")
public class AssignmentJune23 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AssignmentJune23() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JavaElementary javEle=new JavaElementary();
		int a=javEle.jang.youn.scor; int b=javEle.jang.chul.scor;
		int c=javEle.guk.min.scor; int d=javEle.guk.na.scor;
		int e=javEle.baek.doi.scor; int f=javEle.baek.gyo.scor;
		javEle.jang.t.Sum(a, b);
		javEle.jang.t.Aver();
		javEle.jang.t.Brief(a, b);
		javEle.guk.t.Sum(c, d);
		javEle.guk.t.Aver();
		javEle.guk.t.Brief(c, d);
		javEle.baek.t.Sum(e, f);
		javEle.baek.t.Aver();
		javEle.baek.t.Brief(e, f);
		javEle.pri.Sum(javEle); javEle.pri.Aver(javEle);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
class JavaElementary {
	JavaElementary () {}
	JangmiBan jang=new JangmiBan(); 
	GukhwaBan guk=new GukhwaBan();
	BaekhapBan baek =new BaekhapBan (); 
	Principal pri=new Principal();
}
class JangmiBan {
	JangmiBan () {}
	JangmiT t=new JangmiT(); YoungHee youn=new YoungHee();
	ChulSu chul=new ChulSu();
}
class GukhwaBan {
	GukhwaBan () {}
	GukhwaT t=new GukhwaT(); 
	MinSu min=new MinSu(); 
	NaNa na=new NaNa();
}
class BaekhapBan {
	BaekhapBan () {}
	BaekhapT t=new BaekhapT(); 
	DoIl doi=new DoIl(); 
	GyoungMin gyo=new GyoungMin();
}
class YoungHee {
	YoungHee () {}
	int scor=(int) (Math.random()*101);
	int getScore() {return scor;}
}
class ChulSu {
	ChulSu () {}
	
	
	int scor=(int) (Math.random()*101);
	int getScore() {return scor;}
}
class MinSu {
	MinSu () {}
	int scor=(int) (Math.random()*101);
	int getScore() {return scor;}
}
class NaNa {
	NaNa () {}
	int scor=(int) (Math.random()*101);
	int getScore() {return scor;}
}
class DoIl {
	DoIl () {}
	int scor=(int) (Math.random()*101);
	int getScore() {return scor;}
}
class GyoungMin {
	GyoungMin () {}
	int scor=(int) (Math.random()*101);
	int getScore() {return scor;}
}
class JangmiT {
	JangmiT () {}
	int sum=0;
	int Sum (int a, int b) {
		sum=a+b;
		return sum;
	}
	int aver=0;
	int Aver () {
		aver=sum/2;
		return aver;
	}
	void Brief (int a, int b) {
		System.out.println("장미반 점수 합계 : "+sum+" 장미반 점수 평균 : "
							+aver+" 영희 점수 : "+a+" 철수 점수 : "+b);
	}
}
class GukhwaT {
	GukhwaT () {}
	int sum=0;
	int Sum (int a, int b) {
		sum=a+b;
		return sum;
	}
	int aver=0;
	int Aver () {
		aver=sum/2;
		return aver;
	}
	void Brief (int a, int b) {
		System.out.println("국화반 점수 합계 : "+sum+" 국화반 점수 평균 : "
							+aver+" 민수 점수 : "+a+" 나나 점수 : "+b);
	}
}
class BaekhapT {
	BaekhapT () {}
	int sum=0;
	int Sum (int a, int b) {
		 sum=a+b;
		return sum;
	}
	int aver=0;
	int Aver () {
		 aver=sum/2;
		return aver;
	}
	void Brief (int a, int b) {
		System.out.println("백합반 점수 합계 : "+sum+" 백합반 점수 평균 : "
							+aver+" 도일 점수 : "+a+" 경민 점수 : "+b);
	}
}
class Principal {
	Principal () {}
	void MakeSum (JavaElementary jav) {
		int sum=jav.jang.youn.getScore()+jav.jang.chul.getScore()+
				jav.guk.min.getScore()+jav.guk.na.getScore()+
				jav.baek.doi.getScore()+jav.baek.gyo.getScore();
		System.out.println("초등학교 점수 합계 : "+sum);
	}
	void Sum (JavaElementary jav) {
		System.out.println ("초등학교 점수 합계 : "+(jav.jang.t.sum+jav.guk.t.sum+jav.baek.t.sum));
	}
	void Aver (JavaElementary jav) {
		System.out.println("초등학교 점수 평균 : "+(jav.jang.t.sum+jav.guk.t.sum+jav.baek.t.sum)/6);
	}
}
