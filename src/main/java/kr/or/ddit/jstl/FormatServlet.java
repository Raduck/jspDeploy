package kr.or.ddit.jstl;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormatServlet
 */
@WebServlet("/formatServlet")
public class FormatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("number", 10000);
		request.setAttribute("numberStr", "10,000");
		
		request.setAttribute("today", new Date());
		request.setAttribute("todayStr", "2018.07.13");
		//view
		request.getRequestDispatcher("/jsp/jstl/format.jsp").forward(request, response);
	}

}
