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
		
		//�۹�ȣ : ������ ���� ū �۹�ȣ + 1
		//select max(seqno) from notice_tbl
		//�ۼ��� : ���ǿ��� MANAGER�� ã�´�.
		//session.getAttribute("MANAGER");
		//�ۼ��� : ����Ŭ�� sysdate �Լ� ���
		//����(������ ��ü ��ȸ) ����
		response.sendRedirect("NoticeSelectAllServlet");
	}
}
