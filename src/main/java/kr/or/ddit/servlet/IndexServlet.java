package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		pw.write("<!DOCTYPE html>");
		pw.write("<html>");
		pw.write("<head>");
		pw.write("<meta charset=\"UTF-8\">");
		pw.write("<title>Insert title here</title>");
		pw.write("<style>");
		pw.write("");
		pw.write("td{");
		pw.write("		border : 1px solid green;");
		pw.write("}");
		pw.write("</style>");
		pw.write("</head>");
		pw.write("<body>");
		pw.write("hello, eclipse tomcat");
		pw.write("2018.07.20. 오후4시 15분");
		pw.write("<table>");
		for (int i = 1; i < 9; i++) {
			
			pw.write("<tr>");
			pw.write("<td>"+i+"단</td>");
			for (int j = 1; j < 9; j++) {
				
				pw.write("<td>"+i+"*"+j+"="+i*j+"</td>");
			}
			pw.write("</tr>");
		}
		pw.write("</table>");
		pw.write("</body>");
		pw.write("</html>");
		pw.write("");
		pw.close();
		
		
		
		
		
			
			
			
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
