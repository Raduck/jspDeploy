package kr.or.ddit.locale;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocaleServlet
 */
@WebServlet("/localeServlet")
public class LocaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println(request.getParameter("locale"));
			String locale = request.getParameter("locale");
			locale = locale == null ? "ko" : locale;
			
			request.setAttribute("locale", locale);
		
		RequestDispatcher rd  = request.getRequestDispatcher("jsp/jstl/locale/localeSelect.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(req.getParameter("locale"));
		req.getRequestDispatcher("jsp/jstl/locale/localeSelect_LH.jsp").forward(req, resp);
	}

}
