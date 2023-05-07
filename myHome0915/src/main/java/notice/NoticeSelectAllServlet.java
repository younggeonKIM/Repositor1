package notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.CRUD;

@WebServlet("/NoticeSelectAllServlet")
public class NoticeSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeSelectAllServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNo=request.getParameter("PAGENO");
		//PAGENO 파라미터가 없는 경우 : 공지사항 목록을 눌렀을 때
		//PAGENO 파라미터가 있는 경우 : 목록에서 페이지번호를 눌렀을 때
		
		CRUD crud=new CRUD();
		int page=1;
		if(pageNo != null) {
			page=Integer.parseInt(pageNo);
		}
		List <Notice> al=crud.getAllNotice(page); 
		int totalCount=crud.getNoticeCount(); //전체글 개수
		int pageCount=totalCount/5; //정수 나누기 정수
		if(totalCount%5 !=0) {
			pageCount++;
		}
		
		//공지글 목록을 출력하는 JSP(noticeAll.jsp)로 전환
		//1.Redirect, 2.Forward
		request.setAttribute("AL", al);
		request.setAttribute("PAGES", pageCount);
		RequestDispatcher r=
				request.getRequestDispatcher
				("template.jsp?BODY=noticeAll.jsp");
		r.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
