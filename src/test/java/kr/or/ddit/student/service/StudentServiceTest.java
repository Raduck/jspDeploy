package kr.or.ddit.student.service;

import static org.junit.Assert.*;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {
	
	// @Before --> @Test --> @After

	// 테스트 메소드 안에 중복되는 내용 : StudentService 구현체에 대한 생성 로직
	// --> @Before 어노테이션이 붙은 setup 메소드에 위임
	// 모든 테스트 메소드에서 StudentService 객체를 참조할 수 있게끔 클래스 변수로 생성할 필요가 있고
	// 클래스 변수를 setup메소드에서 초기화하는 로직이 필요
	// 테스트 메소드에서 StudentService를 생성하는 로직은 삭제

	private StudentServiceInf studentService;
	
	@Before
	public void setup() {
		studentService = new StudentService();
	}

	/**
	 * 
	 * Method : test
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC23
	 * 변경이력 :
	 * Method 설명 : 전체 학생 정보를 조회 테스트
	 */
	@Test
	public void selectAllStudentstest() {
		/***Given***/

		/***When***/
		List<StudentVo> studentList = studentService.selectAllStudents();

		for(StudentVo vo : studentList)
			System.out.println(vo);

		/***Then***/
		assertEquals(25, studentList.size());
	}
	
	/**
	 * 
	 * Method : getStudentTest
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC23
	 * 변경이력 :
	 * Method 설명 : 특정 학생 정보를 조회하는 테스트
	 */
	@Test
	public void getStudentTest(){
		/***Given***/

		/***When***/
		StudentVo oneStudent = studentService.getStudent(7);
		System.out.println(oneStudent);

		/***Then***/
		assertEquals(7, oneStudent.getId());
	}
	
	/**
	 * 
	 * Method : getStudentTest
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC23
	 * 변경이력 :
	 * Method 설명 : 특정 학생 정보를 조회하는 테스트
	 */
	@Test
	public void getStudentVoTest(){
		/***Given***/

		/***When***/
		StudentVo oneStudentVo = studentService.getStudent(studentService.getStudent(7));
		System.out.println(oneStudentVo);

		/***Then***/
		assertEquals(7, oneStudentVo.getId());
	}
	
	/**
	 * 
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 학생 페이지 리스트 조회
	 */
	@Test
	public void getStudentPageListTest(){
		
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 3);
		map.put("pageSize", 10);

		/***When***/ 
		Map<String, Object> resultMap = studentService.getStudentPageList(map);
		
		// 학생 페이지 리스트
		List<StudentVo> studentList = (List<StudentVo>) resultMap.get("pageList");
		
		// 학생 전체 건수
		int totCnt = (int) resultMap.get("totCnt");
		
		System.out.println("---------------");
		/***Then***/
		assertEquals(5, studentList.size());	// 학생 페이지 리스트 건수에 대한 검증
		assertEquals(25, totCnt);				//학생 전체 건수에 대한 검증
		
	}
	
	/**
	 * 
	 * Method : calculatePageNavi
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC23
	 * 변경이력 :
	 * Method 설명 : 전체 건수를 인자로 페이지 네비게이션 사이즈를 구하는 테스트
	 */
	@Test
	public void calculatePageNavi(){
		/***Given***/
		int totCnt = 25;
		int pageSize = 10;
		
		int cnt = totCnt / pageSize;	//몫
		int mod = totCnt % pageSize;	//나머지
		
		if (mod > 0) {
			cnt++;
		}

		/***When***/
		double naviSize = (totCnt / pageSize);
		System.out.println(Math.ceil((double)totCnt / (double)pageSize));

		/***Then***/
		assertEquals(3, cnt);
	}

}
