package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;

import org.junit.Before;
import org.junit.Test;

public class LprodDaoTest {
	
	private LprodDaoInf lprdoDao;
	
	@Before
	public void set() {
		lprdoDao = new LprodDao();
	}
	
	
	@Test
	public void getLprodPageListTest() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);
		List<LprodVo> lprodList = lprdoDao.getLprodPageList(map);
		for (LprodVo vo : lprodList)
			System.out.println(vo);
		System.out.println("--------");

		/***Then***/
		assertEquals(10, lprodList.size());

	}
	
	@Test
	public void getLprodTotCntTest(){
		/***Given***/
		

		/***When***/
		int totCnt = lprdoDao.getLprodTotCnt();
		System.out.println(totCnt);
		System.out.println("----------");

		/***Then***/
		assertEquals(13, totCnt);

	}

}
