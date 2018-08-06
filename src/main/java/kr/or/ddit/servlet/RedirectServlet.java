package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/redirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("redirect doGet");
		//servlet은 controller의 역할을 하는 객체로 로직과 화면을 연결해준다.
		//화면은 서블릿에서 직접 제어하지 않는다.
		
		//redirect를 통해 응답을 처리할 화면으로 이동하라고 브라우저에게 지시한다.
		response.sendRedirect("/jsp/redirect.jsp");
		
		//redirect의 쓰임
		//서버상의 상태가 변경되는 경우 
		// (ex : 게시판 글쓰기 - 게시글이 신규 생성된다.)
		// (ex : 게시판 업데이트 - 게시글이 수정 된다.)
	}
}
