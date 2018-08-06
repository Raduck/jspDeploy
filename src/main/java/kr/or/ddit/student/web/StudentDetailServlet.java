package kr.or.ddit.student.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class StudentDetail
 */
@WebServlet("/studentDetail")
public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//학생 id 파라미터 확인
		int id = Integer.parseInt(request.getParameter("id"));
		
		//service 학생 정보를 조회
		StudentServiceInf studentService = new StudentService();
		StudentVo svo = studentService.getStudent(id);
		
		//request 객체에 저장
		request.setAttribute("studentVo", svo);
		
		// /student/studentDetail.jsp 로 위임
		request.getRequestDispatcher("/student/studentDetail.jsp").forward(request, response);
		
	}

}
