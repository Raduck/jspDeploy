package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.jasper.tagplugins.jstl.core.Out;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getMethod()); //놓침///////////////////////////////////////
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		//파라미터를 받아서 Sysout 으로 console 창에 출력
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		//로그인 프로세스
		//가짜 (fake) service, dao 객체를 생성
		UserServiceInf userService = new UserService();
		UserVo userVo = userService.getUser(userId);
		
		//userService 에서 받아온 userVo의 정보가 사용자가 입력한 정보가 동일할경우
		//로그인 성공시 : forward /main.jsp
		//로그인 실패시 : redirect login.jsp
		
		//로그인 성공시 userVo 객체를 저장해서 (전달한 영역에)
		//main.jsp에서 사용자 아이디를 화면에 출력
		//단 새로운 탭에서 main.jsp를 직접 접속해도 사용자 아이디가 화면에 나와야 한다.
 		if (userVo.validData(userId, password)) {
			// [로그인 성공] 메세지를 화면에 출력
			/*System.out.println(userVo.getUserNm()+"님 환영합니다 [로그인 성공]");
			pw.write(userVo.getUserNm()+"님 환영합니다 [로그인 성공]");*/
 			////////////////////////////////////////////////////////////////////////
 			
 			
 			
 			request.setAttribute("userId", request.getParameter("userId"));
 			request.setAttribute("password", request.getParameter("password"));
 			request.getSession().setAttribute("userVo", userVo);
 			request.getSession().setAttribute("userId", userVo.getUserId());
 			request.getSession().setAttribute("password", userVo.getPassword());
 			
 			request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
 			
 			
		}else{
		//정보가 틀릴경우
		// [로그인 실패] 메세지를 화면에 출력
		//System.out.println("[로그인 실패]");
		//pw.write("[로그인 실패]");
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		}
		//System.out.println("userId = "+userId);
		//System.out.println("password = "+password);
	}

}
