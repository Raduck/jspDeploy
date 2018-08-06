package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class StudentDao implements StudentDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	 * 
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.selectAllStudents");
		session.close();
		
		return studentList;
	}

	/**
	 * 
	 * Method : selectOneStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC23
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 : 아이디로 특정 학생 정보를 조회한다.
	 */
	@Override
	public StudentVo getStudent(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo oneStudent = session.selectOne("student.selectOneStudent", id);
		session.close();
		
		return oneStudent;
	}

	@Override
	public StudentVo getStudent(StudentVo studentvo) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo oneStudentVo = session.selectOne("student.selectOneStudentVo", studentvo);
		session.close();
		
		return oneStudentVo;
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
	@Override
	public List<StudentVo> getStudentPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.getStudentPageList", map);
		session.close();
		
		return studentList;
	}

	/**
	 * 
	 * Method : getStudentToCntTest
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC23
	 * 변경이력 :
	 * Method 설명 : 학생 전체 건수 조회
	 */
	@Override
	public int getStudentTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int totCnt = session.selectOne("student.getStudentTotCnt");
		session.close();
		
		return totCnt;
	}

	@Override
	public int studentUpdate(StudentVo studentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.update("student.studentUpdate",studentVo);
		session.commit();
		session.close();
		return result;
	}


}
