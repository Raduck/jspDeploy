package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DefCompWrapper extends HttpServletRequestWrapper{
	private Map<String, String[]> map; 
	public DefCompWrapper(HttpServletRequest request) {
		super(request);
		//request.getParameter(name)
		//request.getParameterValues(name)
		//request.getParameterMap()
		//request.getParameterNames()
		
		//기존 request 객체의 파라미터 map 복사
		map = new HashMap<String, String[]>(request.getParameterMap());
		
		//defComp 파라미터를 확인하고 없으면 등록
		String[] defComps = map.get("defComp");
		
		//defComp 파라미터가 null 혹은 whiteSpace인 경우 --> 기본값으로 설정
		if(defComps == null || defComps[0].equals("")){
			map.put("defComp", new String[]{"defCompValue"});
		}
	}
	@Override
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		if(values!=null)
			return values[0];
		else
			return null;
		
	}
	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		//return super.getParameterMap();
		return map;
	}
	@Override
	public Enumeration<String> getParameterNames() {
		Collections.enumeration(map.keySet());
		
		return super.getParameterNames();
	}
	@Override
	public String[] getParameterValues(String name) {
		
		return map.get(name);
	}

}
