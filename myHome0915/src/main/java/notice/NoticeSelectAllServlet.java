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
		//PAGENO �Ķ���Ͱ� ���� ��� : �������� ����� ������ ��
		//PAGENO �Ķ���Ͱ� �ִ� ��� : ��Ͽ��� ��������ȣ�� ������ ��
		
		CRUD crud=new CRUD();
		int page=1;
		if(pageNo != null) {
			page=Integer.parseInt(pageNo);
		}
		List <Notice> al=crud.getAllNotice(page); 
		int totalCount=crud.getNoticeCount(); //��ü�� ����
		int pageCount=totalCount/5; //���� ������ ����
		if(totalCount%5 !=0) {
			pageCount++;
		}
		
		//������ ����� ����ϴ� JSP(noticeAll.jsp)�� ��ȯ
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
