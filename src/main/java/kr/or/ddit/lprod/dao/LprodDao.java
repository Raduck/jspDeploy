package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class LprodDao implements LprodDaoInf{
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	
	@Override
	public List<LprodVo> getLprodPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<LprodVo> lpList=session.selectList("lprod.getLprodPageList",map);
		session.close();
		return lpList;
	}

	@Override
	public int getLprodTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int totCnt = session.selectOne("lprod.getLprodTotCnt");
		session.close();
		return totCnt;
	}

}
