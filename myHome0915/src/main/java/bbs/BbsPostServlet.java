package bbs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bbsPost.do")
public class BbsPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BbsPostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String title=request.getParameter("TITLE");
		String content=request.getParameter("CONTENT");
		//�۹�ȣ, �ۼ���(���ǿ��� ����), �ۼ���(sysdate)
		HttpSession sess=request.getSession();
		String id=(String)sess.getAttribute("LOGINID");
		CRUD crud = new CRUD();
		int seqno = crud.getMaxSeqno() + 1 ;
		
		BBS bbs= new BBS();
		bbs.setSeqno(seqno); bbs.setTitle(title);
		bbs.setWriter(id); bbs.setContent(content);
		
		int result=crud.putBBS(bbs);
		//�Խñ� ��� ������ ����ϴ� JSP(bbsResult.jsp)�� ��ȯ
		response.sendRedirect(
				"template.jsp?BODY=bbsResult.jsp?R="
											+result);
	}
}
