package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class forwardServlet
 */
@WebServlet("/forwardServlet")
public class forwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ForwardServlet doGet");
		
		//forward.jsp로 위임
		//서버 내에서 다른 페이지나 서블릿에 요청하고 그 결과를 반환
		RequestDispatcher rd  = request.getRequestDispatcher("/jsp/forward.jsp");
		rd.forward(request, response);
	}


}
