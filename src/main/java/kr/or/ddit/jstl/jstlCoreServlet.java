package kr.or.ddit.jstl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.student.model.StudentVo;

/**
 * Servlet implementation class jstlServlet
 */
@WebServlet("/jstlCoreServlet")
public class jstlCoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// client --> servlet 요청 전송 --> 로직 호출()
		// --> 로직 호출(service), 결과를 기본영역에 저장(request, sesion)
		// view로 화면 작성을 위임 (forward)
		
		// 사용자 : 웹 브라우저에 주소를 입력 localhost:8180/jstlServlet
		
		request.setAttribute("userId", "brown");
		request.setAttribute("studentVo", new StudentVo());
		//view로 위임
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/jstl/core.jsp");
		rd.forward(request, response);
	}
	

}
