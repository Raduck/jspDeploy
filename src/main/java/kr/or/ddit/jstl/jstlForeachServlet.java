package kr.or.ddit.jstl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class jstlForeachServlet
 */
@WebServlet("/jstlForeachServlet")
public class jstlForeachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. studentService.selectAllStudents()
		//2. request 객체에 list 데이터 저장 (studentList)
		//3. foreach.jsp 로 forward
		
		// 데이토 조회
		StudentServiceInf studentServie = new StudentService();
		List<StudentVo> stdList = studentServie.selectAllStudents();
		request.setAttribute("studentList", stdList);
		
		//foreach를 이용한 map 데이터 조회
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "brown");
		map.put("alias", "곰");
		map.put("id", "5");
		
		request.setAttribute("map", map);
		
		//foreach를 이용한 데이토 조회
		request.setAttribute("lineRangers", "brown,cony,sally,james,moon");
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/jstl/foreach.jsp");
		rd.forward(request, response);
		
	}

	

}
