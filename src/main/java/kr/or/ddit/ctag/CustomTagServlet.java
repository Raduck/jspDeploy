package kr.or.ddit.ctag;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class CustomtagServlet
 */
@WebServlet("/Customtag")
public class CustomTagServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
  
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      //학생 1페이지 리스트 조회
      Map<String, Integer> map = new HashMap<String, Integer>();
      map.put("page", 1);
      map.put("pageSize", 10);
      
      //request 객체 속성 설정
      StudentServiceInf studentService = new StudentService();
      
      Map<String, Object> resultMap = studentService.getStudentPageList(map);
      request.setAttribute("studentList", (List<StudentVo>)resultMap.get("pageList"));
      
      //ctag.jsp로 전달(forward)
      request.getRequestDispatcher("/jsp/ctag/ctag.jsp").forward(request, response);
   }

}