package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mulCalculation
 */
@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paraStart = request.getParameter("start");
		String paraEnd = request.getParameter("end");
		int start = Integer.parseInt(paraStart);
		int end = Integer.parseInt(paraEnd);
		int result = start*end;
		
	
		
	}

}
