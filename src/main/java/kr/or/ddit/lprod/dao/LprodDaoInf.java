package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;

public interface LprodDaoInf {
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
	List<LprodVo> getLprodPageList(Map<String, Integer> map);
	
	/**
	 * 
	 * Method : getStudentToCntTest
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC23
	 * 변경이력 :
	 * Method 설명 : 학생 전체 건수 조회
	 */
	int getLprodTotCnt();
}
