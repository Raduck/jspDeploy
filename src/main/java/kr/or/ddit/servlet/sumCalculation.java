package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sumCaculation
 */
@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paraStart = request.getParameter("start");
		String paraEnd = request.getParameter("end");
		int start = Integer.parseInt(paraStart);
		int end = Integer.parseInt(paraEnd);
		int result = 0;
		
		for (int i = start+1; i < end; i++) {
			result += i;
		}
		//System.out.println(result);
		/*System.out.println(result);*/
		//request.getParameter 사용자가 보낸 파라미터를 받아오는 작업
		//request 객체에에 일시적으로 값을 저장하는 방법
		request.setAttribute("sumResult",result);
		
		//session에 sumResult를 저장한다.
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", result);
		
		RequestDispatcher rd =request.getRequestDispatcher("jsp/sumResult.jsp");
		rd.forward(request, response);
		
	}

}
