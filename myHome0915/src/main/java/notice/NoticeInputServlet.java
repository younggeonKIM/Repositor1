package notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.CRUD;

@WebServlet("/noticeInput.do")
public class NoticeInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NoticeInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String title=request.getParameter("TITLE");
		String content=request.getParameter("CONTENT");
		HttpSession sess=request.getSession();
		String writer=(String)sess.getAttribute("MANAGER");
		
		CRUD crud=new CRUD();
		int seqno=crud.getNoticeMaxSeqno()+1;
		
		Notice notice=new Notice();
		notice.setSeqno(seqno);
		notice.setTitle(title);
		notice.setContent(content);
		notice.setId(writer);
		crud.putNotice(notice);
		
		//글번호 : 기존의 가장 큰 글번호 + 1
		//select max(seqno) from notice_tbl
		//작성자 : 세션에서 MANAGER를 찾는다.
		//session.getAttribute("MANAGER");
		//작성일 : 오라클의 sysdate 함수 사용
		//서블릿(공지글 전체 조회) 매핑
		response.sendRedirect("NoticeSelectAllServlet");
	}
}
