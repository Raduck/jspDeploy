package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.dao.LprodDaoInf;
import kr.or.ddit.lprod.model.LprodVo;

public class LprodService implements LprodServiceInf {
		
	private LprodDaoInf lprodDao = new LprodDao();
	
	
	
	@Override
	public Map<String, Object> getLprodPageList(Map<String, Integer> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 학생 페이지 리스트 조회
		List<LprodVo> pageList = lprodDao.getLprodPageList(map);
		resultMap.put("pageList", pageList);

		// 학생 전체 건수 조회
		int totCnt = lprodDao.getLprodTotCnt();
		resultMap.put("totCnt", totCnt);

		// 페이지 네비게이션 html 생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");

		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));

		return resultMap;

	}

	private String makePageNavi(int page, int pageSize, int totCnt){
		int cnt = totCnt / pageSize;	//몫
		int mod = totCnt % pageSize;	//나머지
		
		if (mod > 0) {
			cnt++;
		}
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1 ? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		
		pageNaviStr.append("<li><a href=\"/lprodList?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		
		//for(int i = 0; i < cnt; i++)
		for (int i = 1; i <= cnt; i++) {
			///studentList?page=3&pageSize=10
			String activeClass = "";
		if ( i == page) 
			activeClass = "class=\"active\"";
			pageNaviStr.append("<li " + activeClass + "><a href=\"/lprodList?page=" + i +
					"&pageSize=" + pageSize + "\">" + i + "</a></li>");
		
//			else {
//			pageNaviStr.append("<li><a href=\"/studentList?page=" + i +
//					"&pageSize=" + pageSize + "\">" + i + "</a></li>");
//		}
			
		}
		
		pageNaviStr.append("<li><a href=\"/lprodList?page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		
		return pageNaviStr.toString();
	}
	
	
	
	

}
