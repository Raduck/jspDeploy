package kr.or.ddit.student.web;

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
 * Servlet implementation class StudentServlet
 */
@WebServlet("/studentList")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//링크를 통해 오는 것이기 때문에 doGet메서트를 쓴다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//StudentService 객체를 생성, 학생 전체 리스트를 조회
		//학생 전체 리스트 request객체에 속성으로 설정
		//studentList.jsp로 forward
		
		//page, pageSize 파라미터, 파라미터 값이 없을경우
		//기본값으로 page : 1, pageSize : 10
		
		String pageStr = request.getParameter("page");
		int page = pageStr == null? 1 : Integer.parseInt(pageStr);
		// int page = Integer.parseInt(request.getParameter("page"));
		
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = pageSizeStr == null? 10 : Integer.parseInt(pageSizeStr);
		//int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		// 학생 페이지 리스트, 전체 건수 조회
		StudentServiceInf studentService = new StudentService();
		
		Map<String, Object> resultMap = studentService.getStudentPageList(paramMap);
		//List<StudentVo> studentList = studentService.getStudentPageList(paramMap);
		// 기존 : List<StudentVo> studentList = studentService.selectAllStudents();
				
		//학생 페이지 리스트
		List<StudentVo> studentList = (List<StudentVo>) resultMap.get("pageList");
		request.setAttribute("studentList", studentList);
		
		//페이지 네비게이션 문자열
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		RequestDispatcher rd = request.getRequestDispatcher("/student/studentList.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
